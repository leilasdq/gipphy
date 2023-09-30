package com.example.giflist.ui

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.domain.usecase.gifs.GetAllGifsUseCase
import com.example.domain.usecase.gifs.model.GifImageDetail
import com.example.domain.usecase.gifs.model.Gifs
import com.example.domain.usecase.gifs.model.GifsImage
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flowOn

@OptIn(ExperimentalTestApi::class)
class GifListTestRobot(private val composeTestRule: ComposeContentTestRule) {

    private val useCase: GetAllGifsUseCase = mockk()
    private lateinit var viewModel: GifsListViewModel
    private lateinit var testPagingSource: TestPagingSource
    private var navigateToGifDetails: (String) -> Unit = mockk()

    companion object {
        const val DELAY_TO_SHOW_LIST = 2500L
        const val WAITING_DELAY = 5000L
    }

    fun createViewModel() {
        viewModel = GifsListViewModel(useCase)
    }

    fun mockNavigateToGifsDetails() {
        every { navigateToGifDetails(any()) } returns Unit
    }

    fun performClickOnGitItem() {
        navigateToGifDetails("1")
    }

    fun createGifsListScreen() {
        composeTestRule.setContent {
            GifsListScreen(
                viewModel = viewModel,
                onNavigateToDetailScreen = navigateToGifDetails
            )
        }
    }

    fun mockkPagingData(
        responseDelay: Long = 0L,
        emitEmptyResult: Boolean = false,
        returnErrorOnFirstPage: Boolean = false,
        returnErrorOnSecondPage: Boolean = false,
    ) {
        testPagingSource = TestPagingSource(
            responseDelay, emitEmptyResult, returnErrorOnFirstPage, returnErrorOnSecondPage
        )

        coEvery { useCase() } answers {
            Pager(
                config = PagingConfig(10),
                pagingSourceFactory = { testPagingSource }
            ).flow.flowOn(Dispatchers.IO)
        }
    }

    fun checkLoading() {
        composeTestRule.waitUntilExactlyOneExists(
            matcher = hasTestTag("loadingState"),
            timeoutMillis = WAITING_DELAY
        )
    }

    fun checkListShowing() {
        composeTestRule.waitUntilExactlyOneExists(
            matcher = hasTestTag("gifsList"),
            timeoutMillis = WAITING_DELAY
        )
        composeTestRule.waitUntilExactlyOneExists(
            matcher = hasTestTag("id: 1"),
            timeoutMillis = WAITING_DELAY
        )
    }

    fun checkClickingOnGif() {
        verify { navigateToGifDetails(any()) }
    }

    class TestPagingSource(
        private val responseDelay: Long,
        private val emitEmptyResult: Boolean,
        private val returnErrorOnFirstPage: Boolean,
        private val returnErrorOnSecondPage: Boolean,
    ) : PagingSource<Int, Gifs>() {
        override fun getRefreshKey(state: PagingState<Int, Gifs>): Int? = null

        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Gifs> {
            val key = params.key ?: 0
            val gifs = if (emitEmptyResult) {
                listOf()
            } else {
                buildList {
                    repeat(5) {
                        add(
                            Gifs(
                                id = "id: $it",
                                title = "title: $it",
                                username = "userName: $it",
                                rating = "rating: $it",
                                image = GifsImage(GifImageDetail("thumbnail"))
                            )
                        )
                    }
                }
            }
            val nextKey = if (key == 2) null else key + 1
            delay(responseDelay)
            if (returnErrorOnFirstPage || nextKey == 2 && returnErrorOnSecondPage) {
                return LoadResult.Error(Exception())
            }
            return LoadResult.Page(gifs, null, nextKey)
        }
    }
}
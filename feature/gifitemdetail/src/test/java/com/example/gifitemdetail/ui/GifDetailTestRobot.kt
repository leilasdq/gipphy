package com.example.gifitemdetail.ui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.common.GetResult
import com.example.domain.usecase.gifs.GetGifDetailsUseCase
import com.example.domain.usecase.gifs.model.GifImageDetail
import com.example.domain.usecase.gifs.model.Gifs
import com.example.domain.usecase.gifs.model.GifsImage
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.flow

class GifDetailTestRobot(private val composeTestRule: ComposeContentTestRule) {

    private val useCase: GetGifDetailsUseCase = mockk()
    private lateinit var viewModel: GifsDetailViewModel
    private val navigateBack: () -> Unit = mockk()

    companion object {
        const val SAMPLE_GIF_ID = "1"
        val SAMPLE_GIF_ITEM = Gifs(
            SAMPLE_GIF_ID,
            "test title",
            "test userName",
            "5",
            image = GifsImage(
                GifImageDetail("")
            )
        )
    }

    fun createViewModel() {
        viewModel = GifsDetailViewModel(useCase, SAMPLE_GIF_ID)
    }

    fun onBackButtonClicked() {
        every { navigateBack.invoke() } returns Unit
    }

    fun createDetailScreen() {
        composeTestRule.setContent {
            GifsDetailScreen(
                viewModel = viewModel,
                onNavigateBack = navigateBack
            )
        }
    }

    fun loadingWillShownWhenMethodCalled() {
        every { useCase.invoke(args = any()) } returns flow {
            emit(GetResult.Loading)
        }
    }

    fun successGifDataPreparedForUser() {
        every { useCase.invoke(any()) } returns flow {
            emit(GetResult.Success(SAMPLE_GIF_ITEM))
        }
    }

    fun checkLoadingStateIsDisplayed() {
        composeTestRule.onNodeWithTag("loadingState").assertIsDisplayed()
    }

    fun checkNoLoadingStateIsDisplayed() {
        composeTestRule.onNodeWithTag("loadingState").assertDoesNotExist()
    }

    fun checkUiShownItemsAreSameAsSampleItem() {
        composeTestRule.onNodeWithText("test title").assertExists()
        composeTestRule.onNodeWithText("test userName").assertExists()
        composeTestRule.onNodeWithText("5").assertExists()
    }

    fun checkIsTopBarDisplay() {
        composeTestRule.onNodeWithTag("topbar").assertIsDisplayed()
    }

    fun performBackClicked() {
        composeTestRule.onNodeWithTag("topbarBackIcon").assertExists()
        composeTestRule.onNodeWithTag("topbarBackIcon").performClick()
    }

    fun checkIfBackButtonClicked() {
        verify { navigateBack.invoke() }
    }
}
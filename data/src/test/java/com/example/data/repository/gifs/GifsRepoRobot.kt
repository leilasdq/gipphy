package com.example.data.repository.gifs

import com.example.common.GetResult
import com.example.domain.usecase.gifs.model.Gifs
import com.example.remote.dto.GifImageDetailDto
import com.example.remote.dto.GifImageDto
import com.example.remote.dto.GifsDto
import com.example.remote.service.GetGifsService
import com.example.remote.utils.GiffyResponseWrapper
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import java.lang.Exception
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue

class GifsRepoRobot {

    private val service: GetGifsService = mockk()
    private val gifsRepo = GetGifsRepositoryImpl(service)
    private lateinit var gifDetail: Gifs
    private var hasException = false


    companion object {
        val SAMPLE_GIF_DETAIL = GifsDto(
            id = "1",
            title = "title",
            username = "name",
            rating = "4",
            images = GifImageDto(GifImageDetailDto(""))
        )
    }

    fun callGettingGifDetail() = runTest {
        gifsRepo.getGifDetail("1").collect {
            when (it) {
                is GetResult.Success -> gifDetail = it.data
                is GetResult.Error -> hasException = true
                else -> {}
            }
        }
    }


    fun getSuccessGifDetailData() {
        coEvery { service.getGifDetail(any()) } answers {
            GiffyResponseWrapper(listOf(SAMPLE_GIF_DETAIL))
        }
    }

    fun getErrorGifDetailData() {
        coEvery { service.getGifDetail(any()) } answers {
            throw Exception("fake test error")
        }
    }

    fun checkGettingGifDetailIsSuccess() {
        assertEquals(SAMPLE_GIF_DETAIL.id, "1")
        assertEquals(SAMPLE_GIF_DETAIL.title, "title")
        assertEquals(SAMPLE_GIF_DETAIL.rating, "4")
        assertFalse(hasException)
    }

    fun checkGettingGifDetailHasFailed() {
        assertTrue(hasException)
    }
}
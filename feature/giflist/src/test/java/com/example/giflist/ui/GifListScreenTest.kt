package com.example.giflist.ui

import androidx.compose.ui.test.junit4.createComposeRule
import com.example.giflist.ui.GifListTestRobot.Companion.DELAY_TO_SHOW_LIST
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class GifListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private val robot = GifListTestRobot(composeTestRule)

    @Test
    fun `at first step, loading will display`() {
        with(robot) {
            mockkPagingData(responseDelay = DELAY_TO_SHOW_LIST)
            createViewModel()
            createGifsListScreen()
            checkLoading()
        }
    }
    @Test
    fun `after list is ready to show, list will show`() {
        with(robot) {
            mockkPagingData()
            createViewModel()
            createGifsListScreen()
            checkListShowing()
        }
    }
    @Test
    fun `after click on a single gif, we will navigate to it`() {
        with(robot) {
            mockkPagingData()
            createViewModel()
            createGifsListScreen()
            mockNavigateToGifsDetails()
            performClickOnGitItem()
            checkClickingOnGif()
        }
    }
}
package com.example.gifitemdetail.ui

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class GifsDetailScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val robot = GifDetailTestRobot(composeTestRule)

    @Test
    fun `at first step, loading will show`() {
        with(robot) {
            loadingWillShownWhenMethodCalled()
            createViewModel()
            createDetailScreen()
            checkLoadingStateIsDisplayed()
        }
    }

    @Test
    fun `after gif detail get success data, loading should gone and data should be in ui`() {
        with(robot) {
            successGifDataPreparedForUser()
            createViewModel()
            createDetailScreen()
            checkUiShownItemsAreSameAsSampleItem()
            checkNoLoadingStateIsDisplayed()
        }
    }

    @Test
    fun `by click on back button in topBar, navigate up will perform`() {
        with(robot) {
            successGifDataPreparedForUser()
            createViewModel()
            createDetailScreen()
            onBackButtonClicked()
            checkIsTopBarDisplay()
            performBackClicked()
            checkIfBackButtonClicked()
        }
    }
}
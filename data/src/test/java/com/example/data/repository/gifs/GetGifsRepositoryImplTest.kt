package com.example.data.repository.gifs

import org.junit.Test


class GetGifsRepositoryImplTest {

    private val robot = GifsRepoRobot()

    @Test
    fun `call gif detail with success answer, repo will get successful data`() {
        with(robot) {
            getSuccessGifDetailData()
            callGettingGifDetail()
            checkGettingGifDetailIsSuccess()
        }
    }
    @Test
    fun `call gif detail with error answer, exception will throw`() {
        with(robot) {
            getErrorGifDetailData()
            callGettingGifDetail()
            checkGettingGifDetailHasFailed()
        }
    }
}
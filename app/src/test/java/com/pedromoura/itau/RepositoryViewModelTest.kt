package com.pedromoura.itau

import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RepositoryViewModelTest {

    /*@get:Rule
    var testSchedulerRule = RxImmediateSchedulerRule()

    private val view: LoanSuccessContract.View = mockk(relaxed = true)
    private val repository: LoanRepository = mockk(relaxed = true)
    private val tracker: LoanSuccessTracker = mockk(relaxed = true)
    private val successData: LoanSuccessModel = mockk(relaxed = true)
    private val actionHome = LoanButtonActionEnum.HOME
    private val actionLink = LoanButtonActionEnum.LINK
    private val actionShelf = LoanButtonActionEnum.SHELF
    private val actionInvalid = LoanButtonActionEnum.INVALID
    private val fakeLink = "www.google.com.br"
    private val fakeID = "135"

    private lateinit var presenter: LoanSuccessPresenter

    @Before
    fun setup() {
        presenter = LoanSuccessPresenter(view, repository, tracker)
    }

    @Test
    fun `when init presenter then load data`() {
        presenter.init(successData, fakeID)

        verify {
            tracker.trackInitAppFlyer()
            view.showSuccess(successData)
        }
    }

    @Test
    fun `when user clicked in button and parameter for home`() {
        presenter.handleButtonClick(actionHome, null)

        verify {
            tracker.trackButtonGoToHomeClick()
            view.goToHome()
        }
    }

    @Test
    fun `when user clicked in button and parameter for link`() {
        presenter.handleButtonClick(actionLink, fakeLink)

        verify {
            tracker.trackButtonOpenLinkClick()
            view.openLink(fakeLink)
        }
    }

    @Test
    fun `when user clicked in button and parameter for link null`() {
        presenter.handleButtonClick(actionLink, null)

        verify {
            tracker.trackButtonOpenLinkClick()
            view.openLink("")
        }
    }

    @Test
    fun `when user clicked in button and parameter other`() {
        presenter.handleButtonClick(actionInvalid, null)

        verify {
            view.showUpdateDialog()
        }
    }

    @Test
    fun `when user clicked in button and parameter is SHELF should go to Shelf Screen`() {
        presenter.handleButtonClick(actionShelf, null)

        verify {
            view.goToShelf()
        }
    }

    @Test
    fun `when back pressed should go to home when action is HOME`() {
        presenter.actionEnum = LoanButtonActionEnum.HOME

        presenter.handleBackButtonClick()
        verify { view.goToHome() }
    }

    @Test
    fun `when back pressed should go to shelf when action is SHELF`() {
        presenter.actionEnum = LoanButtonActionEnum.SHELF

        presenter.handleBackButtonClick()
        verify { view.goToShelf() }
    }*/
}

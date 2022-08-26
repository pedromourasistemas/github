package com.pedromoura.itau.pull_request

import com.pedromoura.itau.data.GithubRepository
import com.pedromoura.itau.data.model.RepositoryModel
import com.pedromoura.itau.presentation.pull_request.PullRequestViewModel
import com.pedromoura.itau.presentation.repository.RepositoryViewModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.mockk.unmockkAll
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test

class PullRequestViewModelTest {

    @RelaxedMockK
    lateinit var dataRepository: GithubRepository
    lateinit var viewModel: PullRequestViewModel
    private var pullRequestViewModel: PullRequestViewModel = mockk(relaxed = true)

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = PullRequestViewModel(dataRepository)
    }

    @Test
    fun `test fetchData with result`() {
        every { dataRepository.getRepositories(1) } returns mockk()

        val state = viewModel.pullRequestResponse.value
        assertEquals(pullRequestViewModel, state)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}

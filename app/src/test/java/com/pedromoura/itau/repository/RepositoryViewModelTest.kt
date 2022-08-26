package com.pedromoura.itau.repository

import androidx.lifecycle.LiveData
import com.pedromoura.itau.data.GithubRepository
import com.pedromoura.itau.data.model.Owner
import com.pedromoura.itau.data.model.RepositoryModel
import com.pedromoura.itau.presentation.repository.RepositoryViewModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.mockk.unmockkAll
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RepositoryViewModelTest {

    @get:Rule
    val mockkRule = MockKAnnotations

    @RelaxedMockK
    lateinit var viewModel: RepositoryViewModel
    private var dataRepository: GithubRepository = mockk(relaxed = true)
    private var repositoryModel: RepositoryModel = mockk(relaxed = true)
    private var owner = Owner("pedromourasistemas", "http://picture_pedromoura.png")

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = RepositoryViewModel(dataRepository)
    }

    @Test
    fun `when call getRepositories with result success then sets repositoriesLiveData`() {
        // Arrange
        val repositories = listOf(
            RepositoryModel("Repositorio do Pedro",
                         "Repositorio do Pedro",
                        "Criado para representação!!!",
                                  owner,
                     150,
                         150)
        )


        //val resultSuccess = repositories

        // Action
        every { dataRepository.getRepositories(1) } returns mockk()

        // Assert
        val state = viewModel.repositoryResponse.value
        assertEquals(repositoryModel, state)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}
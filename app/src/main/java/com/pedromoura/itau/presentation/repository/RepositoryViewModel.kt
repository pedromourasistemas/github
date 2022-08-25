package com.pedromoura.itau.presentation.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pedromoura.itau.data.GithubRepository
import com.pedromoura.itau.data.model.RepositoryModel

class RepositoryViewModel(
    repository: GithubRepository
) : ViewModel() {

    var repositoryResponse: LiveData<List<RepositoryModel>> = MutableLiveData()

    init {
        repositoryResponse = repository.getRepositories(1)
    }

    fun getRepositories() : LiveData<List<RepositoryModel>> {
        return repositoryResponse
    }
}
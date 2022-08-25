package com.pedromoura.itau.presentation.pull_request

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pedromoura.itau.data.GithubRepository
import com.pedromoura.itau.data.model.PullRequestModel

class PullRequestViewModel(
    repository: GithubRepository
) : ViewModel() {

    var pullRequestResponse: LiveData<List<PullRequestModel>> = MutableLiveData()
    private val repositoryParam = repository

    init {
        //pullRequestResponse = repository.getPulls("", "")
    }

    fun getPulls(creator: String, repo: String) : LiveData<List<PullRequestModel>> {
        pullRequestResponse = repositoryParam.getPulls(creator, repo)
        return pullRequestResponse
    }
}
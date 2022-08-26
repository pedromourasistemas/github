package com.pedromoura.itau.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pedromoura.itau.data.model.Owner
import com.pedromoura.itau.data.model.PullRequestModel
import com.pedromoura.itau.data.model.RepositoryModel
import com.pedromoura.itau.data.response.PullRequestResponse
import com.pedromoura.itau.data.response.RepositoryResponse
import com.pedromoura.itau.utils.StringUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class GithubRepository() {

    private val repositoryResponse: MutableLiveData<List<RepositoryModel>> = MutableLiveData<List<RepositoryModel>>()

    fun getRepositories(page: Int) : LiveData<List<RepositoryModel>> {
        val retrofitClient = GithubService.getRetrofitInstance(StringUtils.URL_BASE)
        val endpoint = retrofitClient.create(GithubAPI::class.java)
        val callback = endpoint.getRepositories(page)

        val repositories: MutableList<RepositoryModel> = mutableListOf()

        callback.enqueue(object : Callback<RepositoryResponse> {
            override fun onResponse(call: Call<RepositoryResponse>, response: Response<RepositoryResponse>) {
                if (response.isSuccessful) {

                    val repoResp = response.body()

                    repoResp?.items?.forEach {
                            item ->
                        val name = item.name
                        val full_name = item.full_name
                        val description = item.description
                        val stargazers_count = item.stargazers_count
                        val forks_count = item.forks_count
                        val owner = Owner(item.owner.login, item.owner.avatar_url)

                        val repository = RepositoryModel(name, full_name, description, owner, stargazers_count, forks_count)

                        repositories.add(repository)
                    }

                    repositoryResponse.value = repositories
                }
            }

            override fun onFailure(call: Call<RepositoryResponse>, t: Throwable) {
                val error = t
                //Toast.makeText(getApplication(), "Ocorreu um erro na requisição!", Toast.LENGTH_SHORT).show()
            }
        })

        return repositoryResponse
    }

    var pullRequestResponse: MutableLiveData<List<PullRequestModel>> = MutableLiveData<List<PullRequestModel>>()

    fun getPulls(creator: String, repository: String) : LiveData<List<PullRequestModel>> {
        val retrofitClient = GithubService.getRetrofitInstance(StringUtils.URL_BASE)
        val endpoint = retrofitClient.create(GithubAPI::class.java)
        val callback = endpoint.getPullRequests(creator, repository)

        val pulls: MutableList<PullRequestModel> = mutableListOf()

        callback.enqueue(object : Callback<List<PullRequestResponse>> {
            override fun onResponse(call: Call<List<PullRequestResponse>>, response: Response<List<PullRequestResponse>>) {
                if (response.isSuccessful) {

                    val repoResp = response.body()

                    repoResp?.forEach {
                            item ->
                        val title = item.title
                        val description = item.body
                        val owner = Owner(item.user.login, item.user.avatar_url)

                        val pullRequest = PullRequestModel(title, description, owner)

                        pulls.add(pullRequest)
                    }

                    pullRequestResponse.value = pulls
                }
            }

            override fun onFailure(call: Call<List<PullRequestResponse>>, t: Throwable) {
                val error = t
                //Toast.makeText(getApplication(), "Ocorreu um erro na requisição!", Toast.LENGTH_SHORT).show()
            }
        })

        return pullRequestResponse
    }
}
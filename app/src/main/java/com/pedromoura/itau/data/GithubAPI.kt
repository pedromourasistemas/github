package com.pedromoura.itau.data

import com.pedromoura.itau.data.response.PullRequestResponse
import com.pedromoura.itau.data.response.RepositoryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubAPI {

    @GET(REPOSITORY)
    fun getRepositories(
        @Query("page") page: Int
    ) : Call<RepositoryResponse>

    @GET(PULL_REQUESTS)
    fun getPullRequests(
        @Path("creator") creator: String,
        @Path("repository") repository: String
    ) : Call<List<PullRequestResponse>>

    companion object {
        private const val BASE = "https://api.github.com"
        //const val REPOSITORY = "$BASE/search/repositories?q=language:Java&sort=stars&page=1"
        //const val REPOSITORY = "$BASE/search/repositories?q=language:Java&sort=stars&page={page}"
        const val REPOSITORY = "$BASE/search/repositories?q=language:Java&sort=stars&"
        const val PULL_REQUESTS = "$BASE/repos/{creator}/{repository}/pulls"
    }
}
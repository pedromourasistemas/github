package com.pedromoura.itau.di

import com.pedromoura.itau.data.GithubRepository
import com.pedromoura.itau.presentation.pull_request.PullRequestViewModel
import com.pedromoura.itau.presentation.repository.RepositoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val githubModule = module {
    single {
        GithubRepository()
    }

    viewModel {
        RepositoryViewModel(get())
    }

    viewModel {
        PullRequestViewModel(get())
    }
}
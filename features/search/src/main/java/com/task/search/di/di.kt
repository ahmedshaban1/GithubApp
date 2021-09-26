package com.task.search.di

import com.task.model.GithubRepoMapper
import com.task.search.data.GithubAPIService
import com.task.search.data.datasource.GithubRepositoryImpl
import com.task.search.data.datasource.local.GithubLocalDataSource
import com.task.search.data.datasource.local.GithubLocalDataSourceImpl
import com.task.search.data.datasource.remote.GithubrepoRemoteDataSource
import com.task.search.data.datasource.remote.GithubrepoRemoteDataSourceImpl
import com.task.search.domain.GetReposUseCase
import com.task.search.domain.GithubRepository
import com.task.search.domain.SearchReposUseCase
import com.task.search.presentation.GithubViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

// koin module to provide all github dependencies
@ExperimentalCoroutinesApi
val githubModule = module {
    viewModel { GithubViewModel(get(), get()) }

    factory {
        GetReposUseCase(get())
    }
    factory {
        SearchReposUseCase(get())
    }

    factory<GithubrepoRemoteDataSource> {
        GithubrepoRemoteDataSourceImpl(get())
    }

    factory<GithubLocalDataSource> {
        GithubLocalDataSourceImpl(get())
    }

    single<GithubRepository> {
        GithubRepositoryImpl(get(), get(), get())
    }

    single {
        GithubRepoMapper()
    }

    single {
        get<Retrofit>().create(GithubAPIService::class.java)
    }

}

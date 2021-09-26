package com.task.search.data.datasource.remote

import com.task.model.GithubSearchResponse


// interface class for all remote Githubrepo operations
interface GithubrepoRemoteDataSource {
    suspend fun search(query:String): GithubSearchResponse
}

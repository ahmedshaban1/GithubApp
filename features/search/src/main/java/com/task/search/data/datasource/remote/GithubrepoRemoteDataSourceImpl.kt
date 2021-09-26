package com.task.search.data.datasource.remote

import com.task.model.GithubSearchResponse
import com.task.search.data.GithubAPIService

// class thia implementing  all remote Github operations
class GithubrepoRemoteDataSourceImpl(val remote: GithubAPIService) : GithubrepoRemoteDataSource {
    override suspend fun search(query: String): GithubSearchResponse {
        return remote.search(query)
    }

}

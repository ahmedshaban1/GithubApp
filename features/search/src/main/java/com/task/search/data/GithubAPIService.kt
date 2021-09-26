package com.task.search.data

import com.task.model.GithubSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

// Github api service that has all remote operations
interface GithubAPIService {
    @GET("search/repositories")
    suspend fun search(@Query("q") query: String): GithubSearchResponse

}

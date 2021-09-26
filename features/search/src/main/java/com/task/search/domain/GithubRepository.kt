package com.task.search.domain

import com.task.model.GithubRepo
import com.task.remote.data.Resource
import kotlinx.coroutines.flow.Flow

// interface class contains all Github operation
interface GithubRepository {
    fun search(query: String): Flow<Resource<List<GithubRepo>>>
    fun getAll(): Flow<Resource<List<GithubRepo>>>
}

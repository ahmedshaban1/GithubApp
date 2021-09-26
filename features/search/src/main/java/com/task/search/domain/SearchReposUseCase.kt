package com.task.search.domain

import com.task.model.GithubRepo
import com.task.remote.data.Resource
import kotlinx.coroutines.flow.Flow

// useCase to get repos by query from remote
class SearchReposUseCase(private val repository: GithubRepository) {
    operator fun invoke(query: String): Flow<Resource<List<GithubRepo>>> {
        return repository.search(query)
    }
}

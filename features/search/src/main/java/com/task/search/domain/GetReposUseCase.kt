package com.task.search.domain

import com.task.model.GithubRepo
import com.task.remote.data.Resource
import kotlinx.coroutines.flow.Flow

// useCase to get repos  from local
class GetReposUseCase(private val repository: GithubRepository) {
    operator fun invoke(): Flow<Resource<List<GithubRepo>>> {
        return repository.getAll()
    }
}

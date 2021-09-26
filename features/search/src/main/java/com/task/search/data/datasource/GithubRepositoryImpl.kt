package com.task.search.data.datasource

import com.task.model.GithubRepo
import com.task.model.GithubRepoMapper
import com.task.model.GithubSearchResponse
import com.task.remote.NetworkBoundResource
import com.task.remote.data.Resource
import com.task.search.data.datasource.local.GithubLocalDataSource
import com.task.search.data.datasource.remote.GithubrepoRemoteDataSource
import com.task.search.domain.GithubRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow

// implementation of Github repository
@ExperimentalCoroutinesApi
class GithubRepositoryImpl(
    private val remoteDataSource: GithubrepoRemoteDataSource,
    private val localDataSource: GithubLocalDataSource,
    private val githubMapper: GithubRepoMapper
) : GithubRepository {


    override fun search(query: String): Flow<Resource<List<GithubRepo>>> {
        return object : NetworkBoundResource<GithubSearchResponse>() {
            override suspend fun remoteFetch(): GithubSearchResponse {
                return remoteDataSource.search(query)
            }

            override suspend fun saveFetchResult(data: GithubSearchResponse) {
                localDataSource.saveGithubRepos(data.items.map { githubMapper.mapToEntity(it) })
            }

            override suspend fun localFetch(): GithubSearchResponse {
                return null!!
            }

        }.asFlow().flatMapLatest { data -> map(data) }
    }

    override fun getAll(): Flow<Resource<List<GithubRepo>>> {
        return object : NetworkBoundResource<List<GithubRepo>>() {
            override suspend fun remoteFetch(): List<GithubRepo> {
                return listOf()
            }
            override suspend fun saveFetchResult(data: List<GithubRepo>) {}
            override suspend fun localFetch(): List<GithubRepo> {
                return localDataSource.getAllGithubRepos()
            }
            override fun shouldFetch() = false
        }.asFlow()
    }


    // transform data from GithubRepoRemote to GithubRepo
    private fun map(data: Resource<GithubSearchResponse>): Flow<Resource<List<GithubRepo>>> {
        return flow {
            val githubRepo = data.data?.items?.map { githubMapper.mapToEntity(it) }
            emit(Resource(status = data.status, data = githubRepo, messageType = data.messageType))
        }
    }
}

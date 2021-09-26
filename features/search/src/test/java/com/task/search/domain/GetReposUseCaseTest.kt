package com.task.search.domain

import com.task.remote.data.Resource
import com.task.search.helpers.BaseGithubTest
import io.mockk.coEvery
import io.mockk.coVerifyOrder
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

@InternalCoroutinesApi
@ExperimentalCoroutinesApi
class GetReposUseCaseTest : BaseGithubTest() {
    lateinit var sut: GetReposUseCase

    @Before
    fun setUp() {
        sut = GetReposUseCase(repository = githubRepository)
    }

    @Test
    fun `Given remote local, when GetRepos, then get loading - success`() {
        // arrange

        coEvery { githubRepository.getAll() } returns flow {
            emit(Resource.loading(data = null))
            emit(Resource.success(data = fakeGithubRepos))
        }

        // act
        runBlocking {
            sut().collect(collector = collectorList)
        }
        // assert
        coVerifyOrder {
            collectorList.emit(Resource.loading(data = null))
            collectorList.emit(Resource.success(data = fakeGithubRepos))
        }
    }

    @Test
    fun `Given remote local, when GetRepos, then get loading - error remote`() {
        // arrange
        coEvery { githubRepository.getAll() } returns flow {
            emit(Resource.loading(data = null))
            emit(Resource.error(data = null, error = messageType))
        }

        // act
        runBlocking {
            sut().collect(collector = collectorList)
        }
        // assert
        coVerifyOrder {
            collectorList.emit(Resource.loading(data = null))
            collectorList.emit(Resource.error(data = null, error = messageType))
        }
    }

}
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

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class SearchReposUseCaseTest : BaseGithubTest() {
    lateinit var sut: SearchReposUseCase
    private val query = "1233"

    @Before
    fun setUp() {
        sut = SearchReposUseCase(repository = githubRepository)
    }

    @Test
    fun `Given local query, when search, then get loading - success`() {
        // arrange
        coEvery { githubRepository.search(query) } returns flow {
            emit(Resource.loading(data = null))
            emit(Resource.success(data = fakeGithubRepos))
        }
        // act
        runBlocking {
            sut(query).collect(collector = collectorList)
        }
        // assert
        coVerifyOrder {
            collectorList.emit(Resource.loading(data = null))
            collectorList.emit(Resource.success(data = fakeGithubRepos))
        }
    }

    @Test
    fun `Given local query, when search, then get loading - error`() {
        // arrange
        coEvery { githubRepository.search(any()) } returns flow {
            emit(Resource.loading(data = null))
            emit(Resource.error(data = null, error = messageType))
        }
        // act
        runBlocking {
            sut(query).collect(collector = collectorList)
        }
        // assert
        coVerifyOrder {
            collectorList.emit(Resource.loading(data = null))
            collectorList.emit(Resource.error(data = null, error = messageType))
        }
    }
}
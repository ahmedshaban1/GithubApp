package com.task.search.helpers

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.task.browse.helpers.CoroutinesMainDispatcherRule
import com.task.common.MessageType
import com.task.model.GithubRepo
import com.task.remote.data.Resource
import com.task.search.data.datasource.FakeData
import com.task.search.domain.GithubRepository
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.FlowCollector
import org.junit.Rule

// base class contains basic values for each github repo operation test
@ExperimentalCoroutinesApi
open class BaseGithubTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutinesMainDispatcherRule = CoroutinesMainDispatcherRule()
    var githubRepository = mockk<GithubRepository>()
    var collector: FlowCollector<Resource<GithubRepo>> = mockk(relaxed = true)
    var collectorList: FlowCollector<Resource<List<GithubRepo>>> = mockk(relaxed = true)
    val fakeGithubRepos = FakeData.fakeGithubRepos(10)
    val messageType = MessageType.Toast(0, null)
}

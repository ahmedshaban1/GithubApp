package com.task.search.presentation.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.fragment.app.testing.launchFragmentInContainer
import com.adevinta.android.barista.assertion.BaristaListAssertions.assertDisplayedAtPosition
import com.adevinta.android.barista.assertion.BaristaRecyclerViewAssertions
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.task.model.GithubRepo
import com.task.remote.data.Resource
import com.task.search.FakeData.fakeGithubRepos
import com.task.search.R
import com.task.search.presentation.GithubViewModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest

class HomeFragmentTest : KoinTest {
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @RelaxedMockK
    private lateinit var viewModel: GithubViewModel

    private val testModule = module {
        viewModel(override = true) {
            viewModel
        }
    }

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        startKoin {
            loadKoinModules(listOf(testModule))
        }
    }

    @Test
    fun getGithubReposAndSuccessHasData() {
        // Arrange
        val testMutableStateFlow =
            MutableStateFlow<Resource<List<GithubRepo>>>(Resource.loading(data = null))
        every { viewModel.reposeStateFlow } returns testMutableStateFlow
        val expectedList = fakeGithubRepos(10)
        // Act
        launchFragmentInContainer<HomeFragment>()
        // Assert
        BaristaRecyclerViewAssertions.assertRecyclerViewItemCount(
            R.id.reposRv,
            expectedItemCount = 0
        )
        // Act
        testMutableStateFlow.value = Resource.success(expectedList)
        // Assert
        assertDisplayed(R.id.reposRv)
        BaristaRecyclerViewAssertions.assertRecyclerViewItemCount(
            R.id.reposRv,
            expectedItemCount = expectedList.size
        )
        assertDisplayedAtPosition(
            R.id.reposRv,
            0, R.id.nameTv,
            expectedList[0].name!!
        )
    }

    @Test
    fun getGithubReposAndSuccessNoData() {
        // Arrange
        val testMutableStateFlow =
            MutableStateFlow<Resource<List<GithubRepo>>>(Resource.loading(data = null))
        every { viewModel.reposeStateFlow } returns testMutableStateFlow
        // Act
        launchFragmentInContainer<HomeFragment>()
        // Assert
        BaristaRecyclerViewAssertions.assertRecyclerViewItemCount(
            R.id.reposRv,
            expectedItemCount = 0
        )
        // Act
        testMutableStateFlow.value = Resource.success(listOf())
        // Assert
        assertDisplayed(R.id.reposRv)
        BaristaRecyclerViewAssertions.assertRecyclerViewItemCount(
            R.id.reposRv,
            expectedItemCount = 0
        )
        assertDisplayed(R.id.errorTv)

    }

    @After
    fun teardown() {
        stopKoin()
    }
}

package com.task.search.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.model.GithubRepo
import com.task.remote.data.Resource
import com.task.search.domain.GetReposUseCase
import com.task.search.domain.SearchReposUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class GithubViewModel(
    val getReposUseCase: GetReposUseCase,
    val searchReposUseCase: SearchReposUseCase
) : ViewModel() {
    private val _searchReposStateFlow: MutableStateFlow<Resource<List<GithubRepo>>> =
        MutableStateFlow(Resource.init())

    val reposeSearchStateFlow: StateFlow<Resource<List<GithubRepo>>> = _searchReposStateFlow


    private val _reposStateFlow: MutableStateFlow<Resource<List<GithubRepo>>> =
        MutableStateFlow(Resource.init())

    val reposeStateFlow: StateFlow<Resource<List<GithubRepo>>> = _reposStateFlow


    fun search(query: String) {
        viewModelScope.launch {
            searchReposUseCase(query)
                .collect {
                    _searchReposStateFlow.value = it
                }
        }
    }

    fun getRepos(query: String) {
        viewModelScope.launch {
            getReposUseCase()
                .collect {
                    _reposStateFlow.value = it
                }
        }
    }
}
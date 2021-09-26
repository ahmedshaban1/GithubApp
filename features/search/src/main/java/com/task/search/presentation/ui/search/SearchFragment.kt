package com.task.search.presentation.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.task.common.BaseFragment
import com.task.common.gone
import com.task.common.visible
import com.task.model.GithubRepo
import com.task.remote.data.Resource
import com.task.search.databinding.FragmentSearchBinding
import com.task.search.presentation.GithubViewModel
import com.task.search.presentation.ui.GithubReposAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    val viewModel: GithubViewModel by viewModel()
    private val githubAdapter: GithubReposAdapter by lazy {
        GithubReposAdapter()
    }
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate

    override fun setup() {
        intRv()
        initSearchObservable()
        initSearchInput()
    }

    private fun initSearchObservable() {
        viewModel.reposeSearchStateFlow.asLiveData().observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.SUCCESS -> it.data?.let { results -> validateList(results) }
                Resource.Status.ERROR -> {
                    binding.loadingView.gone()
                    it.messageType?.let { it1 ->
                        uiCommunicator?.handleMessages(
                            it1
                        )
                    }
                }
                Resource.Status.LOADING -> {
                    binding.loadingView.visible()
                }
                else -> {
                }
            }
        })
    }

    // make edittext isFocusable
    private fun initSearchInput() {
        with(binding.searchET) {
            setIconifiedByDefault(true)
            isFocusable = true
            isIconified = false
            clearFocus()
            requestFocusFromTouch()
        }

        binding.searchET.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            // search if user type text and click search
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.search(query)
                return false
            }

            // empty list of user type nothing
            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isEmpty()) {
                    githubAdapter.submitList(listOf())
                }
                return false
            }
        })
    }

    // handle results and empty state
    private fun validateList(searchList: List<GithubRepo>) {
        binding.loadingView.gone()
        if (searchList.isNotEmpty())
            githubAdapter.submitList(searchList)
        else
            binding.errorTv.visible()
    }

    private fun intRv() {
        with(binding.searchResultsRv) {
            layoutManager =
                LinearLayoutManager(requireContext())
            adapter = githubAdapter
        }
    }
}
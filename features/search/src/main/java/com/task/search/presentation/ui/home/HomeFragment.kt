package com.task.search.presentation.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.task.common.BaseFragment
import com.task.common.visible
import com.task.model.GithubRepo
import com.task.remote.data.Resource.Status.SUCCESS
import com.task.search.databinding.FragmentHomeBinding
import com.task.search.presentation.GithubViewModel
import com.task.search.presentation.ui.GithubReposAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: GithubViewModel by viewModel()
    private val githubAdapter: GithubReposAdapter by lazy {
        GithubReposAdapter()
    }
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun setup() {
        intRv()
        initGetReposObservable()
    }

    private fun initGetReposObservable() {
        viewModel.reposeStateFlow.asLiveData().observe(viewLifecycleOwner, {
            if (it.status == SUCCESS) {
                it.data?.let { list -> validateList(list) }
            }
        })
        viewModel.getRepos()
    }

    // handle results and empty state
    private fun validateList(searchList: List<GithubRepo>) {
        if (searchList.isNotEmpty())
            githubAdapter.submitList(searchList)
        else
            binding.errorTv.visible()
    }

    private fun intRv() {
        with(binding.reposRv) {
            layoutManager =
                LinearLayoutManager(requireContext())
            adapter = githubAdapter
        }
    }
}
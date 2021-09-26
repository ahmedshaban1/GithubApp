package com.task.search.data.datasource.local

import com.task.local.dao.GithubDao
import com.task.model.GithubRepo
import com.task.search.data.datasource.local.GithubLocalDataSource

// class thia implementing  all local Github repos operations
class GithubLocalDataSourceImpl(private val local: GithubDao) : GithubLocalDataSource {
    override suspend fun getAllGithubRepos(): List<GithubRepo> {
        return local.getAllRepos()
    }

    override suspend fun saveGithubRepos(githubRepos: List<GithubRepo>) {
        local.insert(githubRepos)
    }

}

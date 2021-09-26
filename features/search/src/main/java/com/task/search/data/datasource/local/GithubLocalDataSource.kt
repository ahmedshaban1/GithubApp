package com.task.search.data.datasource.local

import com.task.model.GithubRepo

// interface class for all local Githubrepo operations
interface GithubLocalDataSource {
    suspend fun getAllGithubRepos(): List<GithubRepo>
    suspend fun saveGithubRepos(githubRepos: List<GithubRepo>)
}

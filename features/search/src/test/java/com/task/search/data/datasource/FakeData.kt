package com.task.search.data.datasource

import com.task.model.GithubRepo
import com.task.model.GithubRepoRemote

// support fake data for testing
object FakeData {

    fun getFakeGithubRepos(): GithubRepoRemote {
        return GithubRepoRemote(
            id = 1
        )
    }

    fun fakeGithubRepos(count: Int): ArrayList<GithubRepo> {
        val list: ArrayList<GithubRepo> = arrayListOf()
        for (i in 1..count) {
            list.add(GithubRepo(id = i))
        }
        return list
    }
}

package com.task.search

import com.task.model.GithubRepo

// support fake data for testing
object FakeData {


    fun fakeGithubRepos(count: Int): ArrayList<GithubRepo> {
        val list: ArrayList<GithubRepo> = arrayListOf()
        for (i in 1..count) {
            list.add(GithubRepo(id = i))
        }
        return list
    }
}

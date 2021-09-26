package com.task.model

// MapperClass to map GithubRepoRemote format to GithubRepo format
class GithubRepoMapper {
    fun mapToEntity(githubRepoRemote: GithubRepoRemote): GithubRepo {
        return GithubRepo(
            id = githubRepoRemote.id,
            name = githubRepoRemote.name,
            description = githubRepoRemote.description,
            avatarUrl = githubRepoRemote.owner?.avatarUrl
        )
    }
}

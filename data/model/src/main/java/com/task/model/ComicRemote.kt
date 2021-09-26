package com.task.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

// Model for remote response
data class Owner(@SerializedName("avatar_url") var avatarUrl: String?)
data class GithubRepoRemote(
    var id: Int,
    var name: String? = "",
    var description: String? = "",
    var owner: Owner? = null
)

// Database Entity
@Entity(tableName = "githubRepo")
data class GithubRepo(
    @PrimaryKey var id: Int = 0,
    var name: String? = "",
    var description: String? = "",
    var avatarUrl: String? = null

)

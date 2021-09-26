package com.task.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.task.model.GithubRepo

// Github repo dao class that hold all repos database operation
@Dao
interface GithubDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(githubRepo: List<GithubRepo>)

    @Query("select * from GITHUBREPO")
    suspend fun getAllRepos(): List<GithubRepo>


}

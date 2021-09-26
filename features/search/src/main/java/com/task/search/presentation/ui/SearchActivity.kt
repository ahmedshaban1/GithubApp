package com.task.search.presentation.ui

import android.view.LayoutInflater
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.task.common.BaseActivity
import com.task.search.R
import com.task.search.databinding.ActivitySearchBinding

class SearchActivity : BaseActivity<ActivitySearchBinding>() {

    override fun setUp() {
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_search)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_search, R.id.navigation_home
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override val bindingInflater: (LayoutInflater) -> ActivitySearchBinding
        get() = ActivitySearchBinding::inflate
}
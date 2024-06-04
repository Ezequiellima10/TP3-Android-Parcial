package com.example.appandoid

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.appandoid.databinding.ActivityMainBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    private val fragmentsNavigation = setOf(
        R.id.homeFragment,
        R.id.searchFragment,
        R.id.offersFragment,
        R.id.profileFragment,

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.contentMainInclude.customToolbar)
        navController = findNavController(R.id.nav_host_fragment_activity_main)
        val navView: BottomNavigationView = binding.navView
        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = fragmentsNavigation,
            fallbackOnNavigateUpListener = ::onSupportNavigateUp
        )
        binding.contentMainInclude.customToolbar.setupWithNavController(
            navController,
            appBarConfiguration
        )
        navView.setupWithNavController(navController)

        NavigationUI.setupActionBarWithNavController(this, navController, binding.drawerLayout)
        binding.navigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination: NavDestination, _ ->

            when (destination.id) {
                R.id.homeFragment,
                R.id.searchFragment,
                R.id.offersFragment,
                R.id.profileFragment,
                R.id.resultsFragment,
                -> {
                    navView.visibility = BottomNavigationView.VISIBLE
                    binding.contentMainInclude.customToolbar.visibility = MaterialToolbar.VISIBLE
                }

                else -> {
                    navView.visibility = BottomNavigationView.GONE
                    binding.contentMainInclude.customToolbar.visibility = View.GONE
                }

            }


        }
//        binding.txtCloseApp.setOnClickListener(View.OnClickListener {
//            finish()
//        })
//        loadPreferences();
    }
    override fun onSupportNavigateUp(): Boolean {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        return true;
    }

//    private fun loadPreferences() {
//        val prefs = PreferenceManager.getDefaultSharedPreferences(this);
//        if (prefs.getBoolean(getString(R.string.preference_night_mode_key), false)) {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//        } else {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//        }
//    }

}
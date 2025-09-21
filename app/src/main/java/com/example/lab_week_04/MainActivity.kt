package com.example.lab_week_04

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.navigation.NavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView  // ⬅️ Tambahkan ini

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
                    as NavHostFragment
        val navController = navHostFragment.navController

        // Top level destinations (drawer + bottom nav)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.listFragment,
                R.id.favoritesFragment,
                R.id.cafeFragment
            ),
            findViewById(R.id.drawer_layout)
        )

        setupActionBarWithNavController(navController, appBarConfiguration)

        // Drawer Navigation
        findViewById<NavigationView>(R.id.nav_view)
            ?.setupWithNavController(navController)

        // Bottom Navigation
        findViewById<BottomNavigationView>(R.id.bottom_nav)
            ?.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) ||
                super.onSupportNavigateUp()
    }
}

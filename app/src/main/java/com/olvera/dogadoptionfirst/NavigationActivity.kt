package com.olvera.dogadoptionfirst

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.olvera.dogadoptionfirst.config.AppPrefs
import com.olvera.dogadoptionfirst.databinding.ActivityNavigationBinding
import com.olvera.dogadoptionfirst.ui.login.LoginActivity
import com.olvera.dogadoptionfirst.ui.onboarding.OnBoardingActivity

class NavigationActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (AppPrefs(this).isFirstTimeLaunch()) {
            startActivity(Intent(this, OnBoardingActivity::class.java))
            finish()
        } else {
            AppPrefs(this@NavigationActivity).setFirstTimeLaunch(false)
        }

        setSupportActionBar(binding.appBarNavigation.toolbar)

        binding.appBarNavigation.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            // Cerrar sesión
            AppPrefs(this@NavigationActivity).setFirstTimeLaunch(true)
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_navigation)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val userEmail = AppPrefs(this).getEmail()
        val userName = AppPrefs(this).getUserName()
        navView.getHeaderView(0).findViewById<android.widget.TextView>(R.id.emailTV).text = userEmail
        navView.getHeaderView(0).findViewById<android.widget.TextView>(R.id.userTV).text = userName

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_navigation)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
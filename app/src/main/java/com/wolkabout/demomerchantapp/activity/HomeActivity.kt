package com.wolkabout.demomerchantapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.wolkabout.demomerchantapp.R
import com.wolkabout.demomerchantapp.databinding.ActivityHomeBinding
import com.wolkabout.demomerchantapp.fragment.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
//    private lateinit var navController: NavController

    private val dailyTurnoversFragment = DailyTurnoversFragment()
    private val reportsFragment = ReportsFragment()
    private val devicesFragment = DevicesFragment()
    private val alarmsFragment = AlarmsFragment()
    private val issueLocalTokensFragment = IssueLocalTokensFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navigationHost) as NavHostFragment
//        navController = navHostFragment.navController
//
//        setSupportActionBar(binding.toolbar)
//        setupActionBarWithNavController(navController)
//    }

//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }

        replaceFragment(dailyTurnoversFragment)
        binding.toolbar.title = "Daily turnovers"

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.ic_daily_turnovers -> {
                    replaceFragment(dailyTurnoversFragment)
                    binding.toolbar.title = "Daily turnovers"
                }
                R.id.ic_reports -> {
                    replaceFragment(reportsFragment)
                    binding.toolbar.title = "Reports"
                }
                R.id.ic_devices -> {
                    replaceFragment(devicesFragment)
                    binding.toolbar.title = "Devices"
                }
                R.id.ic_alarms -> {
                    replaceFragment(alarmsFragment)
                    binding.toolbar.title = "Alarms"
                }
                R.id.ic_issue_local_tokens -> {
                    replaceFragment(issueLocalTokensFragment)
                    binding.toolbar.title = "Issue local tokens"
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frameLayout, fragment)
            transaction.commit()
        }
    }
}


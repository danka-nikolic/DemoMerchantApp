package com.wolkabout.demomerchantapp.model

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.wolkabout.demomerchantapp.R
import com.wolkabout.demomerchantapp.databinding.ActivityHomeBinding
import com.wolkabout.demomerchantapp.fragment.*

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val dailyTurnoversFragment = DailyTurnoversFragment()
    private val reportsFragment = ReportsFragment()
    private val devicesFragment = DevicesFragment()
    private val alarmsFragment = AlarmsFragment()
    private val issueLocalTokensFragment = IssueLocalTokensFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(R.layout.activity_home)
        replaceFragment(dailyTurnoversFragment)

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_daily_turnovers -> replaceFragment(dailyTurnoversFragment)
                R.id.ic_reports -> replaceFragment(reportsFragment)
                R.id.ic_devices -> replaceFragment(devicesFragment)
                R.id.ic_alarms -> replaceFragment(alarmsFragment)
                R.id.ic_issue_local_tokens -> replaceFragment(issueLocalTokensFragment)
            }
            true
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


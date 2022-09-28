package com.example.upi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.customview.widget.Openable
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appbarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setting up toolbar
        setSupportActionBar(toolbar)
        appbarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment,R.id.blankFragment,R.id.settingFragment)
        ,drawer__layout)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.NavHost) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController,appbarConfiguration)

        bottomnav.setupWithNavController(navController)

        drawerlayout.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.about ->{
                val action = SettingFragmentDirections.actionGlobalAboutFragment()
                navController.navigate(action)
                return true
            }
            else ->
                return item.onNavDestinationSelected(navController)||super.onOptionsItemSelected(item)

        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }
}
package com.example.myautoofficina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    lateinit var nav: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val host =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        nav = host.navController


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private var number = R.id.menu_home_page_fragment

/*   override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_home_page_fragment)
            when (item.itemId) {
                R.id.menu_home_page_fragment -> nav.navigate(R.id.action_listCarFragment_to_homePageFragment)
                R.id.menu_home_page_fragment -> nav.navigate(R.id.action_listViewClientFragment_to_homePageFragment)
                R.id.menu_home_page_fragment -> nav.navigate(R.id.action_listInterventionsFragment_to_homePageFragment3)
            }
        return super.onOptionsItemSelected(item)
    }*/

}

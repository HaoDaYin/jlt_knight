package com.xlh.mr.knightapp

import android.databinding.DataBindingUtil
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.support.v4.widget.DrawerLayout
import android.support.design.widget.NavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.xlh.mr.knightapp.databinding.ActivityMainBinding
import com.xlh.mr.knightapp.fragment.MainPageFragment1
import com.xlh.mr.knightapp.fragment.MainPageFragment2
import com.xlh.mr.knightapp.fragment.MainPageFragment3
import android.util.Log
import android.widget.Toast
import androidx.navigation.NavController


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    MainPageFragment1.OnFragmentInteractionListener,
    MainPageFragment2.OnFragmentInteractionListener, MainPageFragment3.OnFragmentInteractionListener {


    lateinit var navController: NavController
    lateinit var binding: ActivityMainBinding
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)


//        val toolbar: Toolbar = findViewById(R.id.toolbar)
        val toolbar: Toolbar = binding.mainInclude.toolbar
        setSupportActionBar(toolbar)

//        val fab: FloatingActionButton = this.findViewById(R.id.fab)
        val fab: FloatingActionButton = binding.mainInclude.fab
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
//        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val drawerLayout: DrawerLayout = binding.drawerLayout
//        val navView: NavigationView = findViewById(R.id.nav_view)
        val navView: NavigationView = binding.navView
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        navController = Navigation.findNavController(this, R.id.my_nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, binding.drawerLayout)
        binding.navView.setNavigationItemSelectedListener(this)

//        setupNavMenu()


    }

    fun setupNavMenu() {

//
        binding.navView.setNavigationItemSelectedListener { it ->


            when (it.itemId) {
                R.id.nav_home -> {

                    Navigation.findNavController(it.actionView).navigate(R.id.action_main_page__to_main_page_1)
                    true
                }
                else -> false
            }
        }

    }




    override fun onSupportNavigateUp() = findNavController(R.id.my_nav_host_fragment).navigateUp()

//    override fun onSupportNavigateUp(): Boolean {
//        return findNavController(R.id.my_nav_host_fragment).navigateUp()
//    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.

        when (item.itemId) {
            R.id.nav_home -> {


                navController.navigate(R.id.action_main_page_1_to_main_page_2)
//                Navigation.findNavController(it).navigate(R.id.action_main_page__to_main_page_1)

//                startActivity(Intent(this@MainActivity,FreeActivity::class.java))

            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_tools -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}

package ru.egslava.rxfluxtest

import android.support.v4.view.GravityCompat.START
import android.support.v7.app.ActionBarDrawerToggle
import com.trello.navi.Event
import kotlinx.android.synthetic.main.activity_drawer.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_drawer.*

class DrawerActivity : BaseActivity() {

    val a = addListener(Event.CREATE){
        setContentView(R.layout.activity_drawer)
        setSupportActionBar(toolbar)


        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.setDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener{
            changeFragment()
            drawer_layout.closeDrawer(START)
            true
        }

        callGallery(image_from_galery)
        changeFragment()
    }

    private fun changeFragment() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_fragment, MainFragment())
                .commit()
    }

    override fun onBackPressed() = if (drawer_layout.isDrawerOpen(START)) drawer_layout.closeDrawer(START) else super.onBackPressed()
}

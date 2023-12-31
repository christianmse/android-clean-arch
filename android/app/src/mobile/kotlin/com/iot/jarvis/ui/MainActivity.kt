package com.iot.jarvis.ui

import android.os.Bundle
import android.view.LayoutInflater
import com.google.android.material.snackbar.Snackbar
import android.view.Menu
import android.view.MenuItem
import com.iot.common.ui.BaseActivity
import com.iot.jarvis.R
import com.iot.jarvis.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>(
    MainActivityViewModel::class
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun setUpViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
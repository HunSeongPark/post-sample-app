package hunseong.com.post_practice.screen.main

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.support.DaggerAppCompatActivity
import hunseong.com.post_practice.R
import hunseong.com.post_practice.databinding.ActivityMainBinding
import hunseong.com.post_practice.screen.my.MyFragment
import hunseong.com.post_practice.screen.post.PostFragment
import hunseong.com.post_practice.util.SingleLiveEvent
import javax.inject.Inject
import javax.inject.Named

class MainActivity : DaggerAppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener {

    @Inject
    @Named("errorEvent")
    lateinit var errorEvent: SingleLiveEvent<Throwable>

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        errorEvent.observe(this) {
            it?.printStackTrace()
            Toast.makeText(this, it?.message ?: "Unknown Error", Toast.LENGTH_SHORT).show()
        }
        initBottomNav()
    }

    private fun initBottomNav() = with(binding) {
        bottomNav.setOnItemSelectedListener(this@MainActivity)
        showFragment(PostFragment.newInstance(), PostFragment.TAG)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_home -> {
                showFragment(PostFragment.newInstance(), PostFragment.TAG)
                true
            }
            R.id.menu_my -> {
                showFragment(MyFragment.newInstance(), MyFragment.TAG)
                true
            }
            else -> false
        }
    }

    fun showFragment(fragment: Fragment, tag: String) {

        if (tag != PostFragment.TAG && tag != MyFragment.TAG) {
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment, tag)
                .addToBackStack(null).commitAllowingStateLoss()
            return
        }

        val findFragment = supportFragmentManager.findFragmentByTag(tag)
        supportFragmentManager.fragments.forEach {
            supportFragmentManager.beginTransaction().hide(it).commitAllowingStateLoss()
        }

        findFragment?.let {
            supportFragmentManager.beginTransaction().show(it).commitAllowingStateLoss()
        } ?: kotlin.run {
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment, tag)
                .commitAllowingStateLoss()
        }
    }

}

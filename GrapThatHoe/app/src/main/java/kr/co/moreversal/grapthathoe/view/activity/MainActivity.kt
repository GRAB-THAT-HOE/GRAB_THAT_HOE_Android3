package kr.co.moreversal.grapthathoe.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import kr.co.moreversal.grapthathoe.R
import kr.co.moreversal.grapthathoe.databinding.ActivityMainBinding
import kr.co.moreversal.grapthathoe.viewmodel.activity.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
        setBottomNav()

        with(mainViewModel) {
            onSettingEvent.observe(this@MainActivity, {
                findNavController(R.id.nav_host_fragment).apply{
//                     navigateUp()
                    navigate(R.id.action_farmerProfileFragment_to_settingFragment)
                }
            })
        }
    }

    private fun performDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.vm = mainViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

    private fun setBottomNav() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController
        binding.bnvFarmerMain
            .setupWithNavController(navController)
    }

    fun setNavVisible(isMainFragment: Boolean) {
        binding.appbarMain.visibility = if(isMainFragment) View.VISIBLE else View.GONE
        binding.bnvFarmerMain.visibility = if(isMainFragment) View.VISIBLE else View.GONE
        binding.btnSetting.visibility = if(isMainFragment) View.GONE else View.VISIBLE
    }

    fun setProfileVisible(isProfileFragment: Boolean) {
        binding.appbarMain.visibility = if(isProfileFragment) View.VISIBLE else View.GONE
        binding.bnvFarmerMain.visibility = if(isProfileFragment) View.VISIBLE else View.GONE
        binding.btnSetting.visibility = if(isProfileFragment) View.VISIBLE else View.GONE
    }
}
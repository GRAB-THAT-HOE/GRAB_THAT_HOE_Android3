package kr.co.moreversal.grapthathoe.view.fragment

import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kr.co.moreversal.grapthathoe.R
import kr.co.moreversal.grapthathoe.databinding.FragmentPost7Binding
import kr.co.moreversal.grapthathoe.databinding.FragmentPost8Binding
import kr.co.moreversal.grapthathoe.databinding.FragmentPost9Binding
import kr.co.moreversal.grapthathoe.databinding.FragmentSettingBinding
import kr.co.moreversal.grapthathoe.view.activity.CreateProfileActivity
import kr.co.moreversal.grapthathoe.view.activity.InAppActivity
import kr.co.moreversal.grapthathoe.view.activity.MainActivity
import kr.co.moreversal.grapthathoe.viewmodel.fragment.*
import java.util.*

class SettingFragment : Fragment() {
    lateinit var binding : FragmentSettingBinding
    lateinit var settingViewModel: SettingViewModel

    var timeString: String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? MainActivity)?.setNavVisible(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_setting,
            container,
            false
        )
        performViewModel()

        with(settingViewModel) {
            onBackEvent.observe(this@SettingFragment, {
                findNavController().navigate(R.id.action_settingFragment_to_farmerProfileFragment)
            })

            onLogoutEvent.observe(this@SettingFragment, {
                val logoutPref = activity?.getSharedPreferences(CreateProfileActivity.TOKEN_PREFERENCE, Activity.MODE_PRIVATE)
                with(logoutPref?.edit()) {
                    this?.clear()
                    this?.commit()
                }

                val intent = Intent(activity, InAppActivity::class.java)
                startActivity(intent)
                activity?.finish()
            })
        }

        return binding.root
    }

    private fun performViewModel() {
        settingViewModel = ViewModelProvider(this).get(SettingViewModel::class.java)
        binding.vm = settingViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

}
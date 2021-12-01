package kr.co.moreversal.grapthathoe.view.fragment

import android.app.DatePickerDialog
import android.app.TimePickerDialog
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
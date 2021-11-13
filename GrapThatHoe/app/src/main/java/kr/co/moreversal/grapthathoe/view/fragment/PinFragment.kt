package kr.co.moreversal.grapthathoe.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kr.co.moreversal.grapthathoe.R
import kr.co.moreversal.grapthathoe.databinding.FragmentConnectBinding
import kr.co.moreversal.grapthathoe.databinding.FragmentPinBinding
import kr.co.moreversal.grapthathoe.databinding.FragmentPostBinding
import kr.co.moreversal.grapthathoe.view.activity.MainActivity
import kr.co.moreversal.grapthathoe.viewmodel.fragment.ConnectViewModel
import kr.co.moreversal.grapthathoe.viewmodel.fragment.PinViewModel
import kr.co.moreversal.grapthathoe.viewmodel.fragment.PostViewModel

class PinFragment : Fragment() {
    lateinit var binding : FragmentPinBinding
    lateinit var pinViewModel : PinViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_pin,
            container,
            false
        )
        performViewModel()

        with(pinViewModel) {

        }

        return binding.root
    }

    private fun performViewModel() {
        pinViewModel = ViewModelProvider(this).get(PinViewModel::class.java)
        binding.vm = pinViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

}
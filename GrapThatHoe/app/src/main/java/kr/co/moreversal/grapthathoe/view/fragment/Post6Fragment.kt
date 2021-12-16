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
import kr.co.moreversal.grapthathoe.databinding.FragmentPost4Binding
import kr.co.moreversal.grapthathoe.databinding.FragmentPost5Binding
import kr.co.moreversal.grapthathoe.databinding.FragmentPost6Binding
import kr.co.moreversal.grapthathoe.view.activity.MainActivity
import kr.co.moreversal.grapthathoe.viewmodel.fragment.Post3ViewModel
import kr.co.moreversal.grapthathoe.viewmodel.fragment.Post4ViewModel
import kr.co.moreversal.grapthathoe.viewmodel.fragment.Post5ViewModel
import kr.co.moreversal.grapthathoe.viewmodel.fragment.Post6ViewModel

class Post6Fragment : Fragment() {
    lateinit var binding : FragmentPost6Binding
    lateinit var post6ViewModel : Post6ViewModel

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
            R.layout.fragment_post6,
            container,
            false
        )
        performViewModel()

        with(post6ViewModel) {
            onBackEvent.observe(this@Post6Fragment, {
                findNavController().navigate(R.id.action_post6Fragment_to_post5Fragment)
            })

            onNextEvent.observe(this@Post6Fragment, {
                Post10Fragment.GiveSnack = binding.checkFood.isChecked
                Post10Fragment.GiveRoomAndBoard = binding.checkSleep.isChecked
                Post10Fragment.IsDisable = binding.checkHurt.isChecked
                Post10Fragment.IsForeign = binding.checkFor.isChecked
                findNavController().navigate(R.id.action_post6Fragment_to_post7Fragment)
            })
        }

        return binding.root
    }

    private fun performViewModel() {
        post6ViewModel = ViewModelProvider(this).get(Post6ViewModel::class.java)
        binding.vm = post6ViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

}
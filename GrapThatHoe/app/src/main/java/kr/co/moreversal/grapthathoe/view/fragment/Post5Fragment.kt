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
import kr.co.moreversal.grapthathoe.view.activity.MainActivity
import kr.co.moreversal.grapthathoe.viewmodel.fragment.Post3ViewModel
import kr.co.moreversal.grapthathoe.viewmodel.fragment.Post4ViewModel
import kr.co.moreversal.grapthathoe.viewmodel.fragment.Post5ViewModel

class Post5Fragment : Fragment() {
    lateinit var binding : FragmentPost5Binding
    lateinit var post5ViewModel : Post5ViewModel

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
            R.layout.fragment_post5,
            container,
            false
        )
        performViewModel()

        with(post5ViewModel) {
            onBackEvent.observe(this@Post5Fragment, {
                findNavController().navigate(R.id.action_post5Fragment_to_post4Fragment)
            })

            onNextEvent.observe(this@Post5Fragment, {
                Post10Fragment.Mainlocation = location.value.toString()
                findNavController().navigate(R.id.action_post5Fragment_to_post6Fragment)
            })
        }

        return binding.root
    }

    private fun performViewModel() {
        post5ViewModel = ViewModelProvider(this).get(Post5ViewModel::class.java)
        binding.vm = post5ViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

}
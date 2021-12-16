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
import kr.co.moreversal.grapthathoe.databinding.FragmentPost2Binding
import kr.co.moreversal.grapthathoe.databinding.FragmentPost3Binding
import kr.co.moreversal.grapthathoe.view.activity.MainActivity
import kr.co.moreversal.grapthathoe.viewmodel.fragment.PostViewModel
import kr.co.moreversal.grapthathoe.viewmodel.fragment.Post2ViewModel
import kr.co.moreversal.grapthathoe.viewmodel.fragment.Post3ViewModel

class Post3Fragment : Fragment() {
    lateinit var binding : FragmentPost3Binding
    lateinit var post3ViewModel : Post3ViewModel

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
            R.layout.fragment_post3,
            container,
            false
        )
        performViewModel()

        with(post3ViewModel) {
            onBackEvent.observe(this@Post3Fragment, {
                findNavController().navigate(R.id.action_post3Fragment_to_post2Fragment)
            })

            onNextEvent.observe(this@Post3Fragment, {
                Post10Fragment.AdditionalExplantion = detail.value.toString()
                findNavController().navigate(R.id.action_post3Fragment_to_post4Fragment)
            })
        }

        return binding.root
    }

    private fun performViewModel() {
        post3ViewModel = ViewModelProvider(this).get(Post3ViewModel::class.java)
        binding.vm = post3ViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

}
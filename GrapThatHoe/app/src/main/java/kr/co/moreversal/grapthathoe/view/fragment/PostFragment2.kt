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
import kr.co.moreversal.grapthathoe.view.activity.MainActivity
import kr.co.moreversal.grapthathoe.viewmodel.fragment.PostViewModel
import kr.co.moreversal.grapthathoe.viewmodel.fragment.Post2ViewModel

class PostFragment2 : Fragment() {
    lateinit var binding : FragmentPost2Binding
    lateinit var post2ViewModel : Post2ViewModel

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
            R.layout.fragment_post,
            container,
            false
        )
        performViewModel()

        with(post2ViewModel) {
            onBackEvent.observe(this@PostFragment2, {
                findNavController().navigate(R.id.action_postFragment_to_farmerProfileFragment)
            })
        }

        return binding.root
    }

    private fun performViewModel() {
        post2ViewModel = ViewModelProvider(this).get(Post2ViewModel::class.java)
        binding.vm = post2ViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

}
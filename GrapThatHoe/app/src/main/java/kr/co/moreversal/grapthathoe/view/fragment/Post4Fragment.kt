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
import kr.co.moreversal.grapthathoe.view.activity.MainActivity
import kr.co.moreversal.grapthathoe.viewmodel.fragment.Post3ViewModel
import kr.co.moreversal.grapthathoe.viewmodel.fragment.Post4ViewModel

class Post4Fragment : Fragment() {
    lateinit var binding : FragmentPost4Binding
    lateinit var post4ViewModel : Post4ViewModel

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
            R.layout.fragment_post4,
            container,
            false
        )
        performViewModel()

        with(post4ViewModel) {
            onBackEvent.observe(this@Post4Fragment, {
                findNavController().navigate(R.id.action_post3Fragment_to_post2Fragment)
            })
        }

        return binding.root
    }

    private fun performViewModel() {
        post4ViewModel = ViewModelProvider(this).get(Post4ViewModel::class.java)
        binding.vm = post4ViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

}
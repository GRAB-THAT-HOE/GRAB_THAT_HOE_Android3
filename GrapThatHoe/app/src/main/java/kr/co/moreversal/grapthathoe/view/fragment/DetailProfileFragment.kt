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
import kr.co.moreversal.grapthathoe.databinding.FragmentDetailProfileBinding
import kr.co.moreversal.grapthathoe.databinding.FragmentPostBinding
import kr.co.moreversal.grapthathoe.view.activity.MainActivity
import kr.co.moreversal.grapthathoe.viewmodel.fragment.DetailProfileViewModel
import kr.co.moreversal.grapthathoe.viewmodel.fragment.PostViewModel

class DetailProfileFragment : Fragment() {
    lateinit var binding : FragmentDetailProfileBinding
    lateinit var detailProfileViewModel : DetailProfileViewModel

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
            R.layout.fragment_detail_profile,
            container,
            false
        )
        performViewModel()

        with(detailProfileViewModel) {
            onBackEvent.observe(this@DetailProfileFragment, {
                findNavController().navigate(R.id.action_detailProfileFragment_to_farmerHomeFragment)
            })
        }

        return binding.root
    }

    private fun performViewModel() {
        detailProfileViewModel = ViewModelProvider(this).get(DetailProfileViewModel::class.java)
        binding.vm = detailProfileViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

}
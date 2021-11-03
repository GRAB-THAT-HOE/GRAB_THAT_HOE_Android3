package kr.co.moreversal.grapthathoe.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import kr.co.moreversal.grapthathoe.R
import kr.co.moreversal.grapthathoe.databinding.FragmentDetailFarmBinding
import kr.co.moreversal.grapthathoe.viewmodel.fragment.DetailFarmViewModel

class DetailFarmFragment : Fragment() {
    lateinit var binding: FragmentDetailFarmBinding
    lateinit var detailFarmViewModel: DetailFarmViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail_farm,
            container,
            false
        )
        performViewModel()

        return binding.root
    }

    private fun performViewModel() {
        detailFarmViewModel = ViewModelProvider(this).get(DetailFarmViewModel::class.java)
        binding.vm = detailFarmViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }
}
package kr.co.moreversal.grapthathoe.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import kr.co.moreversal.grapthathoe.R
import kr.co.moreversal.grapthathoe.databinding.FragmentFarmerHomeBinding
import kr.co.moreversal.grapthathoe.network.model.FarmerPost
import kr.co.moreversal.grapthathoe.view.adapter.FarmerHomeRecyclerAdapter
import kr.co.moreversal.grapthathoe.viewmodel.fragment.FarmerHomeViewModel

class FarmerHomeFragment : Fragment() {
    lateinit var binding : FragmentFarmerHomeBinding
    lateinit var farmerHomeViewModel: FarmerHomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_farmer_home,
            container,
            false
        )
        performViewModel()
        initRecycler()
        return binding.root
    }

    private fun performViewModel() {
        farmerHomeViewModel = ViewModelProvider(this).get(FarmerHomeViewModel::class.java)
        binding.vm = farmerHomeViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

    private fun initRecycler() {
        var farmerPostList = ArrayList<FarmerPost>()
        val farmerHomeRecyclerAdapter = FarmerHomeRecyclerAdapter(viewLifecycleOwner)
        binding.recyclerFarmerHome.adapter = farmerHomeRecyclerAdapter

        farmerPostList.apply {
            add(FarmerPost("https://image.msscdn.net/data/curating/16948/16948_1_org.jpg", "마을 농장 사과따기", "2021.12.12 ~ 2022.15.15"));
            add(FarmerPost("https://image.msscdn.net/data/curating/16948/16948_1_org.jpg", "마을 농장 사과따기", "2021.12.12 ~ 2022.15.15"));
            add(FarmerPost("https://image.msscdn.net/data/curating/16948/16948_1_org.jpg", "마을 농장 사과따기", "2021.12.12 ~ 2022.15.15"));
            add(FarmerPost("https://image.msscdn.net/data/curating/16948/16948_1_org.jpg", "마을 농장 사과따기", "2021.12.12 ~ 2022.15.15"));
            add(FarmerPost("https://image.msscdn.net/data/curating/16948/16948_1_org.jpg", "마을 농장 사과따기", "2021.12.12 ~ 2022.15.15"));
            add(FarmerPost("https://image.msscdn.net/data/curating/16948/16948_1_org.jpg", "마을 농장 사과따기", "2021.12.12 ~ 2022.15.15"));
            add(FarmerPost("https://image.msscdn.net/data/curating/16948/16948_1_org.jpg", "마을 농장 사과따기", "2021.12.12 ~ 2022.15.15"));
            add(FarmerPost("https://image.msscdn.net/data/curating/16948/16948_1_org.jpg", "마을 농장 사과따기", "2021.12.12 ~ 2022.15.15"));
            add(FarmerPost("https://image.msscdn.net/data/curating/16948/16948_1_org.jpg", "마을 농장 사과따기", "2021.12.12 ~ 2022.15.15"));
            add(FarmerPost("https://image.msscdn.net/data/curating/16948/16948_1_org.jpg", "마을 농장 사과따기", "2021.12.12 ~ 2022.15.15"));
            add(FarmerPost("https://image.msscdn.net/data/curating/16948/16948_1_org.jpg", "마을 농장 사과따기", "2021.12.12 ~ 2022.15.15"));
        }

        farmerHomeRecyclerAdapter.farmerPostList = farmerPostList
        farmerHomeRecyclerAdapter.notifyDataSetChanged()
    }

}
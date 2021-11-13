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
import kr.co.moreversal.grapthathoe.databinding.FragmentFarmerHomeBinding
import kr.co.moreversal.grapthathoe.databinding.FragmentFarmerProfileBinding
import kr.co.moreversal.grapthathoe.network.model.MyPost
import kr.co.moreversal.grapthathoe.view.activity.MainActivity
import kr.co.moreversal.grapthathoe.view.adapter.FarmerPostRecyclerAdapter
import kr.co.moreversal.grapthathoe.viewmodel.fragment.DetailFarmViewModel
import kr.co.moreversal.grapthathoe.viewmodel.fragment.FarmerHomeViewModel
import kr.co.moreversal.grapthathoe.viewmodel.fragment.FarmerProfileViewModel

class FarmerProfileFragment : Fragment() {
    lateinit var binding : FragmentFarmerProfileBinding
    lateinit var farmerProfileViewModel: FarmerProfileViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? MainActivity)?.setNavVisible(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_farmer_profile,
            container,
            false
        )
        performViewModel()
        initRecycler()

        with(farmerProfileViewModel) {
            onPostEvent.observe(this@FarmerProfileFragment, {
                findNavController().navigate(R.id.action_farmerProfileFragment_to_postFragment)
            })

            FarmerPostRecyclerAdapter.onClickDetail.observe(this@FarmerProfileFragment, {
                findNavController().navigate(R.id.action_farmerProfileFragment_to_detailFarmFragment)
            })
        }

        return binding.root
    }

    private fun performViewModel() {
        farmerProfileViewModel = ViewModelProvider(this).get(FarmerProfileViewModel::class.java)
        binding.vm = farmerProfileViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

    private fun initRecycler() {
        var farmerMyPostList = ArrayList<MyPost>()
        val farmerPostRecyclerAdapter = FarmerPostRecyclerAdapter(viewLifecycleOwner)
        binding.myPostRecycler.adapter = farmerPostRecyclerAdapter

        farmerMyPostList.apply {
            add(MyPost("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "딸기 농장 입니다.", "2021/11/10 ~ 2021/12/31"))
            add(MyPost("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "딸기 농장 입니다.", "2021/11/10 ~ 2021/12/31"))
            add(MyPost("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "딸기 농장 입니다.", "2021/11/10 ~ 2021/12/31"))
            add(MyPost("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "딸기 농장 입니다.", "2021/11/10 ~ 2021/12/31"))
            add(MyPost("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "딸기 농장 입니다.", "2021/11/10 ~ 2021/12/31"))
            add(MyPost("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "딸기 농장 입니다.", "2021/11/10 ~ 2021/12/31"))
            add(MyPost("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "딸기 농장 입니다.", "2021/11/10 ~ 2021/12/31"))
            add(MyPost("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "딸기 농장 입니다.", "2021/11/10 ~ 2021/12/31"))
            add(MyPost("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "딸기 농장 입니다.", "2021/11/10 ~ 2021/12/31"))
        }

        farmerPostRecyclerAdapter.farmerMyPostList = farmerMyPostList
        farmerPostRecyclerAdapter.notifyDataSetChanged()
    }
}
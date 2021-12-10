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
import kr.co.moreversal.grapthathoe.network.model.FarmerPost
import kr.co.moreversal.grapthathoe.network.model.MyPost
import kr.co.moreversal.grapthathoe.view.activity.MainActivity
import kr.co.moreversal.grapthathoe.view.adapter.FarmerHomeRecyclerAdapter
import kr.co.moreversal.grapthathoe.viewmodel.fragment.FarmerHomeViewModel

class
FarmerHomeFragment : Fragment() {
    lateinit var binding : FragmentFarmerHomeBinding
    lateinit var farmerHomeViewModel: FarmerHomeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? MainActivity)?.setNavVisible(true)
    }

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

        with(farmerHomeViewModel) {
            FarmerHomeRecyclerAdapter.onClickDetail.observe(this@FarmerHomeFragment, {
                findNavController().navigate(R.id.action_farmerHomeFragment_to_detailFarmFragment)
            })
        }
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
            add(FarmerPost("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "딸기 농장 입니다.", "2021/11/10 ~ 2021/12/31"))
            add(FarmerPost("https://www.kyongbuk.co.kr/news/photo/201608/967889_245925_3417.jpg", "소 기르기", "2021/10/11 ~ 2022/12/31"))
            add(FarmerPost("http://m.yummygarden.co.kr/file_data/yummygarden2/2017/08/29/85f725e2e2c4b8ca1890eaf0ee3cadad.jpg", "블루배리 관리.", "2022/01/01 ~ 2022/12/00"))
            add(FarmerPost("https://www.koreatimes.net/images/attach/121128/20190808-13083162.jpg", "바나나 기르기", "2021/11/10 ~ 2021/12/31"))
            add(FarmerPost("https://www.drdic.kr/wp-content/uploads/2018/10/mango.jpg", "망고 농장 입니다.", "2021/10/11 ~ 2021/10/18"))
            add(FarmerPost("https://www.sonohotelsresorts.com/img/saupjang/cs/images/travel/ex4_2.jpg", "사과 관리직", "2021/12/02 ~ 2022/01/10"))
            add(FarmerPost("http://www.newsfarm.co.kr/news/photo/202002/53212_33458_5923.jpg", "벼 수확 및 관리", "2022/01/10 ~ 2026/12/31"))
            add(FarmerPost("http://cdn.ggilbo.com/news/photo/201905/670907_514704_5449.jpg", "보리 수확.", "2022/03/21 ~ 2022/06/04"))
            add(FarmerPost("http://cdn.dtnews24.com/news/photo/202106/706644_307222_3627.jpg", "상추 관리(제공)", "2022/02/22 ~ 2023/11/11"))
        }

        farmerHomeRecyclerAdapter.farmerPostList = farmerPostList
        farmerHomeRecyclerAdapter.notifyDataSetChanged()
    }

}
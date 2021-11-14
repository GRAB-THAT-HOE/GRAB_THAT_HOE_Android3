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
import kr.co.moreversal.grapthathoe.databinding.FragmentConnectBinding
import kr.co.moreversal.grapthathoe.databinding.FragmentPinBinding
import kr.co.moreversal.grapthathoe.databinding.FragmentPostBinding
import kr.co.moreversal.grapthathoe.network.model.MyPost
import kr.co.moreversal.grapthathoe.view.activity.MainActivity
import kr.co.moreversal.grapthathoe.view.adapter.FarmerPostRecyclerAdapter
import kr.co.moreversal.grapthathoe.viewmodel.fragment.ConnectViewModel
import kr.co.moreversal.grapthathoe.viewmodel.fragment.PinViewModel
import kr.co.moreversal.grapthathoe.viewmodel.fragment.PostViewModel

class PinFragment : Fragment() {
    lateinit var binding : FragmentPinBinding
    lateinit var pinViewModel : PinViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_pin,
            container,
            false
        )
        performViewModel()
        initRecycler()

        with(pinViewModel) {
            FarmerPostRecyclerAdapter.onClickDetail.observe(this@PinFragment, {
                findNavController().navigate(R.id.action_farmerChatFragment_to_detailFarmFragment)
            })
        }

        return binding.root
    }

    private fun performViewModel() {
        pinViewModel = ViewModelProvider(this).get(PinViewModel::class.java)
        binding.vm = pinViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

    private fun initRecycler() {
        var pinList = ArrayList<MyPost>()
        val pinRecyclerAdapter = FarmerPostRecyclerAdapter(viewLifecycleOwner)
        binding.recyclerPin.adapter = pinRecyclerAdapter

        pinList.apply {
            add(MyPost("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "사과 농장 입니다.", "2021/11/10 ~ 2021/12/31"))
            add(MyPost("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "말 농장 입니다.", "2021/11/10 ~ 2021/12/31"))
            add(MyPost("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "딸기 농장 입니다.", "2021/11/10 ~ 2021/12/31"))
            add(MyPost("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "딸기 농장 입니다.", "2021/11/10 ~ 2021/12/31"))
            add(MyPost("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "딸기 농장 입니다.", "2021/11/10 ~ 2021/12/31"))
            add(MyPost("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "딸기 농장 입니다.", "2021/11/10 ~ 2021/12/31"))
            add(MyPost("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "딸기 농장 입니다.", "2021/11/10 ~ 2021/12/31"))
            add(MyPost("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "딸기 농장 입니다.", "2021/11/10 ~ 2021/12/31"))
            add(MyPost("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "딸기 농장 입니다.", "2021/11/10 ~ 2021/12/31"))
        }

        pinRecyclerAdapter.farmerMyPostList = pinList
        pinRecyclerAdapter.notifyDataSetChanged()
    }

}
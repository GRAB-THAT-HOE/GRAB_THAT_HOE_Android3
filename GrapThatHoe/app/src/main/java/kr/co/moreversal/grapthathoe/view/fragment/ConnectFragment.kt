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
import kr.co.moreversal.grapthathoe.databinding.FragmentPostBinding
import kr.co.moreversal.grapthathoe.network.model.Connect
import kr.co.moreversal.grapthathoe.view.activity.MainActivity
import kr.co.moreversal.grapthathoe.view.adapter.ConnectRecyclerAdapter
import kr.co.moreversal.grapthathoe.viewmodel.fragment.ConnectViewModel
import kr.co.moreversal.grapthathoe.viewmodel.fragment.PostViewModel

class ConnectFragment : Fragment() {
    lateinit var binding : FragmentConnectBinding
    lateinit var connectViewModel : ConnectViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_connect,
            container,
            false
        )
        performViewModel()
        initRecycler()

        with(connectViewModel) {
            ConnectRecyclerAdapter.onClickDetailProfile.observe(this@ConnectFragment, {
                findNavController().navigate(R.id.action_farmerChatFragment_to_detailProfileFragment)
            })
        }

        return binding.root
    }

    private fun performViewModel() {
        connectViewModel = ViewModelProvider(this).get(ConnectViewModel::class.java)
        binding.vm = connectViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

    private fun initRecycler() {
        var connectList = ArrayList<Connect>()
        val connectRecyclerAdapter = ConnectRecyclerAdapter(viewLifecycleOwner)
        binding.recyclerConnect.adapter = connectRecyclerAdapter

        connectList.apply {
            add(Connect("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "이경태", "2021/11/10 ~ 2021/12/31"))
            add(Connect("https://www.kyongbuk.co.kr/news/photo/201608/967889_245925_3417.jpg", "최민재", "2021/10/11 ~ 2022/12/31"))
            add(Connect("http://m.yummygarden.co.kr/file_data/yummygarden2/2017/08/29/85f725e2e2c4b8ca1890eaf0ee3cadad.jpg", "우준성", "2022/01/01 ~ 2022/12/00"))
            add(Connect("https://www.koreatimes.net/images/attach/121128/20190808-13083162.jpg", "신현우", "2021/11/10 ~ 2021/12/31"))
            add(Connect("https://www.drdic.kr/wp-content/uploads/2018/10/mango.jpg", "이경남", "2021/10/11 ~ 2021/10/18"))
            add(Connect("https://www.sonohotelsresorts.com/img/saupjang/cs/images/travel/ex4_2.jpg", "안경순", "2021/12/02 ~ 2022/01/10"))
            add(Connect("http://www.newsfarm.co.kr/news/photo/202002/53212_33458_5923.jpg", "안광남", "2022/01/10 ~ 2026/12/31"))
            add(Connect("http://cdn.ggilbo.com/news/photo/201905/670907_514704_5449.jpg", "우백곰", "2022/03/21 ~ 2022/06/04"))
            add(Connect("http://cdn.dtnews24.com/news/photo/202106/706644_307222_3627.jpg", "안경태", "2022/02/22 ~ 2023/11/11"))
        }

        connectRecyclerAdapter.connectList = connectList
        connectRecyclerAdapter.notifyDataSetChanged()
    }
}
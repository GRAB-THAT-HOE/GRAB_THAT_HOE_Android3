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
            add(Connect("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "안경자", "2021/12/14 12:34"))
            add(Connect("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "안경자", "2021/12/14 12:34"))
            add(Connect("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "안경자", "2021/12/14 12:34"))
            add(Connect("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "안경자", "2021/12/14 12:34"))
            add(Connect("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "안경자", "2021/12/14 12:34"))
            add(Connect("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "안경자", "2021/12/14 12:34"))
            add(Connect("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "안경자", "2021/12/14 12:34"))
            add(Connect("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "안경자", "2021/12/14 12:34"))
            add(Connect("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "안경자", "2021/12/14 12:34"))
            add(Connect("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg", "안경자", "2021/12/14 12:34"))
        }

        connectRecyclerAdapter.connectList = connectList
        connectRecyclerAdapter.notifyDataSetChanged()

    }
}
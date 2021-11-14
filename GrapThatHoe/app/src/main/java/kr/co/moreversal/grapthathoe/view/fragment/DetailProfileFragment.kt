package kr.co.moreversal.grapthathoe.view.fragment

import android.content.Intent
import android.net.Uri
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
import kr.co.moreversal.grapthathoe.network.model.MyPost
import kr.co.moreversal.grapthathoe.view.activity.MainActivity
import kr.co.moreversal.grapthathoe.view.adapter.FarmerPostRecyclerAdapter
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
        initRecycler()

        with(detailProfileViewModel) {
            onBackEvent.observe(this@DetailProfileFragment, {
                findNavController().navigate(R.id.action_detailProfileFragment_to_farmerHomeFragment)
            })

            onCallEvent.observe(this@DetailProfileFragment, {
                val call = Intent(Intent.ACTION_CALL, Uri.parse("tel:01048552344"))
                startActivity(call)
            })

            FarmerPostRecyclerAdapter.onClickDetail.observe(this@DetailProfileFragment, {
                findNavController().navigate(R.id.action_detailProfileFragment_to_detailFarmFragment)
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

    private fun initRecycler() {
        var detailProfileList = ArrayList<MyPost>()
        val detailProfileRecyclerAdapter = FarmerPostRecyclerAdapter(viewLifecycleOwner)
        binding.recyclerDetailProfile.adapter = detailProfileRecyclerAdapter

        detailProfileList.apply {
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

        detailProfileRecyclerAdapter.farmerMyPostList = detailProfileList
        detailProfileRecyclerAdapter.notifyDataSetChanged()
    }

}
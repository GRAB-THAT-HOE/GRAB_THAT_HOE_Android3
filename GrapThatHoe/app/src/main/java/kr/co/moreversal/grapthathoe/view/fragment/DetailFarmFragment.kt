package kr.co.moreversal.grapthathoe.view.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kr.co.moreversal.grapthathoe.R
import kr.co.moreversal.grapthathoe.databinding.FragmentDetailFarmBinding
import kr.co.moreversal.grapthathoe.network.model.FarmImg
import kr.co.moreversal.grapthathoe.view.activity.MainActivity
import kr.co.moreversal.grapthathoe.view.adapter.DetailFarmAdapter
import kr.co.moreversal.grapthathoe.viewmodel.fragment.DetailFarmViewModel

class DetailFarmFragment : Fragment() {
    lateinit var binding: FragmentDetailFarmBinding
    lateinit var detailFarmViewModel: DetailFarmViewModel

    var pinStatus: Int = 0

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
            R.layout.fragment_detail_farm,
            container,
            false
        )
        performViewModel()
        initViewPager()

        with(detailFarmViewModel) {
            onBackEvent.observe(this@DetailFarmFragment, {
                findNavController().navigate(R.id.action_detailFarmFragment_to_farmerHomeFragment)
            })

            onCallEvent.observe(this@DetailFarmFragment, {
                val call = Intent(Intent.ACTION_CALL, Uri.parse("tel:01048552344"))
                startActivity(call)
            })

            onShowDetailEvent.observe(this@DetailFarmFragment, {
                if (binding.tvDetailExplain.visibility == View.GONE) {
                    binding.tvDetailExplain.visibility = View.VISIBLE
                    binding.btnShowDetail.text = "자세한 정보 감추기"
                } else if (binding.tvDetailExplain.visibility == View.VISIBLE) {
                    binding.tvDetailExplain.visibility = View.GONE
                    binding.btnShowDetail.text = "자세한 정보 보기"
                }
            })

            onPinEvent.observe(this@DetailFarmFragment, {
                if (pinStatus == 0) {
                    binding.btnPin.setBackgroundResource(R.drawable.ic_btn_pin_b)
                    Toast.makeText(context, "말뚝을 추가하였습니다.", Toast.LENGTH_SHORT).show()
                    pinStatus = 1
                } else if (pinStatus == 1) {
                    binding.btnPin.setBackgroundResource(R.drawable.ic_btn_pin_w)
                    Toast.makeText(context, "말뚝을 해제하였습니다.", Toast.LENGTH_SHORT).show()
                    pinStatus = 0
                }
            })
        }

        return binding.root
    }

    private fun performViewModel() {
        detailFarmViewModel = ViewModelProvider(this).get(DetailFarmViewModel::class.java)
        binding.vm = detailFarmViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

    private fun initViewPager() {
        var farmImgList = ArrayList<FarmImg>()
        val detailFarmAdapter = DetailFarmAdapter(viewLifecycleOwner)
        binding.viewPagerFarm.adapter = detailFarmAdapter

        farmImgList.apply {
            add(FarmImg("https://nimage.g-enews.com/phpwas/restmb_allidxmake.php?idx=5&simg=2018073116220101420c77c10352218396190229.jpg"))
            add(FarmImg("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg"))
            add(FarmImg("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg"))
            add(FarmImg("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg"))
            add(FarmImg("https://www.dementianews.co.kr/news/photo/202012/3429_6904_018.jpg"))
        }
        detailFarmAdapter.farmImgList = farmImgList
        detailFarmAdapter.notifyDataSetChanged()

        // viewPager에 인디케이터 연결하기
        binding.indicatorFarm.setViewPager2(binding.viewPagerFarm)
    }
}
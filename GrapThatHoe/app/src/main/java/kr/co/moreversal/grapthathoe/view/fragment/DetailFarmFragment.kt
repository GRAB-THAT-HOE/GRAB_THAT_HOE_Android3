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
import kr.co.moreversal.grapthathoe.databinding.FragmentDetailFarmBinding
import kr.co.moreversal.grapthathoe.network.model.FarmImg
import kr.co.moreversal.grapthathoe.view.activity.MainActivity
import kr.co.moreversal.grapthathoe.view.adapter.DetailFarmAdapter
import kr.co.moreversal.grapthathoe.viewmodel.fragment.DetailFarmViewModel

class DetailFarmFragment : Fragment() {
    lateinit var binding: FragmentDetailFarmBinding
    lateinit var detailFarmViewModel: DetailFarmViewModel

    var datas = mutableListOf<FarmImg>()

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

        with(detailFarmViewModel) {
            onBackEvent.observe(this@DetailFarmFragment, {
                findNavController().navigate(R.id.action_detailFarmFragment_to_farmerHomeFragment)
            })
        }

        val detailFarmAdapter = DetailFarmAdapter(viewLifecycleOwner)
        binding.viewPagerFarm.adapter = detailFarmAdapter

        datas.apply {
            add(FarmImg("https://nimage.g-enews.com/phpwas/restmb_allidxmake.php?idx=5&simg=2018073116220101420c77c10352218396190229.jpg"))
            add(FarmImg("http://www.joaradak.com/img_up/shop_pds/joaradak/design/images/page/sub1_1_img01.jpg"))
            add(FarmImg("http://www.joaradak.com/img_up/shop_pds/joaradak/design/images/page/sub1_1_img02.jpg"))
            add(FarmImg("http://www.joaradak.com/img_up/shop_pds/joaradak/design/images/page/sub1_1_img03.jpg"))
            add(FarmImg("http://www.joaradak.com/img_up/shop_pds/joaradak/design/images/page/sub1_1_img04.jpg"))
        }
        detailFarmAdapter.notifyDataSetChanged()

        // viewPager에 인디케이터 연결하기
        binding.indicatorFarm.setViewPager2(binding.viewPagerFarm)

        return binding.root
    }

    private fun performViewModel() {
        detailFarmViewModel = ViewModelProvider(this).get(DetailFarmViewModel::class.java)
        binding.vm = detailFarmViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }
}
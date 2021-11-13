package kr.co.moreversal.grapthathoe.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import kr.co.moreversal.grapthathoe.R
import kr.co.moreversal.grapthathoe.databinding.FragmentFarmerChatBinding
import kr.co.moreversal.grapthathoe.view.activity.MainActivity
import kr.co.moreversal.grapthathoe.viewmodel.fragment.FarmerChatViewModel

class FarmerChatFragment : Fragment() {
    lateinit var binding : FragmentFarmerChatBinding
    lateinit var farmerChatViewModel : FarmerChatViewModel

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
            R.layout.fragment_farmer_chat,
            container,
            false
        )
        performViewModel()
        settingTab()

        return binding.root
    }

    private fun performViewModel() {
        farmerChatViewModel = ViewModelProvider(this).get(FarmerChatViewModel::class.java)
        binding.vm = farmerChatViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

    private fun settingTab() {
        // tabLayout operate
        binding.tabRecord.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val transaction = childFragmentManager.beginTransaction()
                when (tab?.text) {
                    "연결 기록" -> {
                        transaction.replace(R.id.tap_content, ConnectFragment())
                    }
                    "말뚝 게시물" -> {
                        transaction.replace(R.id.tap_content, PinFragment())
                    }
                }
                transaction.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }

}
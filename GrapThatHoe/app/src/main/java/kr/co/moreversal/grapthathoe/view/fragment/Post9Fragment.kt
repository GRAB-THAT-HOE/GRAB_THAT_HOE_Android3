package kr.co.moreversal.grapthathoe.view.fragment

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kr.co.moreversal.grapthathoe.R
import kr.co.moreversal.grapthathoe.databinding.FragmentPost7Binding
import kr.co.moreversal.grapthathoe.databinding.FragmentPost8Binding
import kr.co.moreversal.grapthathoe.databinding.FragmentPost9Binding
import kr.co.moreversal.grapthathoe.view.activity.MainActivity
import kr.co.moreversal.grapthathoe.viewmodel.fragment.*
import java.util.*

class Post9Fragment : Fragment() {
    lateinit var binding : FragmentPost9Binding
    lateinit var post9ViewModel: Post9ViewModel

    var timeString: String = ""

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
            R.layout.fragment_post9,
            container,
            false
        )
        performViewModel()

        with(post9ViewModel) {
            onBackEvent.observe(this@Post9Fragment, {
                findNavController().navigate(R.id.action_post9Fragment_to_post8Fragment)
            })

            onPostEvent.observe(this@Post9Fragment, {
                findNavController().navigate(R.id.action_post9Fragment_to_farmerHomeFragment)
            })

            onRefreshTimeEvent.observe(this@Post9Fragment, {
                val time = Calendar.getInstance()
                val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    timeString = "${hourOfDay}시간 ${minute}분"
                    binding.tvRefreshTime.text = timeString
                }
                TimePickerDialog(context, timeSetListener, time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE),true).show()
            })
        }

        return binding.root
    }

    private fun performViewModel() {
        post9ViewModel = ViewModelProvider(this).get(Post9ViewModel::class.java)
        binding.vm = post9ViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

}
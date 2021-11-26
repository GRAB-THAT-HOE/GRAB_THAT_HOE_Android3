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
import kr.co.moreversal.grapthathoe.view.activity.MainActivity
import kr.co.moreversal.grapthathoe.viewmodel.fragment.*
import java.util.*

class Post8Fragment : Fragment() {
    lateinit var binding : FragmentPost8Binding
    lateinit var post8ViewModel: Post8ViewModel

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
            R.layout.fragment_post8,
            container,
            false
        )
        performViewModel()

        with(post8ViewModel) {
            onBackEvent.observe(this@Post8Fragment, {
                findNavController().navigate(R.id.action_post8Fragment_to_post7Fragment)
            })

            onStartDateEvent.observe(this@Post8Fragment, {
                val time = Calendar.getInstance()
                val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    timeString = "${hourOfDay}시 ${minute}분"
                    binding.tvStartDate.text = timeString
                }
                TimePickerDialog(context, timeSetListener, time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE),true).show()
            })

            onEndDateEvent.observe(this@Post8Fragment, {
                val time = Calendar.getInstance()
                val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    timeString = "${hourOfDay}시 ${minute}분"
                    binding.tvEndDate.text = timeString
                }
                TimePickerDialog(context, timeSetListener, time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE),true).show()
            })

        }

        return binding.root
    }

    private fun performViewModel() {
        post8ViewModel = ViewModelProvider(this).get(Post8ViewModel::class.java)
        binding.vm = post8ViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

}
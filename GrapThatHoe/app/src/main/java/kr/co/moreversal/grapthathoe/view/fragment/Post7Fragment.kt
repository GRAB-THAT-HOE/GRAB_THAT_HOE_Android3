package kr.co.moreversal.grapthathoe.view.fragment

import android.app.DatePickerDialog
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
import kr.co.moreversal.grapthathoe.view.activity.MainActivity
import kr.co.moreversal.grapthathoe.viewmodel.fragment.*
import java.util.*

class Post7Fragment : Fragment() {
    lateinit var binding : FragmentPost7Binding
    lateinit var post7ViewModel : Post7ViewModel

    var dateString: String = ""

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
            R.layout.fragment_post7,
            container,
            false
        )
        performViewModel()

        with(post7ViewModel) {
            onBackEvent.observe(this@Post7Fragment, {
                findNavController().navigate(R.id.action_post7Fragment_to_post6Fragment)
            })

            onStartDateEvent.observe(this@Post7Fragment, {
                val calendar = Calendar.getInstance()    //캘린더뷰 만들기
                val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    dateString = "${year}년 ${month+1}월 ${dayOfMonth}일"
                    binding.tvStartDate.text = dateString
                }
                context?.let { it1 -> DatePickerDialog(it1, dateSetListener, calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show() }
            })

            onEndDateEvent.observe(this@Post7Fragment, {
                val calendar = Calendar.getInstance()    //캘린더뷰 만들기
                val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    dateString = "${year}년 ${month+1}월 ${dayOfMonth}일"
                    binding.tvEndDate.text = dateString
                }
                context?.let { it1 -> DatePickerDialog(it1, dateSetListener, calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show() }
            })

        }

        return binding.root
    }

    private fun performViewModel() {
        post7ViewModel = ViewModelProvider(this).get(Post7ViewModel::class.java)
        binding.vm = post7ViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

}
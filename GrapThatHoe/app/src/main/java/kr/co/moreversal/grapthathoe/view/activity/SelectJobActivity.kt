package kr.co.moreversal.grapthathoe.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import kr.co.moreversal.grapthathoe.R
import kr.co.moreversal.grapthathoe.databinding.ActivitySelectJobBinding
import kr.co.moreversal.grapthathoe.viewmodel.activity.CheckPhoneViewModel
import kr.co.moreversal.grapthathoe.viewmodel.activity.SelectJobViewModel

class SelectJobActivity : AppCompatActivity() {
    lateinit var binding: ActivitySelectJobBinding
    lateinit var selectJobViewModel: SelectJobViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()

        with(selectJobViewModel) {
            onFarmerEvent.observe(this@SelectJobActivity, {
                val intent = Intent(this@SelectJobActivity, CreateProfileActivity::class.java)
                intent.putExtra("Permission", 0)
                startActivity(intent)
            })

            onWorkerEvent.observe(this@SelectJobActivity, {
                val intent = Intent(this@SelectJobActivity, CreateProfileActivity::class.java)
                intent.putExtra("Permission", 1)
                startActivity(intent)
            })
        }

    }

    private fun performDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_select_job)
        selectJobViewModel = ViewModelProvider(this).get(SelectJobViewModel::class.java)
        binding.vm = selectJobViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }
}
package kr.co.moreversal.grapthathoe.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import kr.co.moreversal.grapthathoe.R
import kr.co.moreversal.grapthathoe.databinding.ActivityCheckPhoneBinding
import kr.co.moreversal.grapthathoe.viewmodel.activity.CheckPhoneViewModel

class CheckPhoneActivity : AppCompatActivity() {
    lateinit var binding: ActivityCheckPhoneBinding
    lateinit var checkPhoneViewModel: CheckPhoneViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()

        with(checkPhoneViewModel) {
            onResponseEvent.observe(this@CheckPhoneActivity, {
                binding.editCheckNum.visibility = View.VISIBLE
                binding.btnCheck.visibility = View.VISIBLE
                binding.btnResendCheckNum.visibility = View.VISIBLE
            })

            onCheckEvent.observe(this@CheckPhoneActivity, {
                val intent = Intent(this@CheckPhoneActivity, SelectJobActivity::class.java)
                startActivity(intent)
                finish()
            })
        }
    }

    private fun performDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_check_phone)
        checkPhoneViewModel = ViewModelProvider(this).get(CheckPhoneViewModel::class.java)
        binding.vm = checkPhoneViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }
}
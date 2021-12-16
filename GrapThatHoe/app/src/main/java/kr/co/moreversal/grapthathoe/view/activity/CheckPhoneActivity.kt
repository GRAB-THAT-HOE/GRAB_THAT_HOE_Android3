package kr.co.moreversal.grapthathoe.view.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
        val sharedPref = getSharedPreferences(CreateProfileActivity.TOKEN_PREFERENCE, Activity.MODE_PRIVATE)

        with(checkPhoneViewModel) {
            message.observe(this@CheckPhoneActivity, {
                Toast.makeText(this@CheckPhoneActivity, "${message.value}", Toast.LENGTH_SHORT).show()
            })
            
            onResponseEvent.observe(this@CheckPhoneActivity, {
                binding.editCheckNum.visibility = View.VISIBLE
                binding.btnCheck.visibility = View.VISIBLE
                binding.btnResendCheckNum.visibility = View.VISIBLE
                binding.btnCheckNum.setBackgroundResource(R.drawable.btn_false_design)
                binding.btnCheckNum.isEnabled = false
            })

            onCheckEvent.observe(this@CheckPhoneActivity, {
                CreateProfileActivity.pNum = phoneNum.value!!.toInt()
                val intent = Intent(this@CheckPhoneActivity, SelectJobActivity::class.java)
                startActivity(intent)
                finish()
            })

            onHadEvent.observe(this@CheckPhoneActivity, {
                val intent = Intent(this@CheckPhoneActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            })

            onResendEvent.observe(this@CheckPhoneActivity, {
                Toast.makeText(applicationContext, "재전송이 되었습니다.", Toast.LENGTH_SHORT).show()
            })

            token.observe(this@CheckPhoneActivity, {
                sharedPref.edit().putString("token", token.value)
                sharedPref.edit().apply()
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
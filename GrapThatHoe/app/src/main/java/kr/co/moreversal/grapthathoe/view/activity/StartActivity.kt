package kr.co.moreversal.grapthathoe.view.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import kr.co.moreversal.grapthathoe.R
import kr.co.moreversal.grapthathoe.databinding.ActivityStartBinding
import kr.co.moreversal.grapthathoe.network.model.RetrofitClient
import kr.co.moreversal.grapthathoe.network.request.LoginRequest
import kr.co.moreversal.grapthathoe.viewmodel.activity.StartViewModel


class StartActivity : AppCompatActivity() {
    lateinit var binding: ActivityStartBinding
    lateinit var startViewModel: StartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
        val sharedPref = getSharedPreferences(CreateProfileActivity.TOKEN_PREFERENCE, Activity.MODE_PRIVATE)
        Log.d("TestTest", "onCreate: ${sharedPref.getInt("phone", 0)}")

        with(startViewModel) {
            onStartEvent.observe(this@StartActivity, {
                val phone = sharedPref.getInt("phone", 0)

                if (phone == 0) {
                    var intent = Intent(this@StartActivity, CheckPhoneActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    phoneNum.value = phone
                    login()
                }
            })

            onSuccessEvent.observe(this@StartActivity, {
                var intent = Intent(this@StartActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            })

            message.observe(this@StartActivity, {
                Toast.makeText(this@StartActivity, "${message.value}", Toast.LENGTH_SHORT).show()
            })

            token.observe(this@StartActivity, {
                sharedPref.edit().putString("token", token.value)
            })
        }

    }

    private fun performDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_start)
        startViewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        binding.vm = startViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

}
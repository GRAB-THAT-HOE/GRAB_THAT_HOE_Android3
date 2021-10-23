package kr.co.moreversal.grapthathoe.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import kr.co.moreversal.grapthathoe.R
import kr.co.moreversal.grapthathoe.databinding.ActivityStartBinding
import kr.co.moreversal.grapthathoe.viewmodel.activity.StartViewModel


class StartActivity : AppCompatActivity() {
    lateinit var binding: ActivityStartBinding
    lateinit var startViewModel: StartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()

        with(startViewModel) {
            onStartEvent.observe(this@StartActivity, {
                var intent = Intent(this@StartActivity, CheckPhoneActivity::class.java)
                startActivity(intent)
                finish()
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
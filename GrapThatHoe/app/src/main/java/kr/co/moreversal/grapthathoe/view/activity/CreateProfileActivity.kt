package kr.co.moreversal.grapthathoe.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import kr.co.moreversal.grapthathoe.R
import kr.co.moreversal.grapthathoe.databinding.ActivityCreateProfileBinding
import kr.co.moreversal.grapthathoe.viewmodel.activity.CreateProfileViewModel
import kr.co.moreversal.grapthathoe.viewmodel.activity.MainViewModel

class CreateProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivityCreateProfileBinding
    lateinit var createProfileViewModel: CreateProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()

        with(createProfileViewModel) {
            onBackEvent.observe(this@CreateProfileActivity, {
                finish()
            })

            onCheckEvent.observe(this@CreateProfileActivity, {
                val intent = Intent(this@CreateProfileActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            })
        }
    }

    private fun performDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_profile)
        createProfileViewModel = ViewModelProvider(this).get(CreateProfileViewModel::class.java)
        binding.vm = createProfileViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }
}
package kr.co.moreversal.grapthathoe.view.activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
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

            onChangeImgEvent.observe(this@CreateProfileActivity, {
                val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                intent.type = "image/*"
                startActivityForResult(intent, 10)
            })
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 10 && resultCode == Activity.RESULT_OK) {
            data?.data?.let { uri ->
                val imageUri: Uri? = data.data
                if (imageUri != null) {
                    Glide.with(binding.root)
                        .load(imageUri)
                        .error(R.drawable.user)
                        .centerCrop()
                        .into(binding.ivMyImage)
                }
            }
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
package kr.co.moreversal.grapthathoe.view.fragment

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import kr.co.moreversal.grapthathoe.R
import kr.co.moreversal.grapthathoe.databinding.FragmentPost10Binding
import kr.co.moreversal.grapthathoe.view.activity.MainActivity
import kr.co.moreversal.grapthathoe.viewmodel.fragment.*
import java.util.*

class Post10Fragment : Fragment() {
    lateinit var binding : FragmentPost10Binding
    lateinit var post10ViewModel: Post10ViewModel

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
            R.layout.fragment_post10,
            container,
            false
        )
        performViewModel()

        with(post10ViewModel) {
            onBackEvent.observe(this@Post10Fragment, {
                findNavController().navigate(R.id.action_post10Fragment_to_post9Fragment)
            })

            onPostEvent.observe(this@Post10Fragment, {
                findNavController().navigate(R.id.action_post10Fragment_to_farmerHomeFragment)
            })

            onPhotoEvent.observe(this@Post10Fragment, {
                val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                intent.type = "image/*"
                startActivityForResult(intent, 10)
            })
        }

        return binding.root
    }

    private fun performViewModel() {
        post10ViewModel = ViewModelProvider(this).get(Post10ViewModel::class.java)
        binding.vm = post10ViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
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
                        .into(binding.ivExplain)
                }
            }
        }
    }

}
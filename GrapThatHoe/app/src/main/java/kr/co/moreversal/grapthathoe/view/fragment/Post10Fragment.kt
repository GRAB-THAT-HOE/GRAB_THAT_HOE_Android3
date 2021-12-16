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
import android.widget.Toast
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

    companion object {
        var Title : String = ""
        var Mainlocation : String = ""
        var Explanation : String = ""
        var Salary : Int = 0
        var AdditionalExplantion : String = ""
        var IsDisable : Boolean = false
        var IsForeign : Boolean = false
        var GiveRoomAndBoard : Boolean = false
        var GiveSnack : Boolean = false
        var StartDateYear : Int = 0
        var StartDateMonth : Int = 0
        var StartDateDay : Int = 0
        var EndDateYear : Int = 0
        var EndDateMonth : Int = 0
        var EndDateDay : Int = 0
        var StartTime : Int = 0
        var EndTime : Int = 0
        var BreakTime : Int = 0
        var Img : String = ""
    }

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

            onSuccessEvent.observe(this@Post10Fragment, {
                findNavController().navigate(R.id.action_post10Fragment_to_farmerHomeFragment)
            })

            onPostEvent.observe(this@Post10Fragment, {
                title.value = Title
                mainLocation.value = Mainlocation
                explanation.value = Explanation
                salary.value = Salary
                additionalExplantion.value = AdditionalExplantion
                isDisable.value = IsDisable
                isForeign.value = IsForeign
                giveRoomAndBoard.value = GiveRoomAndBoard
                giveSnack.value = GiveSnack
                startDateYear.value = StartDateYear
                startDateMonth.value = StartDateMonth
                startDateDay.value = StartDateDay
                endDateYear.value = EndDateYear
                endDateMonth.value = EndDateMonth
                endDateDay.value = EndDateDay
                startTime.value = StartTime
                endTime.value = EndTime
                breakTime.value = BreakTime
                img.value = Img
            })

            message.observe(this@Post10Fragment.viewLifecycleOwner, {
                Toast.makeText(context, "${message.value}", Toast.LENGTH_SHORT).show()
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
                Img = imageUri.toString()
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
package kr.co.moreversal.grapthathoe.viewmodel.fragment

import androidx.lifecycle.ViewModel
import kr.co.moreversal.grapthathoe.extension.SingleLiveEvent

class Post10ViewModel: ViewModel() {
    val onBackEvent = SingleLiveEvent<Unit>()
    val onPostEvent = SingleLiveEvent<Unit>()
    val onPhotoEvent = SingleLiveEvent<Unit>()

    fun onClickPhoto() {
        onPhotoEvent.call()
    }

    fun onClickBack() {
        onBackEvent.call()
    }

    fun onClickPost() {
        onPostEvent.call()
    }
}
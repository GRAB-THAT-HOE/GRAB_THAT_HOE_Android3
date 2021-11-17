package kr.co.moreversal.grapthathoe.viewmodel.fragment

import androidx.lifecycle.ViewModel
import kr.co.moreversal.grapthathoe.extension.SingleLiveEvent

class EditProfileViewModel: ViewModel() {
    val onBackEvent = SingleLiveEvent<Unit>()
    val onChangeImgEvent = SingleLiveEvent<Unit>()

    fun onClickBack() {
        onBackEvent.call()
    }

    fun onClickChangeImg() {
        onChangeImgEvent.call()
    }
}
package kr.co.moreversal.grapthathoe.viewmodel.activity

import androidx.lifecycle.ViewModel
import kr.co.moreversal.grapthathoe.extension.SingleLiveEvent

class CreateProfileViewModel : ViewModel(){
    val onCheckEvent = SingleLiveEvent<Unit>()
    val onBackEvent = SingleLiveEvent<Unit>()

    fun onClickCheck() {
        onCheckEvent.call()
    }

    fun onClickBack() {
        onBackEvent.call()
    }
}
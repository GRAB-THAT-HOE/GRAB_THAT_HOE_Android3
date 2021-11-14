package kr.co.moreversal.grapthathoe.viewmodel.fragment

import androidx.lifecycle.ViewModel
import kr.co.moreversal.grapthathoe.extension.SingleLiveEvent

class DetailProfileViewModel: ViewModel() {
    val onBackEvent = SingleLiveEvent<Unit>()
    val onCallEvent = SingleLiveEvent<Unit>()

    fun onClickCall() {
        onCallEvent.call()
    }

    fun onClickBack() {
        onBackEvent.call()
    }
}
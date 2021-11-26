package kr.co.moreversal.grapthathoe.viewmodel.fragment

import androidx.lifecycle.ViewModel
import kr.co.moreversal.grapthathoe.extension.SingleLiveEvent

class Post8ViewModel: ViewModel() {
    val onBackEvent = SingleLiveEvent<Unit>()
    val onNextEvent = SingleLiveEvent<Unit>()
    val onStartTimeEvent = SingleLiveEvent<Unit>()
    val onEndTimeEvent = SingleLiveEvent<Unit>()

    fun onClickBack() {
        onBackEvent.call()
    }

    fun onClickNext() {
        onNextEvent.call()
    }

    fun onClickStartTime() {
        onStartTimeEvent.call()
    }

    fun onClickEndTime() {
        onEndTimeEvent.call()
    }

}
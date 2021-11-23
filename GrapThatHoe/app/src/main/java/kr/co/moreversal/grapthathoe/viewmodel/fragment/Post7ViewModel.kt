package kr.co.moreversal.grapthathoe.viewmodel.fragment

import androidx.lifecycle.ViewModel
import kr.co.moreversal.grapthathoe.extension.SingleLiveEvent

class Post7ViewModel: ViewModel() {
    val onBackEvent = SingleLiveEvent<Unit>()
    val onStartDateEvent = SingleLiveEvent<Unit>()
    val onEndDateEvent = SingleLiveEvent<Unit>()

    fun onClickBack() {
        onBackEvent.call()
    }

    fun onClickStartDate() {
        onStartDateEvent.call()
    }

    fun onClickEndDate() {
        onEndDateEvent.call()
    }

}
package kr.co.moreversal.grapthathoe.viewmodel.fragment

import androidx.lifecycle.ViewModel
import kr.co.moreversal.grapthathoe.extension.SingleLiveEvent

class DetailFarmViewModel: ViewModel() {
    val onBackEvent = SingleLiveEvent<Unit>()
    val onCallEvent = SingleLiveEvent<Unit>()
    val onShowDetailEvent = SingleLiveEvent<Unit>()

    fun onClickBack() {
        onBackEvent.call()
    }

    fun onClickCall() {
        onCallEvent.call()
    }

    fun onClickShowDetail() {
        onShowDetailEvent.call()
    }

}
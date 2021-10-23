package kr.co.moreversal.grapthathoe.viewmodel.activity

import androidx.lifecycle.ViewModel
import kr.co.moreversal.grapthathoe.extension.SingleLiveEvent

class StartViewModel: ViewModel() {
    val onStartEvent = SingleLiveEvent<Unit>()

    fun onClickStart() {
        onStartEvent.call()
    }
}
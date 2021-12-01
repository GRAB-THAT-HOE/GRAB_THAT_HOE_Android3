package kr.co.moreversal.grapthathoe.viewmodel.fragment

import androidx.lifecycle.ViewModel
import kr.co.moreversal.grapthathoe.extension.SingleLiveEvent

class SettingViewModel: ViewModel() {
    val onBackEvent = SingleLiveEvent<Unit>()

    fun onClickBack() {
        onBackEvent.call()
    }
}
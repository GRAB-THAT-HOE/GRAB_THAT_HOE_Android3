package kr.co.moreversal.grapthathoe.viewmodel.activity

import androidx.lifecycle.ViewModel
import kr.co.moreversal.grapthathoe.extension.SingleLiveEvent

class MainViewModel : ViewModel() {
    val onSettingEvent = SingleLiveEvent<Unit>()

    fun onClickSetting() {
        onSettingEvent.call()
    }
}
package kr.co.moreversal.grapthathoe.viewmodel.fragment

import androidx.lifecycle.ViewModel
import kr.co.moreversal.grapthathoe.extension.SingleLiveEvent

class Post9ViewModel: ViewModel() {
    val onBackEvent = SingleLiveEvent<Unit>()
    val onPostEvent = SingleLiveEvent<Unit>()
    val onRefreshTimeEvent = SingleLiveEvent<Unit>()

    fun onClickBack() {
        onBackEvent.call()
    }

    fun onClickPost() {
        onPostEvent.call()
    }

    fun onClickRefreshTime() {
        onRefreshTimeEvent.call()
    }
}
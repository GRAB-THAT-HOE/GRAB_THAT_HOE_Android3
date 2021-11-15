package kr.co.moreversal.grapthathoe.viewmodel.fragment

import androidx.lifecycle.ViewModel
import kr.co.moreversal.grapthathoe.extension.SingleLiveEvent

class FarmerProfileViewModel: ViewModel() {
    val onPostEvent = SingleLiveEvent<Unit>()
    val onEditEvent = SingleLiveEvent<Unit>()

    fun onClickPost() {
        onPostEvent.call()
    }

    fun onClickEdit() {
        onEditEvent.call()
    }
}
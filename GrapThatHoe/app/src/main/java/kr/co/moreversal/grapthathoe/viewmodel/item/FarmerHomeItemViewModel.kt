package kr.co.moreversal.grapthathoe.viewmodel.item

import androidx.lifecycle.ViewModel
import kr.co.moreversal.grapthathoe.extension.SingleLiveEvent

class FarmerHomeItemViewModel: ViewModel() {
    val onDetailEvent = SingleLiveEvent<Unit>()

    fun onClickDetail() {
        onDetailEvent.call()
    }
}
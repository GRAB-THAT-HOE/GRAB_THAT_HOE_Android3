package kr.co.moreversal.grapthathoe.viewmodel.item

import androidx.lifecycle.ViewModel
import kr.co.moreversal.grapthathoe.extension.SingleLiveEvent

class ConnectItemViewModel: ViewModel() {
    val onDetailProfileEvent = SingleLiveEvent<Unit>()

    fun onClickDetailProfile() {
        onDetailProfileEvent.call()
    }

}
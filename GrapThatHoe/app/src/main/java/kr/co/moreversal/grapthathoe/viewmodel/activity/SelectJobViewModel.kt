package kr.co.moreversal.grapthathoe.viewmodel.activity

import androidx.lifecycle.ViewModel
import kr.co.moreversal.grapthathoe.extension.SingleLiveEvent

class SelectJobViewModel: ViewModel() {
    val onFarmerEvent = SingleLiveEvent<Unit>()
    val onWorkerEvent = SingleLiveEvent<Unit>()

    fun onClickFarmer() {
        onFarmerEvent.call()
    }

    fun onClickWorker() {
        onWorkerEvent.call()
    }
}
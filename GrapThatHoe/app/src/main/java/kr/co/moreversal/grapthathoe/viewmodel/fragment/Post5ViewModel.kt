package kr.co.moreversal.grapthathoe.viewmodel.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.co.moreversal.grapthathoe.extension.SingleLiveEvent

class Post5ViewModel: ViewModel() {
    val onBackEvent = SingleLiveEvent<Unit>()
    val onNextEvent = SingleLiveEvent<Unit>()

    val location = MutableLiveData<String>()

    fun onClickBack() {
        onBackEvent.call()
    }

    fun onClickNext() {
        onNextEvent.call()
    }
}
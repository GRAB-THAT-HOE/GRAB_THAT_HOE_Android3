package kr.co.moreversal.grapthathoe.viewmodel.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.co.moreversal.grapthathoe.extension.SingleLiveEvent

class Post4ViewModel: ViewModel() {
    val onBackEvent = SingleLiveEvent<Unit>()
    val onNextEvent = SingleLiveEvent<Unit>()

    val cost = MutableLiveData<String>()

    fun onClickBack() {
        onBackEvent.call()
    }

    fun onClickNext() {
        onNextEvent.call()
    }
}
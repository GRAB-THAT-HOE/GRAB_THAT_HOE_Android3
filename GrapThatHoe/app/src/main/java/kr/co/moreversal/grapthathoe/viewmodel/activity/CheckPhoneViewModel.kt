package kr.co.moreversal.grapthathoe.viewmodel.activity

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.co.moreversal.grapthathoe.extension.SingleLiveEvent

class CheckPhoneViewModel: ViewModel() {
    val onResponseEvent = SingleLiveEvent<Unit>()
    val onCheckEvent = SingleLiveEvent<Unit>()


    val phoneNum = MutableLiveData<String>()
    val num = MutableLiveData<String>()

    fun onClickResponse() {
        onResponseEvent.call()
        Log.d("TEST", "onClickPhone: 인증번호 받기")
    }

    fun onClickResend() {
        Log.d("TEST", "onClickResend: 재전송하기")
    }

    fun onClickCheck() {
        onCheckEvent.call()
    }


}
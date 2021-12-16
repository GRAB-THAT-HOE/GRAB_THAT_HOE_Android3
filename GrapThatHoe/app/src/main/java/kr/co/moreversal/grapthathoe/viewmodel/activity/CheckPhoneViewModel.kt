package kr.co.moreversal.grapthathoe.viewmodel.activity

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.co.moreversal.grapthathoe.extension.SingleLiveEvent
import kr.co.moreversal.grapthathoe.network.model.RetrofitClient
import kr.co.moreversal.grapthathoe.network.response.ErrorResponse
import kr.co.moreversal.grapthathoe.network.response.PhoneResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CheckPhoneViewModel: ViewModel() {
    val onResponseEvent = SingleLiveEvent<Unit>()
    val onCheckEvent = SingleLiveEvent<Unit>()
    val onResendEvent = SingleLiveEvent<Unit>()

    val phoneNum = MutableLiveData<String>()
    val num = MutableLiveData<String>()
    val message = MutableLiveData<String>()

    fun onClickResponse() {
        val sendPhone = RetrofitClient.signInterface.phone(phoneNum.value!!.toInt())

        sendPhone.enqueue(object : Callback<PhoneResponse> {
            override fun onResponse(
                call: Call<PhoneResponse>,
                response: Response<PhoneResponse>
            ) {
                if (response.isSuccessful) {
                    onResponseEvent.call()
                } else {
                    val errorBody = RetrofitClient.instance.responseBodyConverter<ErrorResponse>(
                        ErrorResponse::class.java, ErrorResponse::class.java.annotations).convert(response.errorBody())
                    message.value = errorBody?.error
                    Log.d("Retrofit2", "onResponse: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<PhoneResponse>, t: Throwable) {
                Log.d("Retrofit2", "onFailure: $t")
            }
        })
    }

    fun onClickResend() {
        onResendEvent.call()
        Log.d("TEST", "onClickResend: 재전송하기")
    }

    fun onClickCheck() {
        onCheckEvent.call()
    }
}
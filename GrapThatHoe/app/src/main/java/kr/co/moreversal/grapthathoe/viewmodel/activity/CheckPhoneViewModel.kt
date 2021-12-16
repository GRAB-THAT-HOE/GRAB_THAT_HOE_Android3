package kr.co.moreversal.grapthathoe.viewmodel.activity

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.co.moreversal.grapthathoe.extension.SingleLiveEvent
import kr.co.moreversal.grapthathoe.network.model.RetrofitClient
import kr.co.moreversal.grapthathoe.network.request.ConfirmRequest
import kr.co.moreversal.grapthathoe.network.request.LoginRequest
import kr.co.moreversal.grapthathoe.network.response.ConfirmResponse
import kr.co.moreversal.grapthathoe.network.response.ErrorResponse
import kr.co.moreversal.grapthathoe.network.response.LoginResponse
import kr.co.moreversal.grapthathoe.network.response.PhoneResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class CheckPhoneViewModel: ViewModel() {
    val onResponseEvent = SingleLiveEvent<Unit>()
    val onCheckEvent = SingleLiveEvent<Unit>()
    val onResendEvent = SingleLiveEvent<Unit>()
    val onHadEvent = SingleLiveEvent<Unit>()

    val phoneNum = MutableLiveData<String>()
    val num = MutableLiveData<String>()
    val message = MutableLiveData<String>()

    val token = MutableLiveData<String>()

    fun onClickResponse() {
        val sendPhone = RetrofitClient.signInterface.phone(phoneNum.value!!.toInt())

        sendPhone.enqueue(object : Callback<PhoneResponse> {
            override fun onResponse(
                call: Call<PhoneResponse>,
                response: Response<PhoneResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body()?.isExist == true) {
                        val loginRequest = LoginRequest(
                            phoneNum.value!!.toInt()
                        )
                        RetrofitClient.signInterface.login(loginRequest)
                            .enqueue(object : retrofit2.Callback<LoginResponse> {
                                override fun onResponse(
                                    call: Call<LoginResponse>,
                                    response: Response<LoginResponse>
                                ) {
                                    if (response.isSuccessful) {
                                        token.value = response.body()?.token
                                        onHadEvent.call()
                                    } else {
                                        val errorBody = RetrofitClient.instance.responseBodyConverter<ErrorResponse>(
                                            ErrorResponse::class.java, ErrorResponse::class.java.annotations).convert(response.errorBody())
                                        message.value = errorBody?.message
                                        Log.d("Retrofit2", "onResponse: ${response.code()}")
                                    }
                                }

                                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                                    Log.d("Retrofit2", "onFailure: $t")
                                }

                            })
                    } else {
                        onResponseEvent.call()
                    }
                } else {
                    val errorBody = RetrofitClient.instance.responseBodyConverter<ErrorResponse>(
                        ErrorResponse::class.java, ErrorResponse::class.java.annotations).convert(response.errorBody())
                    message.value = errorBody?.message
                    Log.d("Retrofit2", "onResponse: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<PhoneResponse>, t: Throwable) {
                Log.d("Retrofit2", "onFailure: $t")
            }
        })
    }

    fun onClickResend() {
        onClickResponse()
        onResendEvent.call()
    }

    fun onClickCheck() {
        val confirmRequest = ConfirmRequest(
            num.value!!.toInt()
        )

        RetrofitClient.signInterface.confirm(confirmRequest, phoneNum.value!!.toInt())
            .enqueue(object : retrofit2.Callback<ConfirmResponse> {
                override fun onResponse(
                    call: Call<ConfirmResponse>,
                    response: Response<ConfirmResponse>
                ) {
                    if (response.isSuccessful) {
                        onCheckEvent.call()
                    } else {
                        val errorBody = RetrofitClient.instance.responseBodyConverter<ErrorResponse>(
                            ErrorResponse::class.java, ErrorResponse::class.java.annotations).convert(response.errorBody())
                        message.value = errorBody?.message
                        Log.d("Retrofit2", "onResponse: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<ConfirmResponse>, t: Throwable) {
                    Log.d("Retrofit2", "onFailure: $t")
                }
            })
    }
}
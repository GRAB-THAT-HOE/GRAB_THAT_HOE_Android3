package kr.co.moreversal.grapthathoe.viewmodel.activity

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.co.moreversal.grapthathoe.extension.SingleLiveEvent
import kr.co.moreversal.grapthathoe.network.model.RetrofitClient
import kr.co.moreversal.grapthathoe.network.request.LoginRequest
import kr.co.moreversal.grapthathoe.network.response.ErrorResponse
import kr.co.moreversal.grapthathoe.network.response.LoginResponse
import retrofit2.Call
import retrofit2.Response

class StartViewModel: ViewModel() {
    val onStartEvent = SingleLiveEvent<Unit>()
    val onSuccessEvent = SingleLiveEvent<Unit>()

    val phoneNum = MutableLiveData<Int>()
    val token = MutableLiveData<String>()

    val message = MutableLiveData<String>()

    fun onClickStart() {
        onStartEvent.call()
    }

    fun login() {
        val loginResult = LoginRequest(
            phoneNum.value!!
        )

        RetrofitClient.signInterface.login(loginResult)
            .enqueue(object : retrofit2.Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        token.value = response.body()?.token
                        onSuccessEvent.call()
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
    }
}
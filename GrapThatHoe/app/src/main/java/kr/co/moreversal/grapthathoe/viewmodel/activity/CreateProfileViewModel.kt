package kr.co.moreversal.grapthathoe.viewmodel.activity

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.co.moreversal.grapthathoe.extension.SingleLiveEvent
import kr.co.moreversal.grapthathoe.network.model.RetrofitClient
import kr.co.moreversal.grapthathoe.network.request.JoinRequest
import kr.co.moreversal.grapthathoe.network.request.LoginRequest
import kr.co.moreversal.grapthathoe.network.response.ErrorResponse
import kr.co.moreversal.grapthathoe.network.response.JoinResponse
import kr.co.moreversal.grapthathoe.network.response.LoginResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit

class CreateProfileViewModel : ViewModel(){
    val onCheckEvent = SingleLiveEvent<Unit>()
    val onBackEvent = SingleLiveEvent<Unit>()
    val onChangeImgEvent = SingleLiveEvent<Unit>()

    val name = MutableLiveData<String>()
    val introduce = MutableLiveData<String>()
    val permission = MutableLiveData<Int>()
    val phone = MutableLiveData<Int>()
    val token = MutableLiveData<String>()
    val message = MutableLiveData<String>()

    val sublocation: String = "구지"
    val mainlocation : String = "대구소프트웨어마이스터고등학교"

    fun onClickCheck() {
        val joinRequest = JoinRequest(
            name.value ?: "",
            phone.value!!,
            introduce.value ?: "",
            permission.value!!,
            sublocation,
            mainlocation
        )

        RetrofitClient.signInterface.join(joinRequest)
            .enqueue(object : retrofit2.Callback<JoinResponse> {
                override fun onResponse(
                    call: Call<JoinResponse>,
                    response: Response<JoinResponse>
                ) {
                    if (response.isSuccessful) {
                        login()
                    } else {
                        val errorBody = RetrofitClient.instance.responseBodyConverter<ErrorResponse>(
                            ErrorResponse::class.java, ErrorResponse::class.java.annotations).convert(response.errorBody())
                        message.value = errorBody?.message
                        Log.d("Retrofit2", "onResponse: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<JoinResponse>, t: Throwable) {
                    Log.d("Retrofit2", "onFailure: $t")
                }
            })
    }

    fun login() {
        val loginRequest = LoginRequest(
            phone.value!!
        )
        RetrofitClient.signInterface.login(loginRequest)
            .enqueue(object : retrofit2.Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        token.value = response.body()?.token
                        onCheckEvent.call()
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

    fun onClickBack() {
        onBackEvent.call()
    }

    fun onClickChangeImg() {
        onChangeImgEvent.call()
    }
}
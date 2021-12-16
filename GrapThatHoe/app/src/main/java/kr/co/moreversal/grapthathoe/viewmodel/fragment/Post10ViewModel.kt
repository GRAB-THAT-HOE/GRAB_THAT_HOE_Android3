package kr.co.moreversal.grapthathoe.viewmodel.fragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.co.moreversal.grapthathoe.extension.SingleLiveEvent
import kr.co.moreversal.grapthathoe.network.model.RetrofitClient
import kr.co.moreversal.grapthathoe.network.request.PostRequest
import kr.co.moreversal.grapthathoe.network.response.ErrorResponse
import kr.co.moreversal.grapthathoe.network.response.PostResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit

class Post10ViewModel: ViewModel() {
    val onBackEvent = SingleLiveEvent<Unit>()
    val onPostEvent = SingleLiveEvent<Unit>()
    val onPhotoEvent = SingleLiveEvent<Unit>()
    val onSuccessEvent = SingleLiveEvent<Unit>()

    val title = MutableLiveData<String>()
    val mainLocation = MutableLiveData<String>()
    val subLocation = ""
    val explanation = MutableLiveData<String>()
    val salary = MutableLiveData<Int>()
    val additionalExplantion = MutableLiveData<String>()
    val isDisable = MutableLiveData<Boolean>()
    val isForeign = MutableLiveData<Boolean>()
    val giveRoomAndBoard = MutableLiveData<Boolean>()
    val giveSnack = MutableLiveData<Boolean>()
    val startDateYear = MutableLiveData<Int>()
    val startDateMonth = MutableLiveData<Int>()
    val startDateDay = MutableLiveData<Int>()
    val endDateYear = MutableLiveData<Int>()
    val endDateMonth = MutableLiveData<Int>()
    val endDateDay = MutableLiveData<Int>()
    val startTime = MutableLiveData<Int>()
    val endTime = MutableLiveData<Int>()
    val breakTime = MutableLiveData<Int>()
    val img = MutableLiveData<String>()

    val message = MutableLiveData<String>()

    fun onClickPhoto() {
        onPhotoEvent.call()
    }

    fun onClickBack() {
        onBackEvent.call()
    }

    fun onClickPost() {
        onPostEvent.call()

        val postRequest = PostRequest(
            title.value ?: "",
            mainLocation.value ?: "",
            subLocation,
            explanation.value ?: "",
            salary.value!!,
            additionalExplantion.value ?: "",
            isDisable.value ?: false,
            isForeign.value ?: false,
            giveRoomAndBoard.value ?: false,
            giveSnack.value ?: false,
            startDateYear.value!!,
            startDateMonth.value!!,
            startDateDay.value!!,
            endDateYear.value!!,
            endDateMonth.value!!,
            endDateDay.value!!,
            startTime.value!!,
            endTime.value!!,
            breakTime.value!!,
            img.value ?: ""
        )

        RetrofitClient.postInterface.post(postRequest)
            .enqueue(object : retrofit2.Callback<PostResponse> {
                override fun onResponse(
                    call: Call<PostResponse>,
                    response: Response<PostResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.d("Retrofit2", "onResponse: 성공")
                        onSuccessEvent.call()
                    } else {
                        val errorBody = RetrofitClient.instance.responseBodyConverter<ErrorResponse>(
                            ErrorResponse::class.java, ErrorResponse::class.java.annotations).convert(response.errorBody())
                        message.value = errorBody?.message
                        Log.d("Retrofit2", "onResponse: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                    Log.d("Retrofit2", "onFailure: $t")
                }
            })

    }
}
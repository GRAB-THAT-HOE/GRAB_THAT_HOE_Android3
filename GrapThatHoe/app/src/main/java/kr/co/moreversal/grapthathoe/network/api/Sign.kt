package kr.co.moreversal.grapthathoe.network.api

import kr.co.moreversal.grapthathoe.network.response.PhoneResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Sign {
    @GET("auth/phone/{phone}")
    fun phone(@Path("phone") phone: Int): Call<PhoneResponse>
}
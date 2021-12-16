package kr.co.moreversal.grapthathoe.network.api

import kr.co.moreversal.grapthathoe.network.request.PostRequest
import kr.co.moreversal.grapthathoe.network.response.PostResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface Post {
    @POST("post/")
    fun post(@Body postRequest: PostRequest) : retrofit2.Call<PostResponse>
}
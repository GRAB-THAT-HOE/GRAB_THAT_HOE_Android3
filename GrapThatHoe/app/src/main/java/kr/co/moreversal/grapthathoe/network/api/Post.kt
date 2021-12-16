package kr.co.moreversal.grapthathoe.network.api

import kr.co.moreversal.grapthathoe.network.request.PostRequest
import kr.co.moreversal.grapthathoe.network.response.PostResponse
import kr.co.moreversal.grapthathoe.network.response.PostsResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Post {
    @POST("post/")
    fun post(@Body postRequest: PostRequest) : retrofit2.Call<PostResponse>

    @GET("post/")
    fun posts(): retrofit2.Call<PostsResponse>
}
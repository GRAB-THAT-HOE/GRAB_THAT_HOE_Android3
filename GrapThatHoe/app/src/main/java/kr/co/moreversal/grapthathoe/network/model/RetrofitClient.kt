package kr.co.moreversal.grapthathoe.network.model

import com.google.gson.GsonBuilder
import kr.co.moreversal.grapthathoe.network.api.Sign
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val BASE_URL = "http://10.21.13.114:4000/api/v1/"

    val signInterface : Sign

    private val gson = GsonBuilder().setLenient().create()
    private val intercepter = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val logger = OkHttpClient.Builder().addInterceptor(intercepter).addInterceptor(TokenInterceptor())
        .connectTimeout(100, TimeUnit.SECONDS)
        .readTimeout(100, TimeUnit.SECONDS)
        .writeTimeout(100, TimeUnit.SECONDS)
        .build()


    val instance: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(logger)
        .build()

    init {
        signInterface = instance.create(Sign::class.java)
    }
}
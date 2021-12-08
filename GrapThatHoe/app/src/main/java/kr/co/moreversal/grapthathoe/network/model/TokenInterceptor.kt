package kr.co.moreversal.grapthathoe.network.model

import android.content.Context
import android.util.Log
import kr.co.moreversal.grapthathoe.view.activity.CheckPhoneActivity
import okhttp3.Interceptor
import retrofit2.Response

class TokenInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val context: Context = MyApp.instance
        // TODO : 토큰 받기
        val sharedPref = context.getSharedPreferences(CheckPhoneActivity.TOKEN_PREFERENCE, Context.MODE_PRIVATE)
        val token = sharedPref.getString("token", "") ?: ""
        Log.e("TESTTEST", "token $token")
        val request = chain.request().newBuilder()
            .header("authorization", "Bearer $token")
            .build()
        return chain.proceed(request)
    }
}
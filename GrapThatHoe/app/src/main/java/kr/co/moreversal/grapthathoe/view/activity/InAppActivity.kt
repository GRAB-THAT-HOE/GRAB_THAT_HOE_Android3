package kr.co.moreversal.grapthathoe.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kr.co.moreversal.grapthathoe.R

class InAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_in_app)

        startLoading()

    }

    private fun startLoading() {
        val handler = Handler()
        handler.postDelayed({
            kotlin.run {
                val intent = Intent(applicationContext, StartActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 1000)
    }
}
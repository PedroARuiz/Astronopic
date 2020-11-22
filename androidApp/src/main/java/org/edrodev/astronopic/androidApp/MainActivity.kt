package org.edrodev.astronopic.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.runBlocking
import org.edrodev.astronopic.R
import org.edrodev.astronopic.data.remote.service.ApodServiceImpl

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = runBlocking { ApodServiceImpl().getApod().toString() }
    }
}

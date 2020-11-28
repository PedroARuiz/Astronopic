package org.edrodev.astronopic.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.coroutines.runBlocking
import org.edrodev.astronopic.R
import org.edrodev.astronopic.core.datetime.today
import org.edrodev.astronopic.data.remote.dataSource.ApodRemoteDataSourceImpl
import org.edrodev.astronopic.data.remote.service.ApodServiceImpl
import org.edrodev.astronopic.data.repositoryImpl.ApodRepositoryImpl
import org.edrodev.astronopic.domain.useCase.GetApod

class MainActivity : AppCompatActivity() {

    private val useCase: GetApod by lazy {
        GetApod(
            apodRepository = ApodRepositoryImpl(
                apodRemoteDataSource = ApodRemoteDataSourceImpl(
                    apodService = ApodServiceImpl()
                ),
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val root: View = findViewById(R.id.main_view)
        val tv: TextView = findViewById(R.id.text_view)
        tv.text = runBlocking { useCase(today()).toString() }

        root.setOnClickListener {
            tv.text = runBlocking { useCase(today()).toString() }
        }
    }
}

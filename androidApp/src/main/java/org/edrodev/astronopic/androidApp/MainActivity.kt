package org.edrodev.astronopic.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.runBlocking
import kotlinx.datetime.LocalDate
import org.edrodev.astronopic.R
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

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = runBlocking { useCase.getApod(LocalDate(2020, 11, 24)).toString() }
    }
}

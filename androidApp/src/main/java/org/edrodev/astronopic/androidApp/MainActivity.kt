package org.edrodev.astronopic.androidApp

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import org.edrodev.astronopic.R
import org.edrodev.astronopic.data.remote.dataSource.ApodRemoteDataSourceImpl
import org.edrodev.astronopic.data.remote.service.ApodServiceImpl
import org.edrodev.astronopic.data.repositoryImpl.ApodRepositoryImpl
import org.edrodev.astronopic.domain.useCase.GetApod
import org.edrodev.astronopic.presentation.apod.ApodViewModel
import org.edrodev.astronopic.presentation.core.Resource

class MainActivity : AppCompatActivity() {

    private val viewModel: ApodViewModel by lazy {
        ApodViewModel(
            getApod = GetApod(
                apodRepository = ApodRepositoryImpl(
                    apodRemoteDataSource = ApodRemoteDataSourceImpl(
                        apodService = ApodServiceImpl()
                    ),
                )
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val root: View = findViewById(R.id.main_view)
        val tv: TextView = findViewById(R.id.text_view)
        val progressBar: ProgressBar = findViewById(R.id.progressBar)

        lifecycleScope.launchWhenStarted {
            viewModel.apod.collect {
                when(it) {
                    is Resource.Loading -> {
                        tv.text = null
                        progressBar.visibility = View.VISIBLE
                    }
                    is Resource.Result -> {
                        progressBar.visibility = View.GONE
                        tv.text = it.toString()
                    }
                }
            }
        }
    }
}

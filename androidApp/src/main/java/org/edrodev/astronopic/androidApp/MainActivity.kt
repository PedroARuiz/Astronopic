package org.edrodev.astronopic.androidApp

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import coil.load
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.retry
import org.edrodev.astronopic.R
import org.edrodev.astronopic.core.Failure
import org.edrodev.astronopic.core.Result
import org.edrodev.astronopic.data.remote.dataSource.ApodRemoteDataSourceImpl
import org.edrodev.astronopic.data.remote.service.ApodServiceImpl
import org.edrodev.astronopic.data.repositoryImpl.ApodRepositoryImpl
import org.edrodev.astronopic.domain.model.Apod
import org.edrodev.astronopic.domain.useCase.GetApod
import org.edrodev.astronopic.presentation.apod.ApodViewModel
import org.edrodev.astronopic.presentation.core.Resource
import org.edrodev.astronopic.presentation.core.isLoading

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

        val mainView = findViewById<SwipeRefreshLayout>(R.id.main_view).apply {
            setOnRefreshListener { viewModel.refresh() }
        }

        findViewById<View>(R.id.previous).apply {
            setOnClickListener { viewModel.previous() }
        }

        findViewById<View>(R.id.next).apply {
            setOnClickListener { viewModel.next() }
        }
        val tv: ImageView = findViewById(R.id.text_view)

        lifecycleScope.launchWhenStarted {
            viewModel.apod.collect {
                mainView.isRefreshing = it.isLoading
                when(it) {
                    is Resource.Success ->
                        tv.load(
                            uri = it.data.url
                        ) {
                            placeholder(CircularProgressDrawable(this@MainActivity))
                        }
                }
            }
        }
    }
}

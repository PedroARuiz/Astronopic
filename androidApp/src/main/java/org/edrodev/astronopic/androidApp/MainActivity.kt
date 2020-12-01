package org.edrodev.astronopic.androidApp

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import coil.load
import kotlinx.coroutines.flow.collect
import org.edrodev.astronopic.R
import org.edrodev.astronopic.presentation.apod.ApodViewModel
import org.edrodev.astronopic.presentation.core.Resource
import org.edrodev.astronopic.presentation.core.isFailure
import org.edrodev.astronopic.presentation.core.isLoading
import org.edrodev.astronopic.presentation.core.isSuccess
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel: ApodViewModel by inject()

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
        val imageView: ImageView = findViewById(R.id.image_view)
        val tv: TextView = findViewById(R.id.text_view)

        lifecycleScope.launchWhenStarted {
            viewModel.apod.collect {
                mainView.isRefreshing = it.isLoading
                imageView.visibility = if(it.isSuccess) View.VISIBLE else View.GONE
                tv.visibility = if(it.isFailure) View.VISIBLE else View.GONE
                when(it) {
                    is Resource.Success ->
                        imageView.load(
                            uri = it.data.url
                        ) {
                            placeholder(CircularProgressDrawable(this@MainActivity))
                        }

                    is Resource.Failure -> {
                        tv.text = it.toString()
                    }
                }
            }
        }
    }
}

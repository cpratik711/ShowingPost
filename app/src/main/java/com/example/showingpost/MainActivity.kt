package com.example.showingpost

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.abhay.shadicardmatcher.ui.PostViewModel
import com.abhay.shadicardmatcher.utils.RepositoryResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val postViewModel by viewModels<PostViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postViewModel.users.observe(this, Observer { result ->
            when (result.status) {
                RepositoryResult.Status.SUCCESS -> {
                    Log.e("called", result.data.toString())
                }
            }
        })
    }
}
package com.example.showingpost

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.showingpost.ui.PostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val postViewModel by viewModels<PostViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postViewModel.users.observe(this, Observer { result ->

           // Log.e("called", result.toString());
            /* when (result.status) {
                 RepositoryResult.Status.SUCCESS -> {
                     Log.e("called", result.data.toString())
                 }
             }*/
        })
    }
}
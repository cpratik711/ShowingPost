package com.example.showingpost

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.showingpost.ui.PostViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val postViewModel by viewModels<PostViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val postViewModel = ViewModelProvider(this).get(PostViewModel::class.java)
        //Log.e("called", postViewModel.hashCode().toString());

        postViewModel.users.observe(this, Observer {
            Log.e("called", it.data.toString());
        })

        /*postViewModel.users.observe(this, Observer { result ->
            Log.e("called", result.data.toString());
        })*/


    }
}
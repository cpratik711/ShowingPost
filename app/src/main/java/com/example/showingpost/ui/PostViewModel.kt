package com.example.showingpost.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.showingpost.repository.PostRepository


class PostViewModel @ViewModelInject constructor(
    private val postRepository: PostRepository
) : ViewModel() {


    val users = postRepository.users


/*

    fun onAccept(shadiCardMatcherModel: ShadiCardMatcherModel) {
        shadiCardMatcherRepository.onAccept(shadiCardMatcherModel)
    }

    fun onReject(shadiCardMatcherModel: ShadiCardMatcherModel) {
        shadiCardMatcherRepository.onReject(shadiCardMatcherModel)
    }
*/

    override fun onCleared() {
        super.onCleared()
        postRepository.cancelAllRequests()
    }
}
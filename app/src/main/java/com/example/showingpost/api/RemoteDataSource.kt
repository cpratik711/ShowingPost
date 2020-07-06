package com.example.showingpost.api

import com.example.showingpost.ApiService
import com.example.showingpost.base.BaseRemoteDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val service: ApiService) :
    BaseRemoteDataSource() {

    suspend fun fetchUsers() = getResult { service.fetchPosts() }

}
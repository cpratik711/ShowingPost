package com.abhay.shadicardmatcher.data.api

import com.abhay.shadicardmatcher.base.BaseRemoteDataSource
import com.example.showingpost.ApiService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val service: ApiService) : {

    suspend fun fetchUsers() = getResult { service.fetchPosts() }

}
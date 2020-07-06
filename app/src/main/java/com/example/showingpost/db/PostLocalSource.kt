package com.example.showingpost.db

import androidx.lifecycle.LiveData
import com.example.showingpost.db_model.Post
import com.example.showingpost.utils.CoroutinesDispatcherProvider
import kotlinx.coroutines.withContext

class PostLocalSource(
    val reposDao: PostDao,
    val dispatcherProvider: CoroutinesDispatcherProvider
) {

    suspend fun insertAll(posts: List<Post>) =
        withContext(dispatcherProvider.ioDispatcher) {
            reposDao.insertAll(posts)
        }

    /* suspend fun updateOnAccept(selection: Int, emailId: String) {
         withContext(dispatcherProvider.ioDispatcher) {
             reposDao.updateOnAccept(selection, emailId)
         }
     }*/

    /* suspend fun updateOnReject(selection: Int, emailId: String) {
         withContext(dispatcherProvider.ioDispatcher) {
             reposDao.updateOnReject(selection, emailId)
         }
     }*/

    fun getAllList(): LiveData<List<Post>> {
        return reposDao.getAllList()
    }
}
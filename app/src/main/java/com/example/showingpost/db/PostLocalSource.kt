package com.abhay.shadicardmatcher.data.db

import androidx.lifecycle.LiveData
import com.abhay.shadicardmatcher.utils.CoroutinesDispatcherProvider
import com.example.showingpost.db_model.Post
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
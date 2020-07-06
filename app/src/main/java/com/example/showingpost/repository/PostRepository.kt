package com.example.showingpost.repository


import com.abhay.shadicardmatcher.data.api.RemoteDataSource
import com.abhay.shadicardmatcher.data.db.PostLocalSource
import com.abhay.shadicardmatcher.utils.CoroutinesDispatcherProvider
import com.abhay.shadicardmatcher.utils.resultLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val localSource: PostLocalSource,
    private val remoteDataSource: RemoteDataSource,
    private val dispatcherProvider: CoroutinesDispatcherProvider
) {
    private val parentJob = Job()
    private val scope = CoroutineScope(dispatcherProvider.mainDispatcher + parentJob)


    /* fun onAccept(shadiCardMatcherModel: ShadiCardMatcherModel) {
         scope.launch(dispatcherProvider.ioDispatcher) {
             val updateSelection = if (shadiCardMatcherModel.isAccept) 0 else 1
             val email: String = shadiCardMatcherModel.email
             localSource.updateOnAccept(updateSelection, email)
         }
     }

     fun onReject(shadiCardMatcherModel: ShadiCardMatcherModel) {
         scope.launch(dispatcherProvider.ioDispatcher) {
             val updateSelection = if (shadiCardMatcherModel.isReject) 0 else 1
             val email: String = shadiCardMatcherModel.email
             localSource.updateOnReject(updateSelection, email)
         }
     }
 */

    fun cancelAllRequests() {
        parentJob.cancelChildren()
    }

    val users =
        resultLiveData(
            databaseQuery = { localSource.getAllList() },
            networkCall = { remoteDataSource.fetchUsers() },
            saveCallResult = { localSource.insertAll(it.results) })


}
package com.abhay.shadicardmatcher.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.showingpost.db_model.Post

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(batches: List<Post>)

    @Query("SELECT * from posts")
    fun getAllList(): LiveData<List<Post>>

 /*   @Query("UPDATE shadi_card_matcher SET isAccept = :selection WHERE email =:emailId")
    fun updateOnAccept(selection: Int, emailId: String)

    @Query("UPDATE shadi_card_matcher SET isReject = :selection WHERE email =:emailId")
    fun updateOnReject(selection: Int, emailId: String)*/

}
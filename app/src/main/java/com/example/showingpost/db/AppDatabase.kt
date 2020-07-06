package com.abhay.shadicardmatcher.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.showingpost.db_model.Post

@Database(entities = [Post::class], version = 1,exportSchema = false)
//@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getPostDao(): PostDao


}
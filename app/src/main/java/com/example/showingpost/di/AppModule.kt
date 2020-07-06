package com.example.showingpost.di

import android.content.Context
import androidx.room.Room
import com.example.showingpost.ApiService
import com.example.showingpost.api.RemoteDataSource
import com.example.showingpost.db.AppDatabase
import com.example.showingpost.db.PostLocalSource
import com.example.showingpost.repository.PostRepository
import com.example.showingpost.utils.Constants
import com.example.showingpost.utils.Constants.Companion.DATABASE_NAME
import com.example.showingpost.utils.CoroutinesDispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesApiService(): ApiService {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BASIC

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(OkHttpClient().newBuilder().addInterceptor(logger).build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }


    @Singleton
    @Provides
    fun provideRepository(
        localSource: PostLocalSource,
        remoteDataSource: RemoteDataSource,
        dispatcherProvider: CoroutinesDispatcherProvider
    ): PostRepository {
        return PostRepository(localSource, remoteDataSource, dispatcherProvider)
    }


    @Singleton
    @JvmStatic
    @Provides
    fun provideShadiCardMatcherLocalCache(
        database: AppDatabase,
        dispatcherProvider: CoroutinesDispatcherProvider
    ): PostLocalSource {
        return PostLocalSource(database.getPostDao(), dispatcherProvider)
    }


    @Singleton
    @Provides
    fun provideShadiMatcherRemoteDataSource(
        service: ApiService
    ): RemoteDataSource {
        return RemoteDataSource(service)
    }

    @Singleton
    @Provides
    fun provideCoroutinesDispatcherProvider(): CoroutinesDispatcherProvider {
        return CoroutinesDispatcherProvider(
            Dispatchers.Main,
            Dispatchers.IO,
            Dispatchers.Default
        )
    }


    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java, DATABASE_NAME
        ).build()
    }

}



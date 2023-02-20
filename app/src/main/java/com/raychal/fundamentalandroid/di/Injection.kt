package com.raychal.fundamentalandroid.di

import android.content.Context
import com.raychal.fundamentalandroid.data.NewsRepository
import com.raychal.fundamentalandroid.data.source.local.room.NewsDatabase
import com.raychal.fundamentalandroid.data.source.remote.retrofit.ApiConfig
import com.raychal.fundamentalandroid.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): NewsRepository {
        val apiService = ApiConfig.getApiService()
        val database = NewsDatabase.getInstance(context)
        val dao = database.newsDao()
        val appExecutors = AppExecutors()
        return NewsRepository.getInstance(apiService, dao, appExecutors)
    }
}
package com.raychal.fundamentalandroid.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raychal.fundamentalandroid.data.NewsRepository
import com.raychal.fundamentalandroid.data.source.local.entity.NewsEntity
import kotlinx.coroutines.launch

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    fun getHeadlineNews() = newsRepository.getHeadlineNews()

    fun getBookmarkedNews() = newsRepository.getBookmarkedNews()

    fun saveNews(news: NewsEntity) {
        viewModelScope.launch {
            newsRepository.setNewsBookmark(news, true)
        }
    }

    fun deleteNews(news: NewsEntity) {
        viewModelScope.launch {
            newsRepository.setNewsBookmark(news, false)
        }
    }
}
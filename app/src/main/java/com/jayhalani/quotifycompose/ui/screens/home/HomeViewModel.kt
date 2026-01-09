package com.jayhalani.quotifycompose.ui.screens.home

import androidx.lifecycle.ViewModel
import com.jayhalani.quotifycompose.data.BannerModel
import com.jayhalani.quotifycompose.data.QuoteCategoryModel
import com.jayhalani.quotifycompose.data.QuoteModel
import com.jayhalani.quotifycompose.data.QuoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(private val repository: QuoteRepository = QuoteRepository()) : ViewModel() {

    private val _quotes = MutableStateFlow<List<QuoteModel>>(emptyList())
    val quotes: StateFlow<List<QuoteModel>> = _quotes.asStateFlow()

    private val _categories = MutableStateFlow<List<QuoteCategoryModel>>(emptyList())
    val categories: StateFlow<List<QuoteCategoryModel>> = _categories.asStateFlow()

    private val _banners = MutableStateFlow<List<BannerModel>>(emptyList())
    val banners: StateFlow<List<BannerModel>> = _banners.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        _quotes.value = repository.getQuotes().shuffled()
        _categories.value = repository.getCategories()
        _banners.value = repository.getBanners()
    }

    fun getRandomQuotes(count: Int): List<QuoteModel> {
        return _quotes.value.shuffled().take(count)
    }
}

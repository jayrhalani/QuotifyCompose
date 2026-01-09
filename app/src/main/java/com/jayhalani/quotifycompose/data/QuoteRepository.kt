package com.jayhalani.quotifycompose.data

class QuoteRepository {
    fun getQuotes(): List<QuoteModel> = getQuoteList()
    fun getCategories(): List<QuoteCategoryModel> = getQuoteCategories()
    fun getBanners(): List<BannerModel> = getBannerList()
}

package com.jayhalani.quotifycompose.ui.screens.explore

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.jayhalani.quotifycompose.data.QuoteCategory
import com.jayhalani.quotifycompose.data.QuoteCategoryModel
import com.jayhalani.quotifycompose.data.QuoteModel
import com.jayhalani.quotifycompose.data.QuoteRepository
import com.jayhalani.quotifycompose.ui.theme.AppStrings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ExploreViewModel(private val repository: QuoteRepository = QuoteRepository()) : ViewModel() {

    private val _categories = MutableStateFlow<List<QuoteCategoryModel>>(emptyList())
    val categories: StateFlow<List<QuoteCategoryModel>> = _categories.asStateFlow()

    private val _selectedCategoryModel = MutableStateFlow<QuoteCategoryModel?>(null)
    val selectedCategoryModel: StateFlow<QuoteCategoryModel?> = _selectedCategoryModel.asStateFlow()

    private val _allQuotes = MutableStateFlow<List<QuoteModel>>(emptyList())

    private val _filteredQuotes = MutableStateFlow<List<QuoteModel>>(emptyList())
    val filteredQuotesState: StateFlow<List<QuoteModel>> = _filteredQuotes.asStateFlow()

    init {
        val categoryList = listOf(
            QuoteCategoryModel(
                id = 0,
                name = AppStrings.CATEGORY_ALL,
                category = QuoteCategory.ALL,
                icon = Icons.Default.Dashboard,
                color = Color.Gray,
                contentDescription = AppStrings.CD_CAT_ALL
            )
        ) + repository.getCategories()
        
        _categories.value = categoryList
        _allQuotes.value = repository.getQuotes()
        _selectedCategoryModel.value = categoryList.first()
        updateFilteredQuotes()
    }

    fun setInitialCategory(categoryName: String?) {
        val category = _categories.value.find { it.category.name == categoryName } ?: _categories.value.first()
        _selectedCategoryModel.value = category
        updateFilteredQuotes()
    }

    fun selectCategory(category: QuoteCategoryModel) {
        _selectedCategoryModel.value = category
        updateFilteredQuotes()
    }

    private fun updateFilteredQuotes() {
        val selected = _selectedCategoryModel.value
        val all = _allQuotes.value
        _filteredQuotes.value = if (selected == null || selected.category == QuoteCategory.ALL) {
            all
        } else {
            all.filter { it.category == selected.category }
        }
    }

    fun getCategoryModel(category: QuoteCategory): QuoteCategoryModel {
        return _categories.value.find { it.category == category } ?: _categories.value.first { it.category == QuoteCategory.LIFE }
    }
}

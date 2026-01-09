package com.jayhalani.quotifycompose.ui.screens.explore

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.jayhalani.quotifycompose.data.QuoteCategory
import com.jayhalani.quotifycompose.data.QuoteCategoryModel
import com.jayhalani.quotifycompose.data.getQuoteCategories
import com.jayhalani.quotifycompose.data.getQuoteList
import com.jayhalani.quotifycompose.ui.screens.explore.components.ExploreCategoryChipContainer
import com.jayhalani.quotifycompose.ui.screens.explore.components.ExploreQuotesCard
import com.jayhalani.quotifycompose.ui.theme.AppDimens
import com.jayhalani.quotifycompose.ui.theme.AppStrings
import com.jayhalani.quotifycompose.ui.theme.Bold24

@Composable
fun ExploreScreen(
    initialSelectedCategory: String?, showBackButton: Boolean, onBack: () -> Unit
) {
    val categoryList = remember {
        listOf(
            QuoteCategoryModel(
                id = 0,
                name = AppStrings.CATEGORY_ALL,
                category = QuoteCategory.ALL,
                icon = Icons.Default.Dashboard,
                color = Color.Gray,
                contentDescription = AppStrings.CD_CAT_ALL
            )
        ) + getQuoteCategories()
    }
    var selectedCategoryModel by remember {
        mutableStateOf(categoryList.find { it.category.name == initialSelectedCategory } ?: categoryList.first())
    }
    val quoteList = remember { getQuoteList() }
    val filteredQuotes = remember(selectedCategoryModel) {
        if (selectedCategoryModel.category == QuoteCategory.ALL) {
            quoteList
        } else {
            quoteList.filter { it.category == selectedCategoryModel.category }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Row(
            modifier = Modifier.padding(vertical = AppDimens.paddingMedium),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (showBackButton) {
                Spacer(Modifier.width(AppDimens.widthSmall))
                Icon(
                    modifier = Modifier.clickable(onClick = onBack),
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = AppStrings.CD_NAV_BACK
                )
            }
            Spacer(Modifier.width(AppDimens.widthExtraSmall))
            Text(
                modifier = Modifier.padding(
                    start = AppDimens.paddingMedium, end = AppDimens.paddingMedium, bottom = AppDimens.paddingExtraSmall
                ),
                text = AppStrings.TITLE_CATEGORIES,
                style = MaterialTheme.typography.Bold24,
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(AppDimens.paddingMedium)
        ) {
            item {
                ExploreCategoryChipContainer(
                    categories = categoryList, selectedCategory = selectedCategoryModel
                ) { newCategory ->
                    selectedCategoryModel = newCategory
                }
            }

            items(filteredQuotes.size) {
                ExploreQuotesCard(filteredQuotes[it], selectedCategoryModel)
            }
        }
    }
}

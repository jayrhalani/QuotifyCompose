package com.jayhalani.quotifycompose.ui.screens.explore

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jayhalani.quotifycompose.ui.screens.explore.components.ExploreCategoryChipContainer
import com.jayhalani.quotifycompose.ui.screens.explore.components.ExploreQuotesCard
import com.jayhalani.quotifycompose.ui.theme.AppDimens
import com.jayhalani.quotifycompose.ui.theme.AppStrings
import com.jayhalani.quotifycompose.ui.theme.Bold24

@Composable
fun ExploreScreen(
    initialSelectedCategory: String?,
    showBackButton: Boolean,
    onBack: () -> Unit,
    viewModel: ExploreViewModel = viewModel()
) {
    val categories by viewModel.categories.collectAsState()
    val selectedCategoryModel by viewModel.selectedCategoryModel.collectAsState()
    val filteredQuotes by viewModel.filteredQuotesState.collectAsState()

    LaunchedEffect(initialSelectedCategory) {
        viewModel.setInitialCategory(initialSelectedCategory)
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
                selectedCategoryModel?.let { selected ->
                    ExploreCategoryChipContainer(
                        categories = categories,
                        selectedCategory = selected
                    ) { newCategory ->
                        viewModel.selectCategory(newCategory)
                    }
                }
            }

            items(filteredQuotes) { quote ->
                Log.d("ExploreScreen", "Current Category: ${quote.category}")
                val categoryModel = viewModel.getCategoryModel(quote.category)
                ExploreQuotesCard(
                    quote = quote,
                    categoryName = categoryModel.name,
                    categoryColor = categoryModel.color
                )
            }
        }
    }
}

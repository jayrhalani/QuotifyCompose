package com.jayhalani.quotifycompose.ui.screens.explore.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.jayhalani.quotifycompose.data.QuoteCategoryModel
import com.jayhalani.quotifycompose.data.QuoteModel
import com.jayhalani.quotifycompose.ui.components.RowSpacerWeight1f
import com.jayhalani.quotifycompose.ui.theme.Bold14

@Composable
fun ExploreQuotesCardHeader(quote: QuoteModel, quoteCategoryModel: QuoteCategoryModel) {
    Row {
        ExploreQuotesCardAvatar(avatar = quote.avatar, circleColor = quoteCategoryModel.color)
        RowSpacerWeight1f()
        Text(
            quoteCategoryModel.name,
            style = MaterialTheme.typography.Bold14.copy(color = quoteCategoryModel.color)
        )
    }
}
package com.jayhalani.quotifycompose.ui.screens.explore.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.jayhalani.quotifycompose.data.QuoteModel
import com.jayhalani.quotifycompose.ui.components.RowSpacerWeight1f
import com.jayhalani.quotifycompose.ui.theme.Bold14

@Composable
fun ExploreQuotesCardHeader(quote: QuoteModel, categoryName: String, categoryColor: Color) {
    Row {
        ExploreQuotesCardAvatar(avatar = quote.avatar, circleColor = categoryColor)
        RowSpacerWeight1f()
        Text(
            categoryName,
            style = MaterialTheme.typography.Bold14.copy(color = categoryColor)
        )
    }
}

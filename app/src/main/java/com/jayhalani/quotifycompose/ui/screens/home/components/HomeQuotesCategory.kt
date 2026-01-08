package com.jayhalani.quotifycompose.ui.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jayhalani.quotifycompose.data.QuoteCategoryModel
import com.jayhalani.quotifycompose.ui.theme.Medium12

@Composable
fun HomeQuotesCategory(
    modifier: Modifier = Modifier,
    quoteCategory: QuoteCategoryModel,
    onNavigateToExplore: (category: String?) -> Unit
) {
    Card(
        modifier = modifier
            .width(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable {
                onNavigateToExplore(quoteCategory.category.name)
            },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(color = quoteCategory.color.copy(alpha = 0.2f))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Surface(
                modifier = modifier.size(44.dp),
                shape = CircleShape,
                color = quoteCategory.color.copy(alpha = 0.5f)
            ) {
                Icon(
                    imageVector = quoteCategory.icon,
                    contentDescription = "Category Icon",
                    modifier = Modifier
                        .size(44.dp)
                        .padding(8.dp),
                    tint = quoteCategory.color
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = quoteCategory.name, style = MaterialTheme.typography.Medium12
            )
        }
    }
}
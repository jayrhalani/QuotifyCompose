package com.jayhalani.quotifycompose.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.jayhalani.quotifycompose.ui.theme.Bold20

@Composable
fun ExploreScreen(selectedCategory: String?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Yellow.copy(alpha = 0.5f)),
        contentAlignment = Alignment.Center
    ) {
        Text(selectedCategory ?: "All", style = MaterialTheme.typography.Bold20)
    }
}
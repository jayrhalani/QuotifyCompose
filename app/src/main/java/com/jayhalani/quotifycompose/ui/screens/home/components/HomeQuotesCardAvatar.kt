package com.jayhalani.quotifycompose.ui.screens.home.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeQuotesCardAvatar(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(32.dp)
            .clip(CircleShape), color = Color.White.copy(alpha = 0.5f)
    ) {}
}
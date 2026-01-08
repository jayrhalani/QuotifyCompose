package com.jayhalani.quotifycompose.ui.screens.explore.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jayhalani.quotifycompose.ui.theme.Bold24

@Composable
fun ExploreQuotesCardAvatar(modifier: Modifier = Modifier, avatar: String, circleColor: Color) {
    Surface(
        modifier = modifier
            .size(48.dp)
            .clip(CircleShape),
        color = circleColor.copy(alpha = 0.2f),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Text(avatar, style = MaterialTheme.typography.Bold24)
        }
    }
}
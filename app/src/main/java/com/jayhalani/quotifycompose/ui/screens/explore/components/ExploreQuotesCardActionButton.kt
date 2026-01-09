package com.jayhalani.quotifycompose.ui.screens.explore.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.jayhalani.quotifycompose.ui.theme.AppDimens

@Composable
fun ExploreQuotesCardActionButton(
    icon: ImageVector, contentDescription: String, iconTint: Color, circleColor: Color, onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .size(AppDimens.iconSizeExtraLarge)
            .clip(CircleShape)
            .clickable(onClick = onClick),
        color = circleColor,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = icon, contentDescription = contentDescription, tint = iconTint)
        }
    }
}
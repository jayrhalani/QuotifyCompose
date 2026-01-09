package com.jayhalani.quotifycompose.ui.screens.home.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.jayhalani.quotifycompose.ui.theme.AppDimens

@Composable
fun HomeQuotesCardAvatar(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(AppDimens.iconSizeLarge)
            .clip(CircleShape), color = Color.White.copy(alpha = 0.5f)
    ) {}
}
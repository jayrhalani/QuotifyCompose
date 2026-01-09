package com.jayhalani.quotifycompose.ui.screens.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jayhalani.quotifycompose.ui.theme.AppDimens
import com.jayhalani.quotifycompose.ui.theme.Medium16

@Composable
fun HomeSectionHeader(
    modifier: Modifier = Modifier, startText: String, endText: String, onNavigate: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = AppDimens.paddingMedium),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = startText,
            style = MaterialTheme.typography.Medium16,
        )
        // Spacer(modifier = Modifier.weight(1f)) -> alternate to arrangement for this scenario
        Text(
            text = endText, style = MaterialTheme.typography.Medium16, modifier = Modifier.clickable { onNavigate() })
    }
}
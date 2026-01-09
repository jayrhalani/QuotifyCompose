package com.jayhalani.quotifycompose.ui.screens.explore.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.jayhalani.quotifycompose.ui.theme.AppDimens
import com.jayhalani.quotifycompose.ui.theme.Medium14

@Composable
fun ExploreCategoryChip(
    label: String, chipColor: Color, isSelected: Boolean, onClick: () -> Unit
) {
    Surface(
        modifier = Modifier.clickable(onClick = onClick),
        shape = RoundedCornerShape(AppDimens.cornerRadiusMedium),
        border = BorderStroke(AppDimens.borderStroke, if (isSelected) Color.Transparent else Color.Black),
        color = if (isSelected) chipColor else Color.White
    ) {
        Row(
            modifier = Modifier.padding(horizontal = AppDimens.paddingMedium, vertical = AppDimens.paddingSmall),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = label,
                color = if (isSelected) Color.White else Color.Black,
                style = MaterialTheme.typography.Medium14
            )
        }
    }
}
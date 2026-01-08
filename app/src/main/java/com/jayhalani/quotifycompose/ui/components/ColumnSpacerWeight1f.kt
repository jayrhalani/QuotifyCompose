package com.jayhalani.quotifycompose.ui.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ColumnScope.ColumnSpacerWeight1f() {
    Spacer(modifier = Modifier.weight(1f))
}
package com.jayhalani.quotifycompose.ui.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jayhalani.quotifycompose.data.QuoteModel
import com.jayhalani.quotifycompose.ui.components.ColumnSpacerWeight1f
import com.jayhalani.quotifycompose.ui.components.RowSpacerWeight1f
import com.jayhalani.quotifycompose.ui.theme.Medium16
import com.jayhalani.quotifycompose.ui.theme.Normal12

@Composable
fun HomeQuotesCard(modifier: Modifier = Modifier, quoteModel: QuoteModel) {
    Card(
        modifier = modifier
            .width(200.dp)
            .height(240.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color.Blue, Color.Blue.copy(alpha = 0.4f)
                        ),
                    )
                )
                .padding(20.dp)
        ) {
            Row {
                HomeQuotesCardAvatar()
                RowSpacerWeight1f()
                Icon(
                    Icons.Default.Share, contentDescription = "ic_share", tint = Color.White
                )
                Spacer(Modifier.width(8.dp))
                Icon(
                    Icons.Default.FavoriteBorder,
                    contentDescription = "ic_favorite",
                    tint = Color.White,
                )
            }
            ColumnSpacerWeight1f()
            Text(
                text = quoteModel.text,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.Medium16.copy(
                    Color.White,
                    lineHeight = 20.sp,
                ),
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "-${quoteModel.author}", style = MaterialTheme.typography.Normal12.copy(
                    Color.White, lineHeight = 16.sp, fontStyle = FontStyle.Italic
                ), modifier = Modifier.padding(4.dp)
            )
        }
    }
}
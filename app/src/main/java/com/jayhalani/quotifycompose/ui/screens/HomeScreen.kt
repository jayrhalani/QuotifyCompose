package com.jayhalani.quotifycompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.jayhalani.quotifycompose.ui.theme.Bold16
import com.jayhalani.quotifycompose.ui.theme.Medium16
import com.jayhalani.quotifycompose.ui.theme.Normal12
import com.jayhalani.quotifycompose.ui.theme.Normal8

@Preview(showBackground = true)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(12.dp), verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                text = "Explore",
                style = MaterialTheme.typography.Bold16,
            )
            Text(
                text = "Awesome quotes from or community",
                style = MaterialTheme.typography.Normal12,
            )
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .fillMaxHeight(0.25f),
            ) {
                AsyncImage(
                    model = "https://i.pinimg.com/736x/1a/fd/3f/1afd3f3fd73871816c92cf7cdbbd449f.jpg",
                    contentDescription = "Banner",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }

        item {
            SectionHeader(
                startText = "Latest Quotes",
                endText = "View All",
                onNavigate = {
                    // TODO: Add Navigation to Latest Quotes Screen
                }
            )
        }

        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(10) {
                    QuotesCard()
                }
            }
        }

        item {
            SectionHeader(
                startText = "Categories",
                endText = "View All",
                onNavigate = {
                    // TODO: Add Navigation to Latest Quotes Screen
                }
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun QuotesCard(modifier: Modifier = Modifier) {
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
                            Color(0xFF1E40AF),
                            Color(0xFF1E40AF).copy(alpha = 0.7f)
                        ),
                    )
                )
                .padding(20.dp)
        ) {
            Row {
                CircleShapeComponent()
                SpacerWeight1f()
                Icon(
                    Icons.Default.Share,
                    contentDescription = "ic_share",
                    tint = Color.White
                )
                Spacer(Modifier.width(8.dp))
                Icon(
                    Icons.Default.FavoriteBorder,
                    contentDescription = "ic_favorite",
                    tint = Color.White,
                )
            }
            SpacerWeight1f()
            Text(
                text = "Never forget those who helped you even before you even asked.",
                style = MaterialTheme.typography.Normal12.copy(
                    Color.White,
                    lineHeight = 16.sp,
                ),
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = "-ig-glossy-minds",
                style = MaterialTheme.typography.Normal8.copy(
                    Color.White,
                    lineHeight = 16.sp,
                    fontStyle = FontStyle.Italic
                ),
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Composable
fun RowScope.SpacerWeight1f() {
    Spacer(modifier = Modifier.weight(1f))
}

@Composable
fun ColumnScope.SpacerWeight1f() {
    Spacer(modifier = Modifier.weight(1f))
}

@Composable
fun CircleShapeComponent(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(32.dp)
            .clip(CircleShape),
        color = Color.White.copy(alpha = 0.5f)
    ) {

    }
}

@Composable
fun SectionHeader(
    modifier: Modifier = Modifier,
    startText: String,
    endText: String,
    onNavigate: () -> Unit = {}
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = startText,
            style = MaterialTheme.typography.Medium16,
        )
        // Spacer(modifier = Modifier.weight(1f)) // alternate to arrangement for this scenario
        Text(
            text = endText,
            style = MaterialTheme.typography.Medium16,
            modifier = Modifier.clickable { onNavigate() }
        )
    }
}
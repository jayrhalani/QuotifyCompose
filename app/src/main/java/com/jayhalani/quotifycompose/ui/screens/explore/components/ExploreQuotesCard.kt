package com.jayhalani.quotifycompose.ui.screens.explore.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import com.jayhalani.quotifycompose.data.QuoteCategoryModel
import com.jayhalani.quotifycompose.data.QuoteModel
import com.jayhalani.quotifycompose.ui.theme.AppColors
import com.jayhalani.quotifycompose.ui.theme.AppDimens
import com.jayhalani.quotifycompose.ui.theme.AppStrings
import com.jayhalani.quotifycompose.ui.theme.Bold12
import com.jayhalani.quotifycompose.ui.theme.Bold16

@Composable
fun ExploreQuotesCard(quote: QuoteModel, quoteCategoryModel: QuoteCategoryModel) {
    var showDetails by remember { mutableStateOf(false) }
    var isFavorite by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .padding(horizontal = AppDimens.paddingSmall)
            .fillMaxWidth(),
        border = BorderStroke(AppDimens.borderStroke, color = Color.Gray),
        elevation = CardDefaults.cardElevation(defaultElevation = AppDimens.elevationSmall)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(AppDimens.cornerRadiusMedium))
                .clickable {
                    showDetails = !showDetails
                }) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White.copy(alpha = 0.2f))
                    .border(AppDimens.borderStroke, color = Color.Gray)
                    .padding(all = AppDimens.paddingMedium)
            ) {
                ExploreQuotesCardHeader(quote = quote, quoteCategoryModel = quoteCategoryModel)
                Spacer(Modifier.height(AppDimens.heightLarge))
                Text(quote.text, style = MaterialTheme.typography.Bold16)
                Spacer(Modifier.height(AppDimens.heightMedium))
                Text(
                    quote.author, style = MaterialTheme.typography.Bold12.copy(
                        fontStyle = FontStyle.Italic, color = quoteCategoryModel.color
                    )
                )
                if (showDetails) {
                    Spacer(Modifier.height(AppDimens.heightMedium))
                    HorizontalDivider(color = Color.Gray)
                    Spacer(Modifier.height(AppDimens.heightMedium))
                    Row(horizontalArrangement = Arrangement.spacedBy(AppDimens.paddingSmall)) {
                        ExploreQuotesCardActionButton(
                            icon = if (isFavorite) {
                                Icons.Default.Favorite
                            } else {
                                Icons.Default.FavoriteBorder
                            },
                            contentDescription = if (isFavorite) {
                                AppStrings.CD_FAVORITE_INACTIVE
                            } else {
                                AppStrings.CD_FAVORITE_ACTIVE
                            },
                            iconTint = AppColors.CategoryLife,
                            circleColor = AppColors.CategoryLife.copy(alpha = 0.2f),
                        ) {
                            isFavorite = !isFavorite
                        }
                        ExploreQuotesCardActionButton(
                            icon = Icons.Default.Download,
                            contentDescription = AppStrings.CD_DOWNLOAD_QUOTE,
                            iconTint = AppColors.CategoryEducation,
                            circleColor = AppColors.CategoryEducation.copy(alpha = 0.2f),
                        ) {}
                        ExploreQuotesCardActionButton(
                            icon = Icons.Default.Share,
                            contentDescription = AppStrings.CD_SHARE_QUOTE,
                            iconTint = AppColors.CategoryHumor,
                            circleColor = AppColors.CategoryHumor.copy(alpha = 0.2f),
                        ) {}
                    }
                }
            }
        }

    }
}
package com.jayhalani.quotifycompose.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEmotions
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Whatshot
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.jayhalani.quotifycompose.ui.theme.AppColors
import com.jayhalani.quotifycompose.ui.theme.AppStrings

data class QuoteCategoryModel(
    val id: Int,
    val name: String,
    val category: QuoteCategory,
    val icon: ImageVector,
    val color: Color,
    val contentDescription: String
)

object QuoteCategoryData {

    fun getCategories() = listOf(
        QuoteCategoryModel(
            id = 1,
            name = AppStrings.CATEGORY_LIFE,
            category = QuoteCategory.LIFE,
            icon = Icons.Default.Favorite,
            color = AppColors.CategoryLife,
            contentDescription = AppStrings.CD_CAT_LIFE
        ),
        QuoteCategoryModel(
            id = 2,
            name = AppStrings.CATEGORY_SUCCESS,
            category = QuoteCategory.SUCCESS,
            icon = Icons.Default.Star,
            color = AppColors.CategorySuccess,
            contentDescription = AppStrings.CD_CAT_SUCCESS
        ),
        QuoteCategoryModel(
            id = 3,
            name = AppStrings.CATEGORY_MOTIVATION,
            category = QuoteCategory.MOTIVATION,
            icon = Icons.Default.Lightbulb,
            color = AppColors.CategoryMotivation,
            contentDescription = AppStrings.CD_CAT_MOTIVATION
        ),
        QuoteCategoryModel(
            id = 4,
            name = AppStrings.CATEGORY_LOVE,
            category = QuoteCategory.LOVE,
            icon = Icons.Default.Favorite,
            color = AppColors.CategoryLove,
            contentDescription = AppStrings.CD_CAT_LOVE
        ),
        QuoteCategoryModel(
            id = 5,
            name = AppStrings.CATEGORY_WISDOM,
            category = QuoteCategory.WISDOM,
            icon = Icons.Default.MenuBook,
            color = AppColors.CategoryWisdom,
            contentDescription = AppStrings.CD_CAT_WISDOM
        ),
        QuoteCategoryModel(
            id = 6,
            name = AppStrings.CATEGORY_HUMOR,
            category = QuoteCategory.HUMOR,
            icon = Icons.Default.EmojiEmotions,
            color = AppColors.CategoryHumor,
            contentDescription = AppStrings.CD_CAT_HUMOR
        ),
        QuoteCategoryModel(
            id = 7,
            name = AppStrings.CATEGORY_COURAGE,
            category = QuoteCategory.COURAGE,
            icon = Icons.Default.Whatshot,
            color = AppColors.CategoryCourage,
            contentDescription = AppStrings.CD_CAT_COURAGE
        ),
        QuoteCategoryModel(
            id = 8,
            name = AppStrings.CATEGORY_LEADERSHIP,
            category = QuoteCategory.LEADERSHIP,
            icon = Icons.Default.Groups,
            color = AppColors.CategoryLeadership,
            contentDescription = AppStrings.CD_CAT_LEADERSHIP
        ),
        QuoteCategoryModel(
            id = 9,
            name = AppStrings.CATEGORY_EDUCATION,
            category = QuoteCategory.EDUCATION,
            icon = Icons.Default.School,
            color = AppColors.CategoryEducation,
            contentDescription = AppStrings.CD_CAT_EDUCATION
        ),
        QuoteCategoryModel(
            id = 10,
            name = AppStrings.CATEGORY_PHILOSOPHY,
            category = QuoteCategory.PHILOSOPHY,
            icon = Icons.Default.Psychology,
            color = AppColors.CategoryPhilosophy,
            contentDescription = AppStrings.CD_CAT_PHILOSOPHY
        )
    )
}
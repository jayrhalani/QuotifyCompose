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

data class QuoteCategoryModel(
    val id: Int,
    val name: String,
    val category: QuoteCategory,
    val icon: ImageVector,
    val color: Color
)

object QuoteCategoryData {

    fun getCategories() = listOf(
        QuoteCategoryModel(
            id = 1,
            name = "Life",
            category = QuoteCategory.LIFE,
            icon = Icons.Default.Favorite,
            color = Color(0xFFE91E63) // Pink
        ),
        QuoteCategoryModel(
            id = 2,
            name = "Success",
            category = QuoteCategory.SUCCESS,
            icon = Icons.Default.Star,
            color = Color(0xFFFFC107) // Amber
        ),
        QuoteCategoryModel(
            id = 3,
            name = "Motivation",
            category = QuoteCategory.MOTIVATION,
            icon = Icons.Default.Lightbulb,
            color = Color(0xFFFF9800) // Orange
        ),
        QuoteCategoryModel(
            id = 4,
            name = "Love",
            category = QuoteCategory.LOVE,
            icon = Icons.Default.Favorite,
            color = Color(0xFFD32F2F) // Deep Red
        ),
        QuoteCategoryModel(
            id = 5,
            name = "Wisdom",
            category = QuoteCategory.WISDOM,
            icon = Icons.Default.MenuBook,
            color = Color(0xFF3F51B5) // Indigo
        ),
        QuoteCategoryModel(
            id = 6,
            name = "Humor",
            category = QuoteCategory.HUMOR,
            icon = Icons.Default.EmojiEmotions,
            color = Color(0xFF4FC3F7) // Sky Blue
        ),
        QuoteCategoryModel(
            id = 7,
            name = "Courage",
            category = QuoteCategory.COURAGE,
            icon = Icons.Default.Whatshot,
            color = Color(0xFFF44336) // Hot Red
        ),
        QuoteCategoryModel(
            id = 8,
            name = "Leadership",
            category = QuoteCategory.LEADERSHIP,
            icon = Icons.Default.Groups,
            color = Color(0xFF009688) // Teal
        ),
        QuoteCategoryModel(
            id = 9,
            name = "Education",
            category = QuoteCategory.EDUCATION,
            icon = Icons.Default.School,
            color = Color(0xFF4CAF50) // Green
        ),
        QuoteCategoryModel(
            id = 10,
            name = "Philosophy",
            category = QuoteCategory.PHILOSOPHY,
            icon = Icons.Default.Psychology,
            color = Color(0xFF9C27B0) // Purple
        )
    )
}

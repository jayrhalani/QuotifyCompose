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
import com.jayhalani.quotifycompose.ui.theme.colorAmber
import com.jayhalani.quotifycompose.ui.theme.colorDeepRed
import com.jayhalani.quotifycompose.ui.theme.colorGreen
import com.jayhalani.quotifycompose.ui.theme.colorHotRed
import com.jayhalani.quotifycompose.ui.theme.colorIndigo
import com.jayhalani.quotifycompose.ui.theme.colorOrange
import com.jayhalani.quotifycompose.ui.theme.colorPink
import com.jayhalani.quotifycompose.ui.theme.colorPurple
import com.jayhalani.quotifycompose.ui.theme.colorSkyBlue
import com.jayhalani.quotifycompose.ui.theme.colorTeal

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
            color = colorPink
        ),
        QuoteCategoryModel(
            id = 2,
            name = "Success",
            category = QuoteCategory.SUCCESS,
            icon = Icons.Default.Star,
            color = colorAmber
        ),
        QuoteCategoryModel(
            id = 3,
            name = "Motivation",
            category = QuoteCategory.MOTIVATION,
            icon = Icons.Default.Lightbulb,
            color = colorOrange
        ),
        QuoteCategoryModel(
            id = 4,
            name = "Love",
            category = QuoteCategory.LOVE,
            icon = Icons.Default.Favorite,
            color = colorDeepRed
        ),
        QuoteCategoryModel(
            id = 5,
            name = "Wisdom",
            category = QuoteCategory.WISDOM,
            icon = Icons.Default.MenuBook,
            color = colorIndigo
        ),
        QuoteCategoryModel(
            id = 6,
            name = "Humor",
            category = QuoteCategory.HUMOR,
            icon = Icons.Default.EmojiEmotions,
            color = colorSkyBlue
        ),
        QuoteCategoryModel(
            id = 7,
            name = "Courage",
            category = QuoteCategory.COURAGE,
            icon = Icons.Default.Whatshot,
            color = colorHotRed
        ),
        QuoteCategoryModel(
            id = 8,
            name = "Leadership",
            category = QuoteCategory.LEADERSHIP,
            icon = Icons.Default.Groups,
            color = colorTeal
        ),
        QuoteCategoryModel(
            id = 9,
            name = "Education",
            category = QuoteCategory.EDUCATION,
            icon = Icons.Default.School,
            color = colorGreen
        ),
        QuoteCategoryModel(
            id = 10,
            name = "Philosophy",
            category = QuoteCategory.PHILOSOPHY,
            icon = Icons.Default.Psychology,
            color = colorPurple
        )
    )
}

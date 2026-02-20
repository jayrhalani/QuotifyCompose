package com.jayhalani.quotifycompose.ui.screens.quote_of_the_day

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.jayhalani.quotifycompose.data.QuoteModel
import com.jayhalani.quotifycompose.data.QuoteRepository
import java.time.LocalDate

class QuoteOfDayViewModel : ViewModel() {
    private val repository = QuoteRepository()
    private val allQuotes = repository.getQuotes()

    fun getQuoteOfTheDay(): QuoteModel {
        val today = LocalDate.now()
        val seed = today.toEpochDay()
        return allQuotes[(seed % allQuotes.size).toInt()]
    }

    val backgroundColors = listOf(
        listOf(Color(0xFF1E3C72), Color(0xFF2A5298)), // Ocean Blue
        listOf(Color(0xFFff7e5f), Color(0xFFfeb47b)), // Sunset Glow
        listOf(Color(0xFF00c6ff), Color(0xFF0072ff)), // Sky Wave
        listOf(Color(0xFFf857a6), Color(0xFFff5858)), // Rose Fire
        listOf(Color(0xFF8E2DE2), Color(0xFF4A00E0)), // Violet Storm
        listOf(Color(0xFF00B4DB), Color(0xFF0083B0)), // Aqua Depth
        listOf(Color(0xFFF3904F), Color(0xFF3B4371)), // Ember Night
        listOf(Color(0xFF11998e), Color(0xFF38ef7d)), // Mint Fresh
        listOf(Color(0xFF0F2027), Color(0xFF203A43)), // Deep teal night
        listOf(Color(0xFF232526), Color(0xFF414345)), // Dark graphite
        listOf(Color(0xFF2C3E50), Color(0xFF4CA1AF)), // Steel blue
        listOf(Color(0xFF134E5E), Color(0xFF71B280)), // Emerald sea
        listOf(Color(0xFF3A1C71), Color(0xFFD76D77)), // Royal purple
        listOf(Color(0xFF42275A), Color(0xFF734B6D)), // Plum fade
        listOf(Color(0xFF614385), Color(0xFF516395)), // Soft indigo
        listOf(Color(0xFF16222A), Color(0xFF3A6073)), // Midnight blue
        listOf(Color(0xFFFF512F), Color(0xFFDD2476)), // Sunset pink
        listOf(Color(0xFFFF5F6D), Color(0xFFFFC371)), // Peach glow
        listOf(Color(0xFF1F4037), Color(0xFF99F2C8)), // Mint forest
        listOf(Color(0xFF283048), Color(0xFF859398))  // Calm slate
    )

    val backgroundBrushes: List<Brush> = backgroundColors.map { Brush.verticalGradient(it) }

    fun getRandomBackgroundBrush(): Brush {
        return Brush.verticalGradient(backgroundColors.random())
    }
}

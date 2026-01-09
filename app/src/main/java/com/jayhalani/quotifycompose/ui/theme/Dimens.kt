package com.jayhalani.quotifycompose.ui.theme

import androidx.compose.ui.unit.dp

// ---------------------------------------------------------
// Private Primitives (The "Scale")
// ---------------------------------------------------------
private val dp1 = 1.dp
private val dp4 = 4.dp
private val dp8 = 8.dp
private val dp12 = 12.dp
private val dp16 = 16.dp
private val dp24 = 24.dp
private val dp32 = 32.dp
private val dp48 = 48.dp
private val dp100 = 100.dp
private val dp200 = 200.dp
private val dp240 = 240.dp
private val dp280 = 280.dp

// ---------------------------------------------------------
// Public Semantic Object
// ---------------------------------------------------------
object AppDimens {

    // ----------------------------------------
    // Padding & Spacing (Margins)
    // ----------------------------------------
    val paddingExtraSmall = dp4
    val paddingSmall = dp8
    val paddingMedium = dp16
    // val paddingLarge = dp24
    // val paddingExtraLarge = dp32

    // ----------------------------------------
    // Icon Sizes
    // ----------------------------------------
    val iconSizeLarge = dp32
    val iconSizeExtraLarge = dp48

    // ----------------------------------------
    // Corner Radius (For Shapes)
    // ----------------------------------------
    val borderStroke = dp1
    val cornerRadiusMedium = dp16

    // ----------------------------------------
    // Element Heights
    // ----------------------------------------
    val heightBanner = dp280
    val heightSmall = dp8
    val heightMedium = dp16
    val heightLarge = dp24

    // ----------------------------------------
    // Element Widths
    // ----------------------------------------
    val widthExtraSmall = dp4
    val widthSmall = dp8

    // ----------------------------------------
    // Card Elevation
    // ----------------------------------------
    val elevationExtraSmall = dp4
    val elevationSmall = dp8

    // ----------------------------------------
    // Specific Component Sizes (Optional)
    // ----------------------------------------
    val homeQuoteCategoriesWidth = dp100
    val homeBannerCounterSize = dp12
    val widthHomeQuotesCard = dp200
    val heightHomeQuotesCard = dp240
}
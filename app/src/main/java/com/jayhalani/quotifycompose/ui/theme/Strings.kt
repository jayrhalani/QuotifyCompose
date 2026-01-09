package com.jayhalani.quotifycompose.ui.theme

object AppStrings {
    // ----------------------------------------
    // General App Strings
    // ----------------------------------------
    private const val APP_NAME = "Quotify"

    // ----------------------------------------
    // Navigation Routes
    // ----------------------------------------
    const val ROUTE_HOME = "home"
    const val ROUTE_EXPLORE = "explore"
    const val ROUTE_SAVED = "saved"
    const val ROUTE_CATEGORY_QUOTES = "category_quotes"

    // ----------------------------------------
    // Navigation Parameters
    // ----------------------------------------
    const val PARAM_CATEGORY = "category"
    const val PARAM_SHOW_BACK_BUTTON = "showBackButton"

    // ----------------------------------------
    // Navigation Templates
    // ----------------------------------------
    const val ROUTE_CATEGORY_QUOTES_WITH_PARAMS = "$ROUTE_CATEGORY_QUOTES/{$PARAM_CATEGORY}"

    // ----------------------------------------
    // Screen Titles
    // ----------------------------------------
    const val TITLE_HOME = APP_NAME
    const val TITLE_SAVED = "Your Favorites"
    const val TITLE_EXPLORE = "Explore"

    // ----------------------------------------
    // Home Screen Specific
    // ----------------------------------------
    const val DESCRIPTION_HOME = "Awesome quotes from our community"
    const val SEC_HEADER_LATEST_QUOTES_HOME = "Latest Quotes"
    const val SEC_HEADER_CATEGORIES_HOME = "Categories"
    const val SEC_HEADER_TRENDING_QUOTES_HOME = "Trending Quotes"
    const val END_TEXT_VIEW_ALL_HOME = "View All"

    // ----------------------------------------
    // Content Descriptions (Accessibility)
    // ----------------------------------------
    const val CD_FAVORITE_ACTIVE = "Remove from favorites"
    const val CD_FAVORITE_INACTIVE = "Add to favorites"
    const val CD_SHARE_QUOTE = "Share this quote with others"
    const val CD_DOWNLOAD_QUOTE = "Save this quote image to your device"
    const val CD_NAV_BACK = "Navigate back"
    const val CD_HOME_BANNER = "Featured quote image"


    // ----------------------------------------
    // Category Labels
    // ----------------------------------------
    const val CATEGORY_ALL = "All"
    const val CATEGORY_LIFE = "Life"
    const val CATEGORY_SUCCESS = "Success"
    const val CATEGORY_MOTIVATION = "Motivation"
    const val CATEGORY_LOVE = "Love"
    const val CATEGORY_WISDOM = "Wisdom"
    const val CATEGORY_HUMOR = "Humor"
    const val CATEGORY_COURAGE = "Courage"
    const val CATEGORY_LEADERSHIP = "Leadership"
    const val CATEGORY_EDUCATION = "Education"
    const val CATEGORY_PHILOSOPHY = "Philosophy"

    // ----------------------------------------
    // Category Content Descriptions
    // ----------------------------------------
    const val CD_CAT_ALL = "All Quotes"
    const val CD_CAT_LIFE = "Quotes about life experiences"
    const val CD_CAT_SUCCESS = "Quotes about achieving goals and success"
    const val CD_CAT_MOTIVATION = "Inspirational and motivational quotes"
    const val CD_CAT_LOVE = "Quotes about love and relationships"
    const val CD_CAT_WISDOM = "Words of wisdom and knowledge"
    const val CD_CAT_HUMOR = "Funny and humorous quotes"
    const val CD_CAT_COURAGE = "Quotes about bravery and courage"
    const val CD_CAT_LEADERSHIP = "Quotes on leading and influence"
    const val CD_CAT_EDUCATION = "Quotes about learning and education"
    const val CD_CAT_PHILOSOPHY = "Deep philosophical thoughts"

    // ----------------------------------------
    // Empty State / Placeholder Strings
    // ----------------------------------------
    const val EMPTY_SAVED_MESSAGE = "You haven't saved any quotes yet."
    const val SEARCH_PLACEHOLDER = "Search quotes or authors..."
}
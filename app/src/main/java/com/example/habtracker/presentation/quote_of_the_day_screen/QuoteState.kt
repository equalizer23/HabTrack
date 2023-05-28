package com.example.habtracker.presentation.quote_of_the_day_screen

import com.example.habtracker.domain.models.MainQuote

data class QuoteState(
    val isLoading: Boolean = false,
    val quote: MainQuote? = null,
    val error: String = ""
)

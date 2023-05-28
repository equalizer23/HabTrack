package com.example.habtracker.domain.repositories

import com.example.habtracker.data.dto.QuoteDTO

interface Repository {
    suspend fun getQuoteOfTheDay() : QuoteDTO
}
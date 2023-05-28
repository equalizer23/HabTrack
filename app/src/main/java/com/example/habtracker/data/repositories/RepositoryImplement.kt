package com.example.habtracker.data.repositories

import com.example.habtracker.data.dto.QuoteDTO
import com.example.habtracker.data.remote.QuoteApi
import com.example.habtracker.domain.repositories.Repository
import javax.inject.Inject

class RepositoryImplement  @Inject constructor(
    private val api: QuoteApi
) : Repository{

    override suspend fun getQuoteOfTheDay(): QuoteDTO {
        return api.getQOD()
    }
}
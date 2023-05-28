package com.example.habtracker.data.remote

import com.example.habtracker.data.dto.QuoteDTO
import retrofit2.http.GET

interface QuoteApi {
    @GET("qod/")
    suspend fun getQOD() : QuoteDTO
}
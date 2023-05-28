package com.example.habtracker.domain.use_cases

import com.example.habtracker.common.Resource
import com.example.habtracker.data.dto.toQuote
import com.example.habtracker.domain.models.MainQuote
import com.example.habtracker.domain.repositories.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetQuoteOfTheDay @Inject constructor(
    private val repository: Repository
){
    operator fun invoke() : Flow<Resource<MainQuote>> = flow {
        try {
            emit(Resource.Loading())
            val quote = repository.getQuoteOfTheDay().contents.quotes[0].toQuote()
            emit(Resource.Success(quote))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    e.localizedMessage ?: "Couldn't reach server. Check your internet connection"
                )
            )
        }
    }


}
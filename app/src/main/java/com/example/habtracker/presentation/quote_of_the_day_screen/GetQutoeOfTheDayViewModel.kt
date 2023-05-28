package com.example.habtracker.presentation.quote_of_the_day_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habtracker.common.Resource
import com.example.habtracker.data.dto.Quote
import com.example.habtracker.domain.use_cases.GetQuoteOfTheDay
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GetQuoteOfTheDayViewModel @Inject constructor(
    private val getQuote: GetQuoteOfTheDay
) : ViewModel(){

    private val _state = mutableStateOf(QuoteState())
    val state: State<QuoteState> = _state

    init {
        getQuoteOfTheDay()
    }

    private fun getQuoteOfTheDay(){
        getQuote().onEach {
            result ->
            when(result){
                is Resource.Success ->{
                    _state.value = QuoteState(quote = result.data)
                }
                is Resource.Error ->{
                    _state.value = QuoteState(error = result.message?: "An unexpected error occurred")
                }
                is Resource.Loading ->{
                    _state.value = QuoteState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
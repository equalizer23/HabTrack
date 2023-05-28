package com.example.habtracker.data.dto

import com.example.habtracker.domain.models.MainQuote

data class Quote(
    val author: String,
    val background: String,
    val category: String,
    val date: String,
    val id: String,
    val length: String,
    val quote: String,
    val tags: List<String>,
    val title: String
)

fun Quote.toQuote() : MainQuote {
    return MainQuote(
        author = author,
        title =  title,
        quote = quote,
        id = id,
        date = date
    )
}
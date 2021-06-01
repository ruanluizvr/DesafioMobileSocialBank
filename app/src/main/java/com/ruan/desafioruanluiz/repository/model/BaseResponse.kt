package com.ruan.desafioruanluiz.repository.model

data class BaseResponse (
    val Search: List<Filme>,
    val totalResults: Int,
    val Response: String
)
package br.com.fakelibrary.domain

data class Status(
    val code: Int,
    val `data`: List<Data>,
    val status: String,
    val total: Int
)
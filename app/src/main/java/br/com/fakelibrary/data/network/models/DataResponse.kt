package br.com.fakelibrary.data.network.models

import com.google.gson.annotations.SerializedName

/**
 * @author RubioAlves
 * Created 02/12/2021 at 18:37
 */
data class DataResponse(
    @SerializedName("author")
    val author: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("genre")
    val genre: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("isbn")
    val isbn: String,
    @SerializedName("published")
    val published: String,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("title")
    val title: String
)

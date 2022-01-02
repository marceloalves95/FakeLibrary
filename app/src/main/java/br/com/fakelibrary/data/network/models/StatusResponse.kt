package br.com.fakelibrary.data.network.models

import br.com.fakelibrary.domain.Data
import com.google.gson.annotations.SerializedName

/**
 * @author RubioAlves
 * Created 02/12/2021 at 18:42
 */
data class StatusResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("`data`")
    val `data`: List<Data>,
    @SerializedName("status")
    val status: String,
    @SerializedName("total")
    val total: Int
)

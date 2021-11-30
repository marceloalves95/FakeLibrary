package br.com.fakelibrary.data.network.api

import br.com.fakelibrary.domain.Status
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author RubioAlves
 * Created 27/11/2021 at 17:20
 */
interface FakeBookApi {

    @GET("/api/v1/books")
    suspend fun getFakeBook(@Query("_quantity") _quantity:Int):Response<Status>

}
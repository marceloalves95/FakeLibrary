package br.com.fakelibrary.data.repository

import br.com.fakelibrary.data.api.FakeBookApi

/**
 * @author RubioAlves
 * Created 27/11/2021 at 17:46
 */
class FakeBookRepository(private val fakeBookApi: FakeBookApi) {
    suspend fun getFakeBook(quantity:Int) = fakeBookApi.getFakeBook(quantity)
}
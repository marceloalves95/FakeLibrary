package br.com.fakelibrary.data.network.repository

import br.com.fakelibrary.data.network.api.FakeBookApi

/**
 * @author RubioAlves
 * Created 27/11/2021 at 17:46
 */
class FakeBookRepository(private val fakeBookApi: FakeBookApi) {
    suspend fun getFakeBook() = fakeBookApi.getFakeBook()
}
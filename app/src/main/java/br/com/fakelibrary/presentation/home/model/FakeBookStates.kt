package br.com.fakelibrary.presentation.home.model

import br.com.fakelibrary.domain.Status

sealed class FakeBookStates {
    class Sucess(val response: Status?) : FakeBookStates()
    class Error(val message: String) : FakeBookStates()
}
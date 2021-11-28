package br.com.fakelibrary.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fakelibrary.data.repository.FakeBookRepository
import br.com.fakelibrary.domain.Status
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * @author RubioAlves
 * Created 27/11/2021 at 17:51
 */
class FakeLibraryViewModel(private val fakeBookRepository: FakeBookRepository):ViewModel() {

    private val _state = MutableStateFlow<FakeBookStates>(FakeBookStates.Empty)
    val state: StateFlow<FakeBookStates> = _state

    private fun emit(value: FakeBookStates) {
        _state.value = value
    }

    fun getQuantityFakeBook(quantity:Int){

        viewModelScope.launch {
            try {
                delay(1000)
                val response = fakeBookRepository.getFakeBook(quantity)
                with(response) {
                    if (isSuccessful) {
                        emit(FakeBookStates.Sucess(body()))
                    } else {
                        emit(FakeBookStates.Error("Erro: ${code()}"))
                    }
                }
            } catch (exception: Exception) {
                emit(FakeBookStates.Error("Sem Internet"))
            }
        }
    }

    sealed class FakeBookStates {
        class Sucess(val response: Status?) : FakeBookStates()
        class Error(val message: String) : FakeBookStates()
        object Empty : FakeBookStates()
    }
}
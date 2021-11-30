package br.com.fakelibrary.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fakelibrary.data.network.repository.FakeBookRepository
import br.com.fakelibrary.presentation.home.model.FakeBookStates
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author RubioAlves
 * Created 27/11/2021 at 17:51
 */
class FakeLibraryViewModel(private val fakeBookRepository: FakeBookRepository):ViewModel() {

    private val _state = MutableLiveData<FakeBookStates>()
    val state:LiveData<FakeBookStates> get() = _state

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
}
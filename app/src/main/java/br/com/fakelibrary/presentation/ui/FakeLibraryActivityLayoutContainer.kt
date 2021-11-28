package br.com.fakelibrary.presentation.ui

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.fakelibrary.core.extensions.toast
import br.com.fakelibrary.databinding.ActivityMainBinding
import kotlinx.android.extensions.LayoutContainer
import kotlinx.coroutines.flow.collect

/**
 * @author RubioAlves
 * Created 27/11/2021 at 08:53
 */
class FakeLibraryActivityLayoutContainer(
    override val containerView: View,
    private val binding: ActivityMainBinding,
    private val viewModel: FakeLibraryViewModel,
    private var fakeBookAdapter: FakeBookAdapter):LayoutContainer{

    fun initLayout() = with(binding){

        with(rvFakeBooks){
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = fakeBookAdapter
            setHasFixedSize(true)
        }

    }
    suspend fun initViewModel(){
        viewModel.getQuantityFakeBook(1)
        viewModel.state.collect { states->
            with(states){
                when(this){
                    FakeLibraryViewModel.FakeBookStates.Empty -> {}
                    is FakeLibraryViewModel.FakeBookStates.Error -> {
                        message.toast(containerView.context)
                    }
                    is FakeLibraryViewModel.FakeBookStates.Sucess -> {
                        response?.let { datas->
                            fakeBookAdapter = FakeBookAdapter(datas.data)
                            binding.rvFakeBooks.adapter = fakeBookAdapter
                        }
                    }
                }
            }

        }
    }
}
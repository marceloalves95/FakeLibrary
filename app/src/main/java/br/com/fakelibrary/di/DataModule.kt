package br.com.fakelibrary.di

import br.com.fakelibrary.data.repository.FakeBookRepository
import br.com.fakelibrary.presentation.ui.FakeLibraryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * @author RubioAlves
 * Created 27/11/2021 at 18:14
 */
object DataModule {
    fun load(){
        loadKoinModules(appModule())
    }
    private fun appModule(): Module {
        return module {
            single {
                FakeBookRepository(get())
            }
            viewModel {
                FakeLibraryViewModel(get())
            }
        }
    }
}
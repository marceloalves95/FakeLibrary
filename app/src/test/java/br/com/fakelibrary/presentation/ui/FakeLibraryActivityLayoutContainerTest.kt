package br.com.fakelibrary.presentation.ui

import br.com.fakelibrary.presentation.home.FakeLibraryViewModel
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/**
 * @author RubioAlves
 * Created 29/11/2021 at 06:56
 */
class FakeLibraryActivityLayoutContainerTest{

    @RelaxedMockK
    lateinit var fakeLibraryViewModel: FakeLibraryViewModel

    @Before
    fun setup(){
        MockKAnnotations.init(this)
    }

    @Test
    fun `should A when B`() = runBlocking {

    }

}
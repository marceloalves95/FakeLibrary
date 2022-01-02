package br.com.fakelibrary.domain

import io.mockk.MockKAnnotations
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * @author RubioAlves
 * Created 01/12/2021 at 22:21
 */
class DataTest{

    lateinit var data: Data

    @Before
    fun setup(){
        MockKAnnotations.init(this)
        data = dummyData
    }

    @Test
    fun `should A when B`() = runBlocking {
        assertEquals(data.title, "Dodo solemnly.")
    }
}
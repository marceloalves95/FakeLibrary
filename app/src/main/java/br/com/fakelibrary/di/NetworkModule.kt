package br.com.fakelibrary.di

import br.com.fakelibrary.data.api.FakeBookApi
import br.com.fakelibrary.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author RubioAlves
 * Created 27/11/2021 at 15:38
 */
object NetworkModule {
    fun load(){
        loadKoinModules(networkModule())
    }
    private fun networkModule():Module{
        return module {
            single {
                getService()
            }
        }
    }

    private fun criarHttpClient():OkHttpClient{

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addNetworkInterceptor(httpLoggingInterceptor)
            .connectTimeout(1, TimeUnit.SECONDS)
            .readTimeout(40,TimeUnit.SECONDS)
            .writeTimeout(40,TimeUnit.SECONDS)
            .build()
    }

    private fun getService(): FakeBookApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(criarHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FakeBookApi::class.java)

    }

}
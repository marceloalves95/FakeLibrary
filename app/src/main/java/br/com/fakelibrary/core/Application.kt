package br.com.fakelibrary.core

import android.app.Application
import br.com.fakelibrary.di.DataModule
import br.com.fakelibrary.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * @author RubioAlves
 * Created 27/11/2021 at 15:36
 */
class Application:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@Application)
        }
        DataModule.load()
        NetworkModule.load()
    }
}
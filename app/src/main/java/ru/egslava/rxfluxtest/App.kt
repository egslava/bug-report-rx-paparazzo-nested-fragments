package ru.egslava.rxfluxtest

import android.app.Application
import com.fuck_boilerplate.rx_paparazzo.RxPaparazzo

/**
 * Created by egslava on 05/05/16.
 */
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        RxPaparazzo.register(this)
    }
}
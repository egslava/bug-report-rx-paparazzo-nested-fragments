package ru.egslava.rxfluxtest

import com.fuck_boilerplate.rx_paparazzo.RxPaparazzo
import com.jakewharton.rxbinding.view.clicks
import com.trello.navi.Event.CREATE
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity() {
    val a = addListener(CREATE){
        setContentView( R.layout.activity_main)

        supportFragmentManager
                .beginTransaction()
                .add(R.id.main_fragment, MainFragment())
                .commit()

        callGallery(image_from_galery)
    }
}

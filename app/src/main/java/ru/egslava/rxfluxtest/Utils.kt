package ru.egslava.rxfluxtest

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.util.Log
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.LENGTH_SHORT
import com.fuck_boilerplate.rx_paparazzo.RxPaparazzo
import com.jakewharton.rxbinding.view.clicks
import com.trello.navi.component.support.NaviAppCompatActivity
import com.trello.navi.component.support.NaviAppCompatActivity.*
import com.trello.navi.component.support.NaviFragment
import com.trello.rxlifecycle.ActivityEvent
import com.trello.rxlifecycle.FragmentEvent
import com.trello.rxlifecycle.kotlin.bindToLifecycle
import com.trello.rxlifecycle.kotlin.bindUntilEvent
import com.trello.rxlifecycle.navi.NaviLifecycle
import rx.Observable

/**
 * Created by egslava on 05/05/16.
 */

open class BaseActivity: NaviAppCompatActivity() {
    val naviProvider = NaviLifecycle.createActivityLifecycleProvider(this)
}

open class BaseFragment: NaviFragment() {
    val naviProvider = NaviLifecycle.createFragmentLifecycleProvider(this)
}

fun<T> Observable<T>.bindUntilEvent(activity: BaseActivity, event: ActivityEvent) = bindUntilEvent(activity.naviProvider, event)
fun<T> Observable<T>.bindUntilEvent(fragment: BaseFragment, event: FragmentEvent) = bindUntilEvent(fragment.naviProvider, event)

fun<T> Observable<T>.bindToLifecycle(activity: BaseActivity) = bindToLifecycle(activity.naviProvider)
fun<T> Observable<T>.bindToLifecycle(fragment: BaseFragment) = bindToLifecycle(fragment.naviProvider)



fun Context.log(message: String) {
    Toast.makeText(this, message, LENGTH_SHORT).show()
    Log.d("LOG", message)
}

fun BaseFragment.log(message: String) {
    Toast.makeText(context, message, LENGTH_SHORT).show()
    Log.d("LOG", message)
}

fun BaseActivity.callGallery(view: View){
    view.clicks().bindToLifecycle(this).subscribe {
        RxPaparazzo.takeImage(this)
        .usingGallery()
        .subscribe { response ->
            log("${response.targetUI()}")
            if (response.resultCode() == RESULT_OK) {
                log("${response.data()}")
            }
        }
    }
}

fun BaseFragment.callGallery(view: View){
    view.clicks().bindToLifecycle(this).subscribe {
        RxPaparazzo.takeImage(this)
        .usingGallery()
        .subscribe { response ->
            log("${response.targetUI()}")
            if (response.resultCode() == RESULT_OK) {
                log("${response.data()}")
            }
        }
    }
}

class StaticPagerAdapter(val context: Context, fm: FragmentManager, val titlesRes: Int, vararg val fragments: Fragment) : FragmentPagerAdapter(fm) {

    val titles by lazy { context.resources.getStringArray(titlesRes) }
    override fun getItem(position: Int) = fragments[position]
    override fun getCount() = fragments.size
    override fun getPageTitle(position: Int) = titles[position]
}
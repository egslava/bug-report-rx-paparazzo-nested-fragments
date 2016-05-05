package ru.egslava.rxfluxtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trello.navi.component.support.NaviDialogFragment
import kotlinx.android.synthetic.main.fragment_nested.*

/**
 * Created by egslava on 05/05/16.
 */

class NestedFragment: BaseFragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):View {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_nested, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callGallery(image_from_galery)
    }
}

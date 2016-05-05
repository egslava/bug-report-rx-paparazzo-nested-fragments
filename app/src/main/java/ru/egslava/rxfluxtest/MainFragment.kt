package ru.egslava.rxfluxtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trello.navi.component.support.NaviDialogFragment
import com.trello.navi.component.support.NaviFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by egslava on 05/05/16.
 */

class MainFragment: BaseFragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):View {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        childFragmentManager
                .beginTransaction()
                .add(R.id.nested_fragment, NestedFragment())
                .commit()

        callGallery(image_from_galery)
    }

}

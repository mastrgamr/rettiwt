package net.mastrgamr.rettiwt.viewmodels

import android.databinding.ObservableField


/**
 * Project: rettiwt
 * Written by: mastrgamr
 * Date: 6/3/17
 */

class TimelineItemViewModel {

    private val TAG = javaClass.simpleName

    var tweet = ObservableField<String>()
    var user  = ObservableField<String>()
}

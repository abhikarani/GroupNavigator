package com.yashkasera.groupnavigator.util

import android.view.View

/**
 * @author yashkasera
 * Created 21/04/22 at 12:57 AM
 */
interface ItemClickListener<T> {
    fun onItemClick(v: View? = null, item: T)
}
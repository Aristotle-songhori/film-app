package com.aristotele.film.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView


/**
 * اکستنشن چیست؟
 * ببینید میایم یک سری فانکشن تعریف میکنیم که کاربردی هستن و همه جای برنامه استفاده میشن
 * مثلا فعال بودن یا غیر فعال بودن یک ویو رو اینجا داریم
 * و به صورت زیر تعریف میشن
 * و در همه جای برنامه ازش استفاده خواهسم کرد
 *
 */


/**
 * اکستنشن فانکشنی مخصوص هر نوع ویویی
 */
fun View.showInvisible(isShown: Boolean) {
    if (isShown) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.INVISIBLE
    }
}

/**
 * اکستنشن فانکشن مخصوص ریسایکر ویو ها
 */
fun RecyclerView.initRecycler(layoutManager: RecyclerView.LayoutManager, adapter: RecyclerView.Adapter<*>) {
    this.layoutManager = layoutManager
    this.adapter = adapter
}


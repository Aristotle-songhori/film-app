package com.aristotele.film.utils

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


/**
 * همیشه و همیشه برای پیاده سازی هیلت دجر باید این رو بسازیم
 * و توی مانیفست هم یه خط اضافه کنیم در تگ application
 * <application
 *android:name=".utils.MyApp"
 **/
@HiltAndroidApp
class MyApp : Application ()
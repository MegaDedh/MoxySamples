package ru.asshands.softwire.moxysample_1

import android.util.Log

class Logger {

    fun printErrorLog(message: String) {
        Log.e(MOXY_TAG, message)
    }

    fun printLog(message: String) {
        Log.d(MOXY_TAG, message)
    }

    companion object {
        const val MOXY_TAG = "MoxyDebug"
    }
}
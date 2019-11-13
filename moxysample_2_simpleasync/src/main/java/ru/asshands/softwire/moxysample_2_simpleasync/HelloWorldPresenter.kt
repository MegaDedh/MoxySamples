package ru.asshands.softwire.moxysample_2_simpleasync

import android.os.AsyncTask
import moxy.InjectViewState
import moxy.MvpPresenter
import java.util.concurrent.TimeUnit

@InjectViewState
class HelloWorldPresenter : MvpPresenter<HelloWorldView>() {
    init {
        AsyncSleep().execute()
        viewState.toggleProgressBar(true)
    }

    private inner  class AsyncSleep : AsyncTask<Void, Void, Void>() {

        override fun doInBackground(vararg params: Void?): Void? {
            sleepSeconds(4)
            return null
        }

        override fun onPostExecute(result: Void?) {
            viewState.showMessage(R.string.hello_world)
            viewState.toggleProgressBar(false)
            super.onPostExecute(result)
        }

        fun sleepSeconds(seconds: Long) {
            try {
                TimeUnit.SECONDS.sleep(seconds)
            } catch (ignore: InterruptedException) {
            }
        }
    }

}
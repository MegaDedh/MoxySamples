package ru.asshands.softwire.moxysample_5_asyncwith_view

import android.os.AsyncTask
import moxy.InjectViewState
import moxy.MvpPresenter
import java.util.concurrent.TimeUnit

@InjectViewState
class HelloWorldPresenter : MvpPresenter<HelloWorldView>() {
    init {
        AsyncSleep().execute()
    }

    private inner class AsyncSleep : AsyncTask<Void, Int, Void>() {

        override fun onPreExecute() {
            viewState.showTimer()
            super.onPreExecute()
        }

        override fun doInBackground(vararg params: Void?): Void? {
            for (i in 3 downTo 0) {
                publishProgress(i)
                sleepSeconds(1)
            }
            return null
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            values[0]?.let { viewState.setTimer(it) }
        }

        override fun onPostExecute(result: Void?) {
            viewState.hideTimer()
            viewState.showMessage(R.string.hello_world)
            super.onPostExecute(result)
        }

        fun sleepSeconds(seconds: Long) {
            try {
                TimeUnit.SECONDS.sleep(seconds)
            } catch (ignore: InterruptedException) {
            }
        }
    }

    fun onDismissMessage(){
        viewState.hideMessage()
    }

}
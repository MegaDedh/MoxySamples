package ru.asshands.softwire.moxysample_4_async_alertdialog

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter


class MainActivity : MvpAppCompatActivity(), HelloWorldView {


    @InjectPresenter
    lateinit var mHelloWorldPresenter: HelloWorldPresenter
    private var mMessageDialog: AlertDialog? = null

    @ProvidePresenter
    fun providePresenter(): HelloWorldPresenter = HelloWorldPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    // IMPL VIEW:

    override fun showTimer() {
        main_timer_tv.visibility = View.VISIBLE
    }

    override fun hideTimer() {
        main_timer_tv.visibility = View.GONE
    }

    override fun setTimer(seconds: Int) {
        main_timer_tv.text = getString(R.string.timer, seconds)
    }

    override fun showMessage(message: Int) {

        mMessageDialog = AlertDialog.Builder(this)
            .setTitle(R.string.app_name)
            .setMessage(message)
            .setPositiveButton(R.string.ok, null)
            // если пользователь скрывает AlertDialog,
            // то нужно пробросить эту команду через Presenter (чтобы она записалась в стек)
            // в противном случае мы снова увидим AlertDialog при перевороте:
            .setOnDismissListener { mHelloWorldPresenter.onDismissMessage() }
            .show()
    }

    override fun hideMessage() {
         mMessageDialog?.let {
             it.dismiss()
             it.setOnDismissListener(null)
         }
    }

    override fun onDestroy() {
        super.onDestroy()
        mMessageDialog?.let {
            // поскольку скрытие инициировано системой, а не пользователем,
            // выключаем Listener, чтобы последней командой в стек не улетела hideMessage
            it.setOnDismissListener(null)
            // скрываем AlertDialog, перед смертью Activity, (чтобы не поймать WindowLeaked):
            it.dismiss()
        }
    }
}
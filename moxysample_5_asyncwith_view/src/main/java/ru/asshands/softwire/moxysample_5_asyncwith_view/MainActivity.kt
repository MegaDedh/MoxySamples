package ru.asshands.softwire.moxysample_5_asyncwith_view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.view.marginTop
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_message.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter




class MainActivity : MvpAppCompatActivity(), HelloWorldView {


    @InjectPresenter
    lateinit var mHelloWorldPresenter: HelloWorldPresenter

    @ProvidePresenter
    fun providePresenter(): HelloWorldPresenter = HelloWorldPresenter()

    var mMessageView: View? = null

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
        mMessageView = LayoutInflater
            .from(this)
            .inflate(R.layout.item_message, activity_main_root_constraint_layout, false)
        activity_main_root_constraint_layout.addView(mMessageView)

        item_message_txt_hello.text = getText(message)
        item_message_btn_close.setOnClickListener {
            mHelloWorldPresenter.onDismissMessage()
        }

    }

    override fun hideMessage() {
        activity_main_root_constraint_layout.removeView(mMessageView)
    }
}
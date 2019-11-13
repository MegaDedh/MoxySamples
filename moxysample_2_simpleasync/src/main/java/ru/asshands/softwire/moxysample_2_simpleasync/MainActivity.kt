package ru.asshands.softwire.moxysample_2_simpleasync

import android.os.Bundle
import android.view.View
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_main.*
import moxy.presenter.ProvidePresenter


class MainActivity : MvpAppCompatActivity(), HelloWorldView {


    @InjectPresenter
    lateinit var mHelloWorldPresenter: HelloWorldPresenter

    @ProvidePresenter
    fun providePresenter(): HelloWorldPresenter = HelloWorldPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun showMessage(message: Int) {

        val messageTextView = TextView(this)
        val constraintLayoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )

        constraintLayoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
        constraintLayoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
        constraintLayoutParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID
        constraintLayoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID

        messageTextView.text = getText(message)
        messageTextView.textSize = 40F
        messageTextView.layoutParams = constraintLayoutParams

        activity_main_root_constraint_layout.addView(messageTextView)
    }

    override fun toggleProgressBar(isLoading: Boolean) {
        if (isLoading) {
            activity_main_progressbar.visibility = View.VISIBLE
        } else {
            activity_main_progressbar.visibility = View.GONE
        }
    }
}
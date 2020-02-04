package ru.asshands.softwire.moxysample_6_custom_view_as_mvpview

import android.content.Context
import android.widget.FrameLayout
import moxy.MvpDelegate
import android.util.AttributeSet
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.item_counter.view.*
import moxy.presenter.InjectPresenter


class CounterWidget(context: Context, attrs: AttributeSet?) :
    FrameLayout(context, attrs),
    CounterView {

    private var mParentDelegate: MvpDelegate<*>? = null
    private var mMvpDelegate: MvpDelegate<CounterWidget>? = null

    @InjectPresenter
    lateinit var mCounterPresenter: CounterPresenter

    init {
        LayoutInflater.from(context).inflate(R.layout.item_counter, this, true)
        plus_button.setOnClickListener {
            mCounterPresenter.onPlusClick()
        }
    }

    fun init(parentDelegate: MvpDelegate<*>) {
        mParentDelegate = parentDelegate

        getMvpDelegate().onCreate()
        getMvpDelegate().onAttach()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        getMvpDelegate().onSaveInstanceState()
        getMvpDelegate().onDetach()
    }

    fun getMvpDelegate(): MvpDelegate<CounterWidget> {
        if (mMvpDelegate != null) {
            return mMvpDelegate
        }

        mMvpDelegate = MvpDelegate(this)
        mMvpDelegate.setParentDelegate(mParentDelegate, id.toString())
        return mMvpDelegate
    }

    override fun showCount(count: Int) {
        count_text.text = count.toString()
    }
}
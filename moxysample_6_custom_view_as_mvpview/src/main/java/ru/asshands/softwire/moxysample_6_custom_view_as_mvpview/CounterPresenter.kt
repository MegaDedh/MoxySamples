package ru.asshands.softwire.moxysample_6_custom_view_as_mvpview

import moxy.InjectViewState
import moxy.MvpPresenter


@InjectViewState
class CounterPresenter : MvpPresenter<CounterView>() {
    private var mCount = 0

    fun CounterPresenter() {
        viewState.showCount(mCount)
    }

    fun onPlusClick() {
        mCount++
        viewState.showCount(mCount)
    }
}
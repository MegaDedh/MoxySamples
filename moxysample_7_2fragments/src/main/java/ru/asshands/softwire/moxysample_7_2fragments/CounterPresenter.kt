package ru.asshands.softwire.moxysample_7_2fragments

import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class CounterPresenter : MvpPresenter<CounterView>() {
    private var mCount = 0

    init {
        viewState.showCount(mCount)
    }

    fun onPlusClick(){
        mCount++
        viewState.showCount(mCount)
    }
}
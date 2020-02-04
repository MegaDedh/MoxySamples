package ru.asshands.softwire.moxysample_6_custom_view_as_mvpview

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface CounterView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showCount(count: Int)
}
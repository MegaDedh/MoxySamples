package ru.asshands.softwire.moxysample_7_2fragments

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)

interface CounterView : MvpView {
    fun showCount(count: Int)
}
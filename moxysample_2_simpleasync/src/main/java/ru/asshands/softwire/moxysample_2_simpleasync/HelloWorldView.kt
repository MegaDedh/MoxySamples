package ru.asshands.softwire.moxysample_2_simpleasync

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

interface HelloWorldView:MvpView {

    @StateStrategyType(AddToEndStrategy::class)
    fun showMessage(message: Int)
    @StateStrategyType(AddToEndStrategy::class)
    fun toggleProgressBar(isLoading: Boolean)
}
package ru.asshands.softwire.moxysample_1

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface MainView : MvpView {
    @StateStrategyType(AddToEndStrategy::class)
    fun printLog(msg: String)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openKtxActivity()
}
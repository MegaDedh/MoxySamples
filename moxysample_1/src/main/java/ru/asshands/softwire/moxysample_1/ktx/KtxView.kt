package ru.asshands.softwire.moxysample_1.ktx

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

interface KtxView : MvpView {
    @StateStrategyType(AddToEndStrategy::class)
    fun printKtxLog(msg: String)
}
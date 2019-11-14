package ru.asshands.softwire.moxysample_4_async_alertdialog

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndStrategy::class)
interface HelloWorldView : MvpView {

    fun showTimer()
    fun hideTimer()
    fun setTimer(seconds: Int)
    fun showMessage(message: Int)
    fun hideMessage()
}
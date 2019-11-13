package ru.asshands.softwire.moxysample_2_simpleasync

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

/**
 * Доступные стратегии:
 * AddToEndStrategy — выполнить команду и добавить команду в конец очереди
 * AddToEndSingleStrategy — выполнить команду, добавить ее в конец очереди и удалить все ее предыдущие экземпляры
 * SingleStateStrategy — выполнить команду, очистить очередь и добавить в нее команду
 * SkipStrategy — выполнить команду
 * OneExecuteStrategy — выполнить команду при первой возможности
 *
 * Аннотацию стратегий можно разместить перед объявлением интерфейса для всех методов
 * Так-же можно добавить требуемую аннотацию непосредственно перед методом
 */

@StateStrategyType(AddToEndStrategy::class)
interface HelloWorldView : MvpView {

    fun showMessage(message: Int)
    fun toggleProgressBar(isLoading: Boolean)
}
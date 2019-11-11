package ru.asshands.softwire.moxysample_1

import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MainPresenter constructor(
    private val logger: Logger
) : MvpPresenter<MainView>() {

// сперва последовательно выгружаются команды из ViewState (первые в ViewState шли команды 1 и 3),
// при каждом перевороте во ViewState добавляется команда 1 (вызовы 1.1, 1.2, 1.3)
// (т.к. каждый раз при создании Activity и сохранятеся в ViewState)

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        //2 вызовется один раз когда приаттачится Presenter. Не запишется в ViewState:
        logger.printLog( "presenter hash code : ${hashCode()}")
        //3 вызовется один раз и сохранится в ViewState:
        viewState.printLog("TEST")
    }

    fun printLog() {
        //1.2 вызывается каждый раз при создании Activity и сохранятеся в ViewState
        viewState.printLog("TEST print log ${hashCode()}")
    }

    fun onOpenKtxButtonClick() {
        viewState.openKtxActivity()
    }

}
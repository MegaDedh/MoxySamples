package ru.asshands.softwire.moxysample_1.ktx

import moxy.InjectViewState
import moxy.MvpPresenter
import ru.asshands.softwire.moxysample_1.Logger

@InjectViewState
class KtxPresenter constructor(
    private val logger: Logger
) : MvpPresenter<KtxView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        logger.printLog("presenter hash code : ${hashCode()}")
        viewState.printKtxLog("TEST")
    }

    fun printLog() {
        viewState.printKtxLog("TEST ktx print log ${hashCode()}")
    }
}
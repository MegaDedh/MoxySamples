package ru.asshands.softwire.moxysample_1.ktx

import android.os.Bundle
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.asshands.softwire.moxysample_1.Logger
import ru.asshands.softwire.moxysample_1.R

class KtxActivity : MvpAppCompatActivity(), KtxView {

    val logger = Logger()

    val ktxPresenter by moxyPresenter {
        KtxPresenter(logger)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ktx)


        ktxPresenter.printLog()
    }

    override fun printKtxLog(msg: String) {
        logger.printLog("printKtxLog : msg : $msg activity hash code : ${hashCode()}")
    }

}
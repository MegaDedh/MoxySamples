package ru.asshands.softwire.moxysample_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.asshands.softwire.moxysample_1.ktx.KtxActivity

class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    private val logger = Logger()

    @ProvidePresenter
    fun providePresenter(): MainPresenter = MainPresenter(logger)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.printLog() //1.1 вызывается каждый раз при создании Activity и пишется в ViewState

        findViewById<Button>(R.id.activity_main_button_ktx).setOnClickListener {
            presenter.onOpenKtxButtonClick()
        }
    }

    override fun printLog(msg: String) {
        logger.printLog("printLog : msg : $msg activity hash code : ${hashCode()}") //1.3
    }

    override fun openKtxActivity() {
        startActivity(Intent(this, KtxActivity::class.java))
    }

}
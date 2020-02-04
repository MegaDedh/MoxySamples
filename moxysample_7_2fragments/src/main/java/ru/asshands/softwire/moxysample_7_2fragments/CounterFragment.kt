package ru.asshands.softwire.moxysample_7_2fragments

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.item_fragment.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class CounterFragment : MvpAppCompatFragment(), CounterView {

    @InjectPresenter
    lateinit var mCounterPresenter: CounterPresenter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        plus_button.setOnClickListener { mCounterPresenter.onPlusClick() }
    }

    override fun showCount(count: Int) {
        count_text.text = count.toString()
    }
}
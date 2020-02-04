package ru.asshands.softwire.moxysample_6_custom_view_as_mvpview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity

class MainActivity : MvpAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ((CounterWidget) findViewById(R.id.counter_1)).init(getMvpDelegate())
//        ((CounterWidget) findViewById(R.id.counter_2)).init(getMvpDelegate());
    }
}

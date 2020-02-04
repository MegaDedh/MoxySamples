package ru.asshands.softwire.moxysample_7_2fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
val fragment1 = CounterFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.frame_1,  fragment1)
             //   .add(R.id.frame_1, getFragment(0xffFF80AB.toInt()))
           //     .add(R.id.frame_2, getFragment(0xFFCCFF90.toInt()))
              //  .add(R.id.frame_2, getFragment(0xFFCCFF90.toInt()))
                .commit()
        }
    }

    private fun getFragment(color: Int): Fragment {
        val fragment = CounterFragment()
        val args = Bundle()
        args.putInt("argColor", color)
        fragment.arguments = args
        return fragment
    }
}

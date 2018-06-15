package app.isfaaghyth.updatify

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import app.isfaaghyth.updatify.util.NotifEvent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Test(this).start()
    }

}

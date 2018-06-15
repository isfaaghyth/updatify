package app.isfaaghyth.updatify

import android.content.Context
import android.util.Log
import app.isfaaghyth.updatify.util.JobListen
import com.firebase.jobdispatcher.*

/**
 * Created by isfaaghyth on 6/16/18.
 * github: @isfaaghyth
 */
class Test(context: Context) {

    private val ID = "123"
    private var mDispatcher = FirebaseJobDispatcher(GooglePlayDriver(context))

    fun start() {
        Log.d("TAG", "test() start")
        val job = mDispatcher.newJobBuilder()
                .setService(JobListen::class.java)
                .setTag(ID)
                .setRecurring(true)
                .setLifetime(Lifetime.UNTIL_NEXT_BOOT)
                .setTrigger(Trigger.executionWindow(0, 60))
                .setReplaceCurrent(true)
                .setRetryStrategy(RetryStrategy.DEFAULT_EXPONENTIAL)
                .build()
        mDispatcher.mustSchedule(job)
    }

    fun stop() {
        Log.d("TAG", "test() stop")
        mDispatcher.cancel(ID)
    }

}
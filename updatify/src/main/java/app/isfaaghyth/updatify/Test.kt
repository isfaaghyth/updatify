package app.isfaaghyth.updatify

import android.content.Context
import app.isfaaghyth.updatify.util.JobListen
import com.firebase.jobdispatcher.*

/**
 * Created by isfaaghyth on 6/16/18.
 * github: @isfaaghyth
 */
class Test(val context: Context) {

    private val ID = "123"
    private var mDispatcher = FirebaseJobDispatcher(GooglePlayDriver(context))

    fun start() {
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
        mDispatcher.cancel(ID)
    }

}
package app.isfaaghyth.updatify.util

import android.util.Log
import com.firebase.jobdispatcher.JobParameters
import com.firebase.jobdispatcher.JobService

import java.text.SimpleDateFormat
import java.util.Calendar

/**
 * Created by isfaaghyth on 6/16/18.
 * github: @isfaaghyth
 */

class JobListen : JobService() {

    override fun onStartJob(job: JobParameters): Boolean {
        Log.d("TAG", "onstartjob()")
        val df = SimpleDateFormat("EEE, d MMM yyyy, HH:mm")
        val date = df.format(Calendar.getInstance().time)
        NotificationUtil.showNotification(applicationContext, "test", "halo ini message! $date", 0)
        NotifEvent.post("ini pesan dari notify")
        jobFinished(job, true)
        return false
    }

    override fun onStopJob(job: JobParameters): Boolean = true

}

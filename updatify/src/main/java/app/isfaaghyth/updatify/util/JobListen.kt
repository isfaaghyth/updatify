package app.isfaaghyth.updatify.util

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
        val df = SimpleDateFormat("EEE, d MMM yyyy, HH:mm")
        val date = df.format(Calendar.getInstance().time)
        if (date == "02.30") {
            NotifEvent.post("ini pesan dari notify")
            NotificationUtil.showNotification(applicationContext, "test", "halo ini message!", 0)
        }
        return false
    }

    override fun onStopJob(job: JobParameters): Boolean = true

}

package app.isfaaghyth.updatify.util

import android.support.v4.content.ContextCompat
import android.support.v4.app.NotificationCompat
import android.media.RingtoneManager
import android.app.NotificationManager
import android.content.Context


/**
 * Created by isfaaghyth on 6/16/18.
 * github: @isfaaghyth
 */
class NotificationUtil {

    companion object {
        fun showNotification(context: Context, title: String, message: String, notifId: Int) {
            val notificationManagerCompat = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val builder = NotificationCompat.Builder(context)
                    .setContentTitle(title)
                    //.setSmallIcon(R.drawable.notification_template_icon_bg)
                    .setContentText(message)
                    .setColor(ContextCompat.getColor(context, android.R.color.black))
                    .setVibrate(longArrayOf(1000, 1000, 1000, 1000, 1000))
                    .setSound(alarmSound)

            notificationManagerCompat.notify(notifId, builder.build())
        }
    }

}
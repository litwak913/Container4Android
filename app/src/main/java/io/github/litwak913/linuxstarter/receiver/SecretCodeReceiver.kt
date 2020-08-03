package io.github.litwak913.linuxstarter.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import io.github.litwak913.linuxstarter.activity.WelcomeActivity

class SecretCodeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val activityIntent = Intent(context, WelcomeActivity::class.java)
        activityIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context!!.startActivity(activityIntent)
    }

}
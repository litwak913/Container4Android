package io.github.litwak913.container4android.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import io.github.litwak913.container4android.activity.MainActivity

class SecretCodeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        val activityIntent = Intent(context, MainActivity::class.java)
        val perf = context.getSharedPreferences("config", MODE_PRIVATE)
        if (perf.getBoolean("firstRunComplete", false) && perf.getBoolean("secretMode", false)) {
            activityIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(activityIntent)
        }
    }

}
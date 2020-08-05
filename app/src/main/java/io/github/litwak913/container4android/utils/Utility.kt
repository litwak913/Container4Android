package io.github.litwak913.container4android.utils

import android.util.Log
import java.io.DataOutputStream

class Utility {
    companion object {
        fun checkRoot(): Boolean {
            val os: DataOutputStream?
            val LOG_TAG = "RootCheck"
            Log.i(LOG_TAG, "exec su")
            val process = Runtime.getRuntime().exec("su")
            os = DataOutputStream(process.outputStream)
            os.writeBytes("exit\n")
            os.flush()
            Log.i(LOG_TAG, process.waitFor().toString())
            return process.waitFor() == 0
        }
    }
}
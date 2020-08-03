package io.github.litwak913.linuxstarter.utils

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.util.Log
import android.widget.Button
import android.widget.Toast
import io.github.litwak913.linuxstarter.R
import java.io.DataOutputStream

class Utility {
    companion object {
        fun checkRoot(context: Context, button: Button) {
            var process: Process?
            val os: DataOutputStream?
            val LOG_TAG = "RootCheck"
            Log.i(LOG_TAG, "exec su")
            process = Runtime.getRuntime().exec("su")
            os = DataOutputStream(process.outputStream)
            os.writeBytes("exit\n")
            os.flush()
            Log.i(LOG_TAG, process.waitFor().toString())
            if (process.waitFor() == 0) {
                Toast.makeText(
                    context,
                    context.resources.getText(R.string.check_root_ok),
                    Toast.LENGTH_SHORT
                ).show()
                button.text = context.resources.getText(R.string.check_root_ok)
                button.isEnabled = false
            } else {
                AlertDialog.Builder(context)
                    .setTitle(R.string.check_root_fail)
                    .setMessage(R.string.check_root_fail_desc)
                    .setPositiveButton(R.string.ok) { dialog: DialogInterface, _: Int ->
                        dialog.dismiss()
                    }
                    .setCancelable(false)
                    .create()
                    .show()
            }
        }
    }
}
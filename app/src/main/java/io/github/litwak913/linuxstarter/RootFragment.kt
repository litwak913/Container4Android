package io.github.litwak913.linuxstarter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.permissions_request.*
import java.io.DataOutputStream

class RootFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.permissions_request, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        root_button.setOnClickListener {
            var process: Process? = null
            var os: DataOutputStream? = null
            val LOG_TAG = "RootCheck"
            Log.i(LOG_TAG, "exec su")
            process = Runtime.getRuntime().exec("su")
            os = DataOutputStream(process.outputStream)
            os.writeBytes("exit\n")
            os.flush()
            if (process.waitFor() == 0) {
                Toast.makeText(
                    activity,
                    resources.getText(R.string.check_root_ok),
                    Toast.LENGTH_SHORT
                ).show()
                root_button.text = resources.getText(R.string.check_root_ok)
                root_button.isEnabled = false
            } else {

            }
        }
    }
}


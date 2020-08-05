package io.github.litwak913.container4android.fragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreference
import io.github.litwak913.container4android.R

class AppSettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        preferenceManager.sharedPreferencesName = "config"
        setPreferencesFromResource(R.xml.app_config, rootKey)
        val secretMode: SwitchPreference? = findPreference("secretMode")
        secretMode?.setOnPreferenceClickListener {
            Log.d("Config", secretMode.isChecked.toString())
            if (secretMode.isChecked) {
                AlertDialog.Builder(context)
                    .setTitle(R.string.hint)
                    .setMessage(R.string.secret_mode_hint)
                    .setPositiveButton(R.string.ok) { dialog: DialogInterface, _: Int ->
                        dialog.dismiss()
                    }
                    .setCancelable(false)
                    .create()
                    .show()
            }
            true
        }
    }
}
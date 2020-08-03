package io.github.litwak913.linuxstarter.fragment

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import io.github.litwak913.linuxstarter.R

class AppSettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.app_config, rootKey)
        preferenceManager.sharedPreferencesName = "config"
    }
}
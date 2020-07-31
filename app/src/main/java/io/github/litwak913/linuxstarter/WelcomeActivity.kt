package io.github.litwak913.linuxstarter

import android.Manifest
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment

class WelcomeActivity : AppIntro(){
    private lateinit var perf: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        perf = getSharedPreferences("config", MODE_PRIVATE)

        if (perf.getBoolean("firstRunComplete", false)) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        addSlide(
            AppIntroFragment.newInstance(
                title = resources.getString(R.string.welcome),
                description = resources.getString(R.string.welcome_desc)
            )
        )
        addSlide(
            AppIntroFragment.newInstance(
                title = resources.getString(R.string.welcome_deploy),
                description = resources.getString(R.string.welcome_deploy_desc)
            )
        )
        addSlide(
            AppIntroFragment.newInstance(
                title = resources.getString(R.string.welcome_custom),
                description = resources.getString(R.string.welcome_custom_desc)
            )
        )
        addSlide(
            AppIntroFragment.newInstance(
                title = resources.getString(R.string.welcome_module),
                description = resources.getString(R.string.welcome_module_desc)
            )
        )
        addSlide(RootFragment())
        addSlide(
            AppIntroFragment.newInstance(
                title = resources.getString(R.string.app_ready),
                description = resources.getString(R.string.app_ready_desc)
            )
        )
        askForPermissions(
            permissions = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            slideNumber = 4,
            required = true
        )
        setDoneText("完成")
        setSkipText("跳过")
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        val editor = perf.edit()
        editor.putBoolean("firstRunComplete", true)
        editor.apply()
        startActivity(Intent(this, MainActivity::class.java ))
        finish()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        val editor = perf.edit()
        editor.putBoolean("firstRunComplete", true)
        editor.apply()
        startActivity(Intent(this, MainActivity::class.java ))
        finish()
    }
}
package io.github.litwak913.linuxstarter

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment

class WelcomeActivity : AppIntro(){
    private var perf: SharedPreferences = getSharedPreferences("config", MODE_PRIVATE)
    private var editor: SharedPreferences.Editor = perf.edit()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (perf.getBoolean("firstRunComplete", false)) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        addSlide(
            AppIntroFragment.newInstance(
                title = "Welcome...",
                description = "This is the first slide of the example"
            )
        )
        addSlide(
            AppIntroFragment.newInstance(
            title = "...Let's get started!",
            description = "This is the last slide, I won't annoy you more :)"
        ))
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        editor.putBoolean("firstRunComplete",true)
        editor.commit()
        startActivity(Intent(this, MainActivity::class.java ))
        finish()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        editor.putBoolean("firstRunComplete",true)
        editor.commit()
        startActivity(Intent(this, MainActivity::class.java ))
        finish()
    }
}
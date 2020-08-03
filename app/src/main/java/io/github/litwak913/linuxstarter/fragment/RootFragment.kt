package io.github.litwak913.linuxstarter.fragment

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.github.appintro.SlideBackgroundColorHolder
import io.github.litwak913.linuxstarter.R
import io.github.litwak913.linuxstarter.utils.Utility
import kotlinx.android.synthetic.main.permissions_request.*

class RootFragment : Fragment(), SlideBackgroundColorHolder {
    override var defaultBackgroundColor: Int = 0
        private set

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun setBackgroundColor(backgroundColor: Int) {
        main.background = ColorDrawable(
            ContextCompat.getColor(
                activity as Context,
                R.color.page5_color
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.permissions_request, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        defaultBackgroundColor = ContextCompat.getColor(
            activity as Context,
            R.color.page5_color
        )
        root_button.setOnClickListener {
            Utility.checkRoot(
                activity as Context,
                root_button
            )
        }
    }
}


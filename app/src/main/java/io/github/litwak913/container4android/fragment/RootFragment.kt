package io.github.litwak913.container4android.fragment

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.github.appintro.SlideBackgroundColorHolder
import io.github.litwak913.container4android.R
import io.github.litwak913.container4android.utils.Utility
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
            val root: Boolean = Utility.checkRoot()
            if (root) {
                Toast.makeText(
                    activity,
                    requireActivity().resources.getText(R.string.check_root_ok),
                    Toast.LENGTH_SHORT
                ).show()
                root_button.text = requireActivity().resources.getText(R.string.check_root_ok)
                root_button.isEnabled = false
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


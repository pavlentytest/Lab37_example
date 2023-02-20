package ru.myitschool.lab23

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment

class MyDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = AlertDialog.Builder(context)
            .setTitle("Записано!")
            .setMessage("Событие: " + arguments?.getString("title")
                        + "\nДата: " + arguments?.getString("date")
                        + "\nВремя: " + arguments?.getString("time")
                        + "\nЗаметки: " + arguments?.getString("notes"))

            .setPositiveButton("OK",  DialogInterface.OnClickListener { dialog, id ->
                // логика
            })
            .create()
        return dialog

    }
}
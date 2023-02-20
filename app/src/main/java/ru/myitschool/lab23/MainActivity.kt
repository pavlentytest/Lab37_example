package ru.myitschool.lab23

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import ru.myitschool.lab23.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dateString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.content.calendarView.setOnDateChangeListener { calendarView, i, i2, i3 ->
            dateString = i3.toString() + "." + (i2+1) + "." + i
        }

        binding.content.save.setOnClickListener {
            if(binding.content.eventTitleUserInput.text.toString() == "") {
                Snackbar.make(binding.root,"Введите название события!",Snackbar.LENGTH_LONG).show()
            } else {
                val dialog = MyDialog()
                val bundle = Bundle()
                bundle.putString("title",binding.content.eventTitleUserInput.text.toString())
                bundle.putString("time",binding.content.eventTimeUserInput.text.toString())
                bundle.putString("notes",binding.content.eventNotesUserInput.text.toString())
                bundle.putString("date", dateString)
                binding.content.eventTimeUserInput.text.clear()
                binding.content.eventTitleUserInput.text.clear()
                binding.content.eventNotesUserInput.text.clear()
                dialog.arguments = bundle
                dialog.show(supportFragmentManager,"")
            }
        }
    }
}
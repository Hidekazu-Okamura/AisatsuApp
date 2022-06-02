package jp.techacademy.hidekazu.okamura.aisatsuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import android.app.TimePickerDialog

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var h: Int = 0
    var mi: Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        when(v.id) {
            R.id.button -> {
                showTimePickerDialog()

            }
        }
    }
    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->

                this.h = hour
                this.mi=minute
                if ((this.h >= 2 && this.mi >= 0) && (this.h <= 9 && this.mi <= 59)) {
                    textView.text = "おはよう"
                } else if ((this.h >= 10 && this.mi >= 0) && (this.h <= 17 && this.mi <= 59)){
                    textView.text = "こんにちは"
                } else {
                    textView.text = "こんばんは"
                }
            },
            13, 0, true)
        timePickerDialog.show()
    }
}

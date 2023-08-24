package com.example.mad5_63_5b6

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Gallery

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val browser=findViewById<Button>(R.id.btn_browser)
//        val call=findViewById<Button>(R.id.btn_call)
//        val calllog=findViewById<Button>(R.id.call_log_btn)
//        val camera=findViewById<Button>(R.id.camera_btn)
        implicitIntent()
    }
    private fun implicitIntent(){
        //browser
        findViewById<Button>(R.id.btn_browser).setOnClickListener{
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(findViewById<EditText>(R.id.txt_input_url).text.toString())
            ).also{startActivity(it)}
        }
        //call
        findViewById<Button>(R.id.btn_call).setOnClickListener {
            val number=findViewById<EditText>(R.id.edit_txt_phone_no).text.toString().trim()
            Intent(
                Intent.ACTION_DIAL).setData((Uri.parse("tel:$number"))).apply{startActivity(this)}

        }
        //call log
        findViewById<Button>(R.id.call_log_btn).setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also{startActivity((it))}
        }
        //gallery
        findViewById<Button>(R.id.gallery_btn).setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType("image/*").also { startActivity(it) }
        }
        //camera
        findViewById<Button>(R.id.camera_btn).setOnClickListener {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }
        }
        //alarm
        findViewById<Button>(R.id.alarm_btn).setOnClickListener {
            Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }
        }
    }
}
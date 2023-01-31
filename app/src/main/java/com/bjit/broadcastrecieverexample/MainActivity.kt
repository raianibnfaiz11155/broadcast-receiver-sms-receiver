package com.bjit.broadcastrecieverexample

import android.Manifest
import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var receiver: AirplaneModeChangeReceiver
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Request SMS permission
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "Hello 8", Toast.LENGTH_SHORT).show()
        //check Internet permission
        receiver = AirplaneModeChangeReceiver()
        requestSmsPermission()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver, it)
        }
//        val smsBody = findViewById<TextView>(R.id.smsText)
//        smsBody.text = intent.getStringExtra("sms")
    }
    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
    private fun requestSmsPermission() {
        val permission = Manifest.permission.RECEIVE_SMS
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity(), arrayOf(permission), 1000)
        }
    }
}
package com.example.androidbootcamp

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.jar.Manifest

class HomePage : AppCompatActivity() {

    private val CAMERA_REQUEST_CODE = 1804

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        var tvName = findViewById<TextView>(R.id.tvName)
        var tvEmail = findViewById<TextView>(R.id.tvEmail)
        var tvPhone = findViewById<TextView>(R.id.tvPhone)
        var tvPass = findViewById<TextView>(R.id.tvPass)

        var strName  = intent.getStringExtra("name")
        var strEmail = intent.getStringExtra("email")
        var strPhone = intent.getStringExtra("phone")
        var strPass = intent.getStringExtra("password")

        tvName.setText(strName)
        tvEmail.setText(strEmail)
        tvPhone.setText(strPhone)
        tvPass.setText(strPass)

        var btnUrl = findViewById<Button>(R.id.btnUrl)
        var btnPermission = findViewById<Button>(R.id.btnPermission)
        var etUrl = findViewById<EditText>(R.id.etUrl)



        btnUrl.setOnClickListener(View.OnClickListener {
            if (etUrl.text.toString().isNullOrBlank()) {
                etUrl.error = "Enter url"
            } else {
                var url: String = etUrl.text.toString()
                val i = Intent(Intent.ACTION_VIEW)
                i.setData(Uri.parse(url))
                startActivity(i)
            }
        })

        btnPermission.setOnClickListener(View.OnClickListener {
            val value = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
            when (value) {
                PackageManager.PERMISSION_GRANTED -> {
                    Log.e("USER_PERMISSION", "PERMISSION_GRANTED")
                    Toast.makeText(this, "Permission already granted", Toast.LENGTH_SHORT).show()
                }
                PackageManager.PERMISSION_DENIED -> {
                    ActivityCompat.requestPermissions(this,
                        arrayOf(android.Manifest.permission.CAMERA),
                        CAMERA_REQUEST_CODE)
                }
            }
        })



    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            CAMERA_REQUEST_CODE -> {
                if (grantResults.isEmpty() || (grantResults[0] != PackageManager.PERMISSION_GRANTED)) {
                    Log.i("TAG", "Permission has been denied by user")
                    Toast.makeText(this, "Permission denied by user", Toast.LENGTH_SHORT).show()
                } else {
                    Log.i("TAG", "Permission has been granted by user")
                    Toast.makeText(this, "Permission granted by user", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}
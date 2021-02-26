package com.example.androidbootcamp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

/* Question : Create one signup activity having “user name”, “email-id”, “phone number”, “password”
with all fields mandatory.
Explicit Intent : On clicking on signup button user should able to see all the filled details on
the next screen.
Implicit Intent : On the second Activity there should be a input box and two button along with the
above details. the user should be able to enter a website url and on clicking one of the button an
implicit intent should be created to open a web browser with the url entered by the user.
Permission : On clicking on the second button check whether the app has the camera permission
granted or not if permission is granted display permission is granted otherwise ask user for
    permission and display whether the permission is granted or not.*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var name = findViewById<EditText>(R.id.name)
        var email = findViewById<EditText>(R.id.email)
        var phone = findViewById<EditText>(R.id.phone)
        var password = findViewById<EditText>(R.id.password)
        var signup = findViewById<Button>(R.id.signup)

        signup.setOnClickListener(View.OnClickListener {
            if(name.text.toString().isNullOrBlank()){
                name.error = "Please enter name"
            }
            else if(email.text.toString().isNullOrBlank()){
                email.error = "Please enter email"
            }
            else if(phone.text.toString().isNullOrBlank()){
                phone.error = "Please enter phone number"
            }
            else if(password.text.toString().isNullOrBlank()){
                password.error = "Please enter name"
            }else {
                val intent = Intent(this@MainActivity, HomePage::class.java)
                intent.putExtra("name", name.text.toString())
                intent.putExtra("email", email.text.toString())
                intent.putExtra("phone", phone.text.toString())
                intent.putExtra("password", password.text.toString())
                startActivity(intent)
            }
        })

    }
}
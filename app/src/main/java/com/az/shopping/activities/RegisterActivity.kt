package com.az.shopping.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.az.shopping.R
import com.az.shopping.entities.Users

class RegisterActivity : AppCompatActivity() {
    private lateinit var password: EditText
    private lateinit var username: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setTitle(R.string.register)

        username = findViewById(R.id.Username)
        password = findViewById(R.id.Password)

        var registerBtn: Button = findViewById(R.id.RegisterBtn)
        registerBtn.setOnClickListener {

            if (username.text.isEmpty()) {
                Toast.makeText(this, R.string.please_enter_username, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (password.text.isEmpty()) {
                Toast.makeText(this, R.string.please_enter_password, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            var user = Users(username.text.toString(), password.text.toString())
            user.save()

            Toast.makeText(this, R.string.registration_success, Toast.LENGTH_LONG).show()

            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
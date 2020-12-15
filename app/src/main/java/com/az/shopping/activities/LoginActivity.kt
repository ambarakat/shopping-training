package com.az.shopping.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.az.shopping.MainActivity
import com.az.shopping.R
import com.az.shopping.constants.AppConstants
import com.az.shopping.constants.setSharedPref
import com.az.shopping.entities.Users
import com.orm.query.Select
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var password: EditText
    private lateinit var username: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setTitle(R.string.login)

        username = findViewById(R.id.Username)
        password = findViewById(R.id.Password)

        var loginBtn: Button = findViewById(R.id.LoginBtn)
        var registerBtn: Button = findViewById(R.id.RegisterBtn)

        LoginBtn.setOnClickListener {

            if (username.text.isEmpty()) {
                Toast.makeText(this, R.string.please_enter_username, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (password.text.isEmpty()) {
                Toast.makeText(this, R.string.please_enter_password, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            var users = Select.from(Users::class.java)
                .where(" name = '${username.text.toString()}' and password = '${password.text.toString()}' ", null)
                .firstOrNull()

            if (users != null) {

                AppConstants.SP_CURRENT_USER.setSharedPref(this, "Ok")
                startActivity(Intent(this, MainActivity::class.java))
                finish()

            } else {

                Toast.makeText(this, R.string.please_enter_right_data, Toast.LENGTH_LONG).show()
            }
        }

        registerBtn.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
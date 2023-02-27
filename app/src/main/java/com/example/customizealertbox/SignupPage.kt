package com.example.customizealertbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignupPage : AppCompatActivity() {
    lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_page)
        supportActionBar?.hide()

        val name = findViewById<EditText>(R.id.name)
        val email = findViewById<EditText>(R.id.email)
        val user = findViewById<EditText>(R.id.user)
        val password = findViewById<EditText>(R.id.password)
        val btnsignup = findViewById<Button>(R.id.btnSignup)
        val signinEdit = findViewById<TextView>(R.id.signinEdit)

        signinEdit.setOnClickListener {
            val intent = Intent(this, SigninPage::class.java)
            startActivity(intent)
        }

        btnsignup.setOnClickListener {
            val Name = name.text.toString()
            val Email = email.text.toString()
            val User = user.text.toString()
            val Password = password.text.toString()
            val user = User(Name, Email, User, Password)
            database = FirebaseDatabase.getInstance().getReference("User")
            database.child(User).setValue(user).addOnSuccessListener {
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
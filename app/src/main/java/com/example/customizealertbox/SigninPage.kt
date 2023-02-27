package com.example.customizealertbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SigninPage : AppCompatActivity() {
    lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin_page)
        supportActionBar?.hide()
        val User = findViewById<EditText>(R.id.user)
        val SigninPage = findViewById<Button>(R.id.btnSignin)

        SigninPage.setOnClickListener {
//            database = FirebaseDatabase.getInstance().getReference("User")
            val intent = Intent(this, Addcontact::class.java)
            startActivity(intent)
        }

    }
}
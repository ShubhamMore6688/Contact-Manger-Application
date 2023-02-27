package com.example.customizealertbox

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Addcontact : AppCompatActivity() {
    lateinit var database : DatabaseReference
    lateinit var dialog : Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addcontact)
        supportActionBar?.hide()
        val Name = findViewById<EditText>(R.id.nameIn)
        val Phone = findViewById<EditText>(R.id.phonenoIn)
        val BtnAdd = findViewById<Button>(R.id.btnAdd)

        dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialogue)
        val Btn1 = dialog.findViewById<Button>(R.id.btn1)
        Btn1.setOnClickListener {
            dialog.dismiss()
        }
        BtnAdd.setOnClickListener {
            val name = Name.text.toString()
            val phone = Phone.text.toString()
            val Contact = contact(name, phone)
            database = FirebaseDatabase.getInstance().getReference("phone")
            database.child(phone).setValue(Contact).addOnSuccessListener {
            dialog.show()

            }
        }

    }
}
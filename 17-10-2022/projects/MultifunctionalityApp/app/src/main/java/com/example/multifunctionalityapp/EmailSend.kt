package com.example.multifunctionalityapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class EmailSend : AppCompatActivity() {
    var mail: EditText? = null
    var sub: EditText? = null
    var title: EditText? = null
    var send: Button? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mailsending)
        mail = findViewById<View>(R.id.edit_text1) as EditText
        sub = findViewById<View>(R.id.subject1) as EditText
        title = findViewById<View>(R.id.heading1) as EditText
        send = findViewById<Button>(R.id.mailbutton)
        Toast.makeText(
            applicationContext, "Inside mail ", Toast.LENGTH_SHORT
        ).show()
        send?.setOnClickListener {
            Toast.makeText(
                applicationContext, "Inside mail ", Toast.LENGTH_SHORT
            ).show()
            val receive = mail!!.text.toString().split(",").toTypedArray()
            val title1 = title!!.text.toString()
            val subject = sub!!.text.toString()
            var intent: Intent? = null
            var chooser: Intent? = null
            intent = Intent(Intent.ACTION_SEND)
            intent.type = "message/rfc822"
        //    intent.putExtra(Intent.)
            intent.putExtra(Intent.EXTRA_EMAIL, receive)
            intent.putExtra(Intent.EXTRA_SUBJECT, title1)
            intent.putExtra(Intent.EXTRA_TEXT, subject)
            chooser = Intent.createChooser(intent, "Select Email App..")
            startActivity(chooser)
            Toast.makeText(
                applicationContext, "Select Email App.", Toast.LENGTH_SHORT
            ).show()
        }
    }
}
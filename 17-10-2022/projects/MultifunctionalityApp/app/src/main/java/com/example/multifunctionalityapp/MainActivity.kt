package com.example.multifunctionalityapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var weburl: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        weburl = findViewById<View>(R.id.website) as Button
    }

    fun dosomething(v: View) {
        var intent: Intent? = null
        var chooser: Intent? = null
        when (v.id) {
            R.id.website -> {
                val i = Intent(this,OpenUrl::class.java)
             //   i.setClassName("com.example.multifuncationalityapp", "com.example.multifuncationalityapp.OpenUrl")
                //startActivity();
                startActivity(i)
            }
            R.id.email -> {
                val j = Intent(this,EmailSend::class.java)
            //    j.setClassName("com.example.multifuncationalityapp", "com.example.multifuncationalityapp.EmailSend")
                startActivity(j)
            }
            R.id.phonecall -> {
                val k = Intent(this,Calling::class.java)
               // k.setClassName("com.example.multifuncationalityapp", "com.example.multifuncationalityapp.Calling")
                startActivity(k)
            }
            R.id.map -> {
                intent = Intent(Intent.ACTION_VIEW)
                intent.data =
                    Uri.parse("http://maps.google.com/maps?q=38.897676,-77.03653(Label Point)")
                chooser = Intent.createChooser(intent, "Open Map Using...")
                startActivity(chooser)
                Toast.makeText(
                    applicationContext, "Open Map Using", Toast.LENGTH_SHORT
                ).show()
            }
            R.id.messagesend -> {
                val a = Intent(this,LetsTalk::class.java)
          //      a.setClassName("com.example.multifuncationalityapp", "com.example.multifuncationalityapp.LetsTalk")
                startActivity(a)
            }
            R.id.imagesend -> {
                intent = Intent(Intent.ACTION_SEND)
                intent.type = "image/*"
                intent.putExtra(Intent.EXTRA_TEXT, "Check the attached Image...")
                val uri_img = Uri.parse("android.resource://com.example/drawable/" + R.drawable.uii)
                intent.putExtra(Intent.EXTRA_STREAM, uri_img)
                chooser = Intent.createChooser(intent, "Share image via..")
                if (intent.resolveActivity(packageManager) != null) startActivity(chooser) else Toast.makeText(
                    applicationContext, "No Apps Available", Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

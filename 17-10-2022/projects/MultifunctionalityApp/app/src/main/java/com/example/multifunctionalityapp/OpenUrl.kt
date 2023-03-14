package com.example.multifunctionalityapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class OpenUrl : AppCompatActivity() {
    var url: EditText? = null
    var open_url: Button? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.websiteopen)
        url = findViewById<View>(R.id.website) as EditText
        open_url = findViewById<View>(R.id.openurl) as Button
        open_url!!.setOnClickListener {
            val url1 = "https://" + url!!.text.toString()
           // intent1.data =

            var intent1: Intent  = Intent(Intent.ACTION_VIEW, Uri.parse(url1))
            startActivity(intent1)
         //   var chooser1: Intent = Intent.createChooser(intent1, "Open website Using...")
           /* Toast.makeText(
                applicationContext, intent1.resolveActivity(packageManager).toString(), Toast.LENGTH_SHORT
            ).show()*/
            Toast.makeText(
                applicationContext, "Opening a website", Toast.LENGTH_SHORT
            ).show()
        }
    }
}
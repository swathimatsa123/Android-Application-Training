package com.example.multifunctionalityapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat


class Calling : AppCompatActivity() {
    var phone: EditText? = null
    var call: Button? = null
    @RequiresApi(Build.VERSION_CODES.M)
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calls)


        val hasLocationPermission = checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
        val hasSMSPermission = checkSelfPermission(Manifest.permission.SEND_SMS)
        val permissions: MutableList<String> = ArrayList()
        if (hasLocationPermission != PackageManager.PERMISSION_GRANTED) {
            permissions.add(Manifest.permission.ACCESS_FINE_LOCATION)
        }

        if (hasSMSPermission != PackageManager.PERMISSION_GRANTED) {
            permissions.add(Manifest.permission.SEND_SMS)
        }

        if (!permissions.isEmpty()) {
            val REQUEST_CODE_SOME_FEATURES_PERMISSIONS=""
   //         requestPermissions(permissions.toTypedArray(), REQUEST_CODE_SOME_FEATURES_PERMISSIONS)
        }
        phone = findViewById<View>(R.id.make_call) as EditText
        call = findViewById<View>(R.id.call1) as Button
        call!!.setOnClickListener {
            val no = phone!!.text.toString()
            var intent: Intent? = null
            intent = Intent(Intent.ACTION_CALL)
            if (no.trim { it <= ' ' }.isEmpty()) {
                Toast.makeText(applicationContext, "Please Enter A Number", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val TELEPHONE_SCHEMA = "tel:"
                val PRESERVED_CHARACTER = "+"
                val HK_COUNTRY_CODE = "91"
                val overallTelephoneUri =
                    TELEPHONE_SCHEMA + PRESERVED_CHARACTER + HK_COUNTRY_CODE + no

                intent.data = Uri.parse(overallTelephoneUri)
            }
            if (ActivityCompat.checkSelfPermission(
                    applicationContext,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                Toast.makeText(
                    applicationContext,
                    "Please Grant Permission To Proceed",
                    Toast.LENGTH_SHORT
                ).show()
                requestPermission()
            } else startActivity(intent)
            /* Only for dialling
                    intent=new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+no));
                    if(intent.resolveActivity(getPackageManager())!=null)
                        startActivity(intent);
                */
        }
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this@Calling, arrayOf(Manifest.permission.CALL_PHONE), 1)
    }
}

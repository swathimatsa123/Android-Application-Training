package com.example.multifunctionalityapp


import android.Manifest
import android.app.PendingIntent
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.telephony.SmsManager
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


class LetsTalk : AppCompatActivity() {
                                    var messages: EditText? = null
                                    var number: EditText? = null
                                    var enter: Button? = null
                                    var textss: String? = null
                                    var phone: String? = null
                                    @RequiresApi(Build.VERSION_CODES.M)
                                    public override fun onCreate(savedInstanceState: Bundle?) {
                                        super.onCreate(savedInstanceState)
                                        setContentView(R.layout.messaging)
                                        messages = findViewById<View>(R.id.user_msg) as EditText
                                        number = findViewById<View>(R.id.user_call) as EditText
                                        enter = findViewById<View>(R.id.msg) as Button
                                        enter!!.setOnClickListener { MyMessage() }
                                    }

                                    @RequiresApi(Build.VERSION_CODES.M)
                                    protected fun MyMessage() {
                                        textss = messages!!.text.toString()
                                        phone = number!!.text.toString()
                                        Log.i("Send SMS", "")
                                        val smsIntent = Intent(Intent.ACTION_SENDTO)
                                        smsIntent.data = Uri.parse("smsto:")
                                        smsIntent.type = "vnd.android-dir/mms-sms"
                                        smsIntent.putExtra("address", phone)
                                        smsIntent.putExtra("sms_body", textss)

                                        val hasLocationPermission = checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                                        val hasSMSPermission = checkSelfPermission(Manifest.permission.SEND_SMS)
                                        val permissions: MutableList<String> = ArrayList()
                                        if (hasLocationPermission != PackageManager.PERMISSION_GRANTED) {
                                            permissions.add(Manifest.permission.ACCESS_FINE_LOCATION)
                                        }

                                        if (hasSMSPermission != PackageManager.PERMISSION_GRANTED) {
                                            permissions.add(Manifest.permission.SEND_SMS)
                                        }
                                        val smsManager: SmsManager = SmsManager.getDefault()
                                    //    ActivityCompat.requestPermissions(SEND_SMS);

                                        val intent = Intent(
                                            applicationContext,
                                            LetsTalk::class.java
                                        )
                                        val pi = PendingIntent.getActivity(
                                            applicationContext,
                                            0,
                                            intent,
                                            0
                                        )
                                        val TELEPHONE_SCHEMA = "tel:"
                                        val PRESERVED_CHARACTER = "+"
                                        val HK_COUNTRY_CODE = "91"
                                        val overallTelephoneUri =
                                            TELEPHONE_SCHEMA + PRESERVED_CHARACTER + HK_COUNTRY_CODE + phone


                                        startActivity(
                                            Intent(
                                                Intent.ACTION_SENDTO,
                                                Uri.fromParts("sms", overallTelephoneUri, null)
                                            )
                                        )


                                        Toast.makeText(
                                            this@LetsTalk,
                                            "SMS Sent.",
                                            Toast.LENGTH_SHORT
                                        ).show()

                                        try {
                                            startActivity(smsIntent)
                                            finish()
                                            Log.i("Sent Message", "")
                                        } catch (ex: ActivityNotFoundException) {
                                            Toast.makeText(
                                                this@LetsTalk,
                                                "SMS failed, please try again later.",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                    } //

                                    //    @Override
                                    //    public boolean onCreateOptionsMenu(Menu menu) {
                                    //        getMenuInflater().inflate(R.menu.messaging, menu);
                                    //        return true;
                                    //    }
                                    companion object {
                                        private const val MY_PERMISSIONS_REQUEST_SEND_SMS = 0
                                    }
                                }
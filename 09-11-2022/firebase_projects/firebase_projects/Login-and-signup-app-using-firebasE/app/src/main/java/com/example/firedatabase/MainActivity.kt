package com.example.firedatabase
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.firedatabase.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var db : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRigis.setOnClickListener {
            var name=binding.ed1.text.toString()
            var username=binding.ed2.text.toString()
            var password=binding.ed3.text.toString()
            if(name.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty()) {
                db = FirebaseDatabase.getInstance().getReference("Users")
                val user = Users(name, username, password)
                db.child(username).setValue(user).addOnSuccessListener {
                    var ad = AlertDialog.Builder(this)
                    ad.setTitle("Message")
                    ad.setMessage("Account registered successfully")
                    ad.setPositiveButton("Ok", null)
                    ad.show()
                    binding.ed1.text.clear()
                    binding.ed2.text.clear()
                    binding.ed3.text.clear()
                }.addOnFailureListener {
                    var ad = AlertDialog.Builder(this)
                    ad.setTitle("Message")
                    ad.setMessage("Account not register")
                    ad.setPositiveButton("Ok", null)
                    ad.show()
                }
            }else{
                Toast.makeText(this, "All fields required!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.loginLink.setOnClickListener {
            val intent=Intent(this,login_form::class.java)
            startActivity(intent)
        }
    }
}
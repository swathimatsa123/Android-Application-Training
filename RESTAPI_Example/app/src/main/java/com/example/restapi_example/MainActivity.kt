package com.example.restapi_example



import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    //Post example
    private var mSetTitle: EditText? = null
    private var mSetBody: EditText? = null
    private var mSetSal : EditText ?=null
    private var mSetAge : EditText ?=null
    private var mPostButton: Button? = null
    private var mResponse: TextView? = null
    private var mApiService: APIService? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mSetTitle = findViewById(R.id.editTextTitle)
        mSetSal = findViewById(R.id.editTextSalary)
        mSetAge = findViewById(R.id.editTextAge)

        mPostButton = findViewById(R.id.buttonPostData)
        mResponse = findViewById(R.id.textViewResponse)
        mApiService = ApiUtils.apiService
    }

    fun postData(view: View?) {
        val title = mSetTitle!!.text.toString().trim { it <= ' ' }
//        val body = mSetBody!!.text.toString().trim { it <= ' ' }
        val employeeSal = mSetSal!!.text.toString().trim{ it <= ' '}
        val empAge = mSetAge!!.text.toString().trim() {it <= ' '}
        val emp:Employee = Employee(1,"title","3000","45"," ")
        sendPost(emp)
    }

    fun sendPost(employee: Employee) {
        mApiService!!.saveData(employee)!!.enqueue(object : Callback<Employee> {
            override fun onResponse(call: Call<Employee?>, response: Response<Employee?>) {
                val gson = Gson()
                val type = object : TypeToken<Employee>() {}.type


                var errorResponse: Employee? = gson.fromJson(response.errorBody()!!.charStream(), type)

//Retriving just message
                Toast.makeText(this@MainActivity, errorResponse?.employee_name.toString(), Toast.LENGTH_SHORT).show()



                Log.d("employe name",response.body().toString())
                Log.d("employe name",response.body()!!.employee_name)
                Log.d("employe age",response.body()!!.employee_age)
                Log.d("employe salary",response.body()!!.employee_salary)

                mResponse?.setText(
                    response.body()!!.employee_name.toString() + " " + response.body()!!.employee_age
                        .toString() + " " + response.body()!!.id.toString()
                        .toString() + " " + response.body()!!.employee_salary.toString() + " "
                )
                Toast.makeText(this@MainActivity, "Post process completed\n.", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onFailure(call: Call<Employee?>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, "Unsuccessful", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
package com.example.cln62.easymanagement.ui.signup

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import com.example.cln62.easymanagement.R
import com.example.cln62.easymanagement.data.IDataManager
import com.example.cln62.easymanagement.data.pojo.SignupInfo
import com.example.cln62.easymanagement.viewmodel.AuthenticationViewModel
import kotlinx.android.synthetic.main.activity_signup.*
import org.jetbrains.anko.toast
import javax.inject.Inject
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast

class SignupActivity : AppCompatActivity(), IDataManager.OnSignupListener{

    @Inject
    internal lateinit var authenticationViewModel: AuthenticationViewModel

    lateinit var roleSelected: String

    override fun isSignuped(boolean: Boolean) {
        Log.d("signup_act_tag", boolean.toString())
        if (boolean) {
            toast("Successfully Registered")
            onBackPressed()
        } else {
            toast("Registration Failed. Please try again")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        initSpinner()

        bt_register.setOnClickListener {
            if (!this::roleSelected.isInitialized) {
                Toast.makeText(applicationContext, "Please complete sign up info", Toast.LENGTH_SHORT)
                    .show()
            }
            else {
                val signup = SignupInfo(
                    fname = et_registerFname.text.toString(),
                    lname = et_registerLname.text.toString(),
                    email = et_registerEmail.text.toString(),
                    mobile = et_registerMobile.text.toString(),
                    password = et_registerPass.text.toString(),
                    compSize = et_registerCompSize.text.toString(),
                    role = roleSelected
                )

                Log.d("SignupTag", "SignupActivity: " + signup.toString())

                authenticationViewModel.signup(this, signup)
            }
        }
    }

    private fun initSpinner()  {

        val roles = arrayOf("Select your role", "admin", "user")

        val spinnerArrayAdapter = object : ArrayAdapter<String>(
            this, android.R.layout.simple_spinner_item, roles
        ) {
            override fun isEnabled(position: Int): Boolean {
                // Disable the first item from Spinner
                // First item will be use for hint
                return position != 0
            }
        }

        val spinner: Spinner = findViewById(R.id.sp_add_employee)

        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinner.adapter = spinnerArrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                roleSelected = roles.get(position)
                // If user change the default selection
                // First item is disable and it is used for hint
                if (position > 0) {
                    // Notify the selected item text
                    Toast.makeText(applicationContext, "Selected : $roleSelected", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
}

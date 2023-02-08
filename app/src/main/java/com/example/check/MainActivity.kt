package com.example.sprawdzanie

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guzior=findViewById<Button>(R.id.SubmitButton)
        val password=findViewById<EditText>(R.id.password)
        val passwords=findViewById<EditText>(R.id.passwords)


        guzior.setOnClickListener{
            val check=findViewById<CheckBox>(R.id.takie_same)
            if(password.text.toString()!=passwords.text.toString()){
                check.isChecked=false
            }else{
                check.isChecked=true

                val check1=findViewById<CheckBox>(R.id.duzy)
                val duzalitera = Pattern.compile(".*[A-Z].*").matcher(password.text.toString()).matches() ||
                        Pattern.compile(".*[A-Z].*").matcher(passwords.text.toString()).matches()
                check1.isChecked = duzalitera

                val check2=findViewById<CheckBox>(R.id.maly)
                val malalitera = Pattern.compile(".*[a-z].*").matcher(password.text.toString()).matches() ||
                        Pattern.compile(".*[a-z].*").matcher(passwords.text.toString()).matches()
                check2.isChecked = malalitera

                val check3=findViewById<CheckBox>(R.id.liczba)
                val cyfra = Pattern.compile(".*[0-9].*").matcher(password.text.toString()).matches() ||
                        Pattern.compile(".*[0-9].*").matcher(passwords.text.toString()).matches()
                check3.isChecked = cyfra

                val check4=findViewById<CheckBox>(R.id.specjalista)
                val znakspecjalny = Pattern.compile(".*[~!@#$%^&*_+:;,.<>/?-].*").matcher(password.text.toString()).matches() ||
                        Pattern.compile(".*[~!@#$%^&*_+:;,.<>/?-].*").matcher(passwords.text.toString()).matches()
                check4.isChecked = znakspecjalny

            }
        }
    }
}
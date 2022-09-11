package com.example.clase_3_9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = findViewById<EditText>(R.id.texto1)
        val contraseña = findViewById<EditText>(R.id.texto2)
        val mensajeExito = findViewById<TextView>(R.id.texto5)
        val boton = findViewById<Button>(R.id.boton1)


        mensajeExito.visibility = View.INVISIBLE


        boton.setOnClickListener() {

            val passwordRegex = Pattern.compile(
                "^" + "(?=.*[0-9])" + "(?=.*[a-z])" + "(?=.*[A-Z])" +
                        "(?=.*[@#$%&+=])" + "(?=\\S+$)" + ".{8,}" + "$"
            )

            val posibleEmail: String = email.getText().toString();
            val posibleContraseña: String = contraseña.getText().toString()

            //Validar email

            email.setError(null)
            if ("".equals(posibleEmail)) {
                email.setError("campo vacío, introduce un Email")
                email.requestFocus()
            }else if ("".equals(posibleContraseña)){
                contraseña.setError("campo vacío, introduce contraseña")
                contraseña.requestFocus()
            } else if (!Patterns.EMAIL_ADDRESS.matcher(posibleEmail).matches()) {
                Toast.makeText(getApplicationContext(), "email invalido.", Toast.LENGTH_SHORT).show()
            }

            //validacion contraseña:

            else if (!passwordRegex.matcher(posibleContraseña).matches()) {
                Toast.makeText(getApplicationContext(), "contraseña invalida", Toast.LENGTH_SHORT).show()
            } else {
                mensajeExito.visibility = View.VISIBLE
            }
        }
    }
        }








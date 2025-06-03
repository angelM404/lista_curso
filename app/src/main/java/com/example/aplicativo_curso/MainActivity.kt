package com.example.aplicativo_curso

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var editText1: EditText
    lateinit var editText2: EditText
    lateinit var editText3: EditText
    lateinit var editText4: EditText
    lateinit var salvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        editText1 = findViewById(R.id.editTextText)
        editText2 = findViewById(R.id.editTextText2)
        editText3 = findViewById(R.id.editTextText3)
        editText4 = findViewById(R.id.editTextText4)

        salvar = findViewById(R.id.button)

        salvar.setOnClickListener {
            println("Informações salvas!")
        }

        val fechar = findViewById<Button>(R.id.button3)

        fechar.setOnClickListener {
            finishAffinity()
        //ao invés do finish pq assim assim finaliza mesmo se tiver atividades abertas
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun limparCampos(view: View) {
        editText1.setText(" ")
        editText2.setText(" ")
        editText3.setText(" ")
        editText4.setText(" ")
    }
}
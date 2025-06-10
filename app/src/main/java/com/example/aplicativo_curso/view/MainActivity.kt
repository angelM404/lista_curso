package com.example.aplicativo_curso.view

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.example.aplicativo_curso.R

class MainActivity : AppCompatActivity() {

    lateinit var editText1: EditText
    lateinit var editText2: EditText
    lateinit var editText4: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val languages = resources.getStringArray(R.array.Languages)

        val spinner = findViewById<Spinner>(R.id.spinner)

        if (spinner != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    Toast.makeText(this@MainActivity, getString(R.string.app_name) + " " + "" + languages[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                }
            }
        }

        editText1 = findViewById(R.id.nome)
        editText2 = findViewById(R.id.sobrenome)
        editText4 = findViewById(R.id.telefone)

        val fechar = findViewById<Button>(R.id.botao_finalizar)

        fechar.setOnClickListener {
            finishAffinity()
        //ao invés do finish pq assim assim finaliza mesmo se tiver atividades abertas
        }

        val salvar = findViewById<Button>(R.id.botao_salvar)

        salvar.setOnClickListener{
            Toast.makeText(this, "Informações salvas!", Toast.LENGTH_SHORT).show()
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
        editText4.setText(" ")
    }



}
package com.example.pdm1_aula05_exercicio_questao1

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.widget.EditText

class MainActivity : ComponentActivity() {
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editTextNome)

        // Restaurar o estado do EditText, se houver
        savedInstanceState?.let {
            val textoSalvo = it.getString("nome")
            editText.setText(textoSalvo)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Salvar o conteúdo do EditText antes da Activity ser destruída
        outState.putString("nome", editText.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Recuperar o conteúdo salvo e colocar no EditText
        val textoSalvo = savedInstanceState.getString("nome")
        editText.setText(textoSalvo)
    }
}
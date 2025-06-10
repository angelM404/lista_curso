package com.example.aplicativo_curso.model

class Pessoa (val primeiro_nome: String, val sobrenome: String, val curso: String, val telefone: String){
    override fun toString(): String {
        return " $primeiro_nome $sobrenome, Curso: $curso, Contato: $telefone"
    }
}
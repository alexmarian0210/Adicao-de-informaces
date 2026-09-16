package com.example.jsonex.jsonexemplo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Informa que esta classe representa uma entidade persistida no banco.
@Entity
// Define o nome da tabela.
@Table(name = "alunos")
public class Aluno {
    // Chave primária da tabela.
    @Id
    // O banco será responsável por gerar o ID.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String curso;
    private String email;
    private String matricula;

    // Construtor vazio exigido pela JPA.
    public Aluno() {
    }

    // Podemos criar alunos sem informar o ID,
    // porque o banco irá gerar esse valor.
    public Aluno(String nome, int idade, String curso, String email, String matricula) {
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
        this.email = email;
        this.matricula = matricula;
    }

    // GETTERS
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCurso() {
        return curso;
    }

    public String getEmail() {
        return email;
    }

    public String getMatricula() {
        return matricula;
    }

    // SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
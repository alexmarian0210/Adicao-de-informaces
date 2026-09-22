    package com.example.jsonex.jsonexemplo.model;

    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.Table;

    // Informa que esta classe representa uma entidade persistida no banco.
    @Entity
    // Define o nome da tabela.
    @Table(name = "bombeiros")
    public class Bombeiros{
        // Chave primária da tabela.
        @Id
        // O banco será responsável por gerar o ID.
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String nome;
        private String cargo;
        private String cpf ;
        private String telefone;
        

        // Construtor vazio exigido pela JPA.
        public Bombeiros() {
        }

        // Podemos criar alunos sem informar o ID,
        // porque o banco irá gerar esse valor.
        public Bombeiros(int id,String nome, String cargo, String cpf, String telefone) {
            this.id = id;
            this.nome = nome;
            this.cargo = cargo;
            this.cpf = cpf;
            this.telefone = telefone;
            
        }

        // GETTERS
        public int getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public String getCargo() {
            return cargo;
        }

        public String getCpf() {
            return cpf;
        }

        public String getTelefone() {
            return telefone;
        }

        // SETTERS
        public void setId(int id) {
            this.id = id;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }
    }

package com.github.augustocaixeta.objeto;

public class Pessoa {
    private int id;
    private String nome;
    private String CPF;
    private String email;
    private String contato;

    public Pessoa(String nome, String CPF, String email, String contato) {
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
        this.contato = contato;
    }

    public Pessoa(int id, String nome, String CPF, String email, String contato) {
        this.id = id;
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
        this.contato = contato;
    }

    public Pessoa() {
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return nome + " (" + id + ")";
    }
}

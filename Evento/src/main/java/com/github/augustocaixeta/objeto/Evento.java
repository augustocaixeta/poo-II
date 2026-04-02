package com.github.augustocaixeta.objeto;

import java.time.LocalDate;

public class Evento {
    private int id;
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataTermino;

    public Evento(int id, String nome, LocalDate dataInicio, LocalDate dataTermino) {
        this.id = id;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
    }
    
    public Evento(String nome, LocalDate dataInicio, LocalDate dataTermino) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
    }
    
    public Evento() {
        
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

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }
}

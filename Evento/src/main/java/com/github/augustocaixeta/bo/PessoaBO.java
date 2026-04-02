package com.github.augustocaixeta.bo;

import com.github.augustocaixeta.dao.PessoaDAO;
import com.github.augustocaixeta.objeto.Pessoa;

import java.util.List;

public class PessoaBO {
    PessoaDAO pessoaDAO;
    
    public PessoaBO() {
        pessoaDAO = new PessoaDAO();
    }
    
    public Pessoa salvar(Pessoa pessoa) {
        return pessoaDAO.salvar(pessoa);
    }
    
    public Pessoa editar(Pessoa pessoa) {
        return pessoaDAO.editar(pessoa);
    }
    
    public int excluir(Pessoa pessoa) {
        return pessoaDAO.excluir(pessoa);
    }
    
    public List<Pessoa> consultarPessoas() {
        return pessoaDAO.consultarPessoas();
    }
    
    public List<Pessoa> consultarPessoas(String nome) {
        return pessoaDAO.consultarPessoas(nome);
    }
}

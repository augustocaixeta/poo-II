package com.github.augustocaixeta.bo;

import com.github.augustocaixeta.dao.PessoaDAO;
import com.github.augustocaixeta.objetos.Pessoa;
import java.util.List;

public class PessoaBO {
    PessoaDAO pessoaDAO;
    
    public PessoaBO() {
        pessoaDAO = new PessoaDAO();
    }
    
    public Pessoa salvar(Pessoa pessoa) {
        return pessoaDAO.salvar(pessoa);
    }
    
    public void editar(Pessoa pessoa) {
        pessoaDAO.editar(pessoa);
    }
    
    public int excluir(Pessoa pessoa) {
        return pessoaDAO.excluir(pessoa);
    }
    
    public List<Pessoa> getPessoas() {
        return pessoaDAO.getPessoas();
    }
    
    public Pessoa getPessoas(int pessoaId) {
        return pessoaDAO.getPessoas(pessoaId);
    }
    
    public List<Pessoa> getPessoas(String nome) {
        return pessoaDAO.getPessoas(nome);
    }
    
    public List<Pessoa> getPessoas(String dataInicio, String dataFinal) {
        return pessoaDAO.getPessoas(dataInicio, dataFinal);
    }
    
    public List<Pessoa> getPessoas(String nome, String dataInicio, String dataFinal) {
        return pessoaDAO.getPessoas(nome, dataInicio, dataFinal);
    }
}

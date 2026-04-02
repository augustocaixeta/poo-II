package com.aacs.bo;

import com.aacs.dao.FuncionarioDAO;
import com.aacs.modelos.Departamento;
import com.aacs.modelos.Funcionario;

import java.util.List;

public class FuncionarioBO {
    private FuncionarioDAO dao;
    
    public FuncionarioBO() {
        dao = new FuncionarioDAO();
    }
    
    public Funcionario salvar(Funcionario funcionario) {
        return dao.salvar(funcionario);
    }
    
    public int excluir(Funcionario funcionario) {
        return dao.excluir(funcionario);
    }
    
    public List<Funcionario> buscarFuncionarios(Departamento departamento) {
        return dao.buscarFuncionarios(departamento);
    }
}

package com.aacs.bo;

import com.aacs.dao.DepartamentoDAO;
import com.aacs.modelos.Departamento;

import java.util.List;

public class DepartamentoBO {
    private DepartamentoDAO dao;
    
    public DepartamentoBO() {
        dao = new DepartamentoDAO();
    }
    
    public List<Departamento> buscarDepartamentos(String nome) {
        return dao.buscarDepartamentos(nome);
    }
}

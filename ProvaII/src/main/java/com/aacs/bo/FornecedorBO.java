package com.aacs.bo;

import com.aacs.connection_factory.ConexaoFornecedorFactory;
import com.aacs.dao.FornecedorDAO;

public class FornecedorBO {
    private final FornecedorDAO dao;
    
    public FornecedorBO() {
        dao = new FornecedorDAO(new ConexaoFornecedorFactory());
    }
    
    public void salvarEmMySQL(int id, String nome, String cnpj) {
        dao.salvarEmMySQL(id, nome, cnpj);
    }
    
    public void salvarEmPostgres(int id, String nome, String cnpj) {
        dao.salvarEmPostgres(id, nome, cnpj);
    }
}

package com.aacs.bo;

import com.aacs.connection_factory.ConexaoClienteFactory;
import com.aacs.dao.ClienteDAO;

public class ClienteBO {
    private final ClienteDAO dao;
    
    public ClienteBO() {
        dao = new ClienteDAO(new ConexaoClienteFactory());
    }
    
    public void salvarEmMySQL(int id, String nome, String cpf) {
        dao.salvarEmMySQL(id, nome, cpf);
    }
    
    public void salvarEmPostgres(int id, String nome, String cpf) {
        dao.salvarEmPostgres(id, nome, cpf);
    }
}

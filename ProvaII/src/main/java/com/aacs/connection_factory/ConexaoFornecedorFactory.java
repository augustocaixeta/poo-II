package com.aacs.connection_factory;

import java.sql.Connection;

public class ConexaoFornecedorFactory {
    public Connection getMysqlConnection() {
        return new BD_MySQL_Fornecedor().getConnection();
    }

    public Connection getPgConnection() {
        return new BD_Postgre_Fornecedor().getConnection();
    }
}

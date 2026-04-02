package com.aacs.connection_factory;

import java.sql.Connection;

public class BD_Postgre_Fornecedor {
    private final Connection connection;
    
    public BD_Postgre_Fornecedor() {
        connection = new ConexaoPostgre().abrir();
    }

    public Connection getConnection() {
        return connection;
    }
}

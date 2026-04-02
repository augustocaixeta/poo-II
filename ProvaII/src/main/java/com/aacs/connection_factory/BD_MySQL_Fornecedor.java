package com.aacs.connection_factory;

import java.sql.Connection;

public class BD_MySQL_Fornecedor {
    private final Connection connection;
    
    public BD_MySQL_Fornecedor() {
        connection = new ConexaoMySQL().abrir();
    }

    public Connection getConnection() {
        return connection;
    }
}

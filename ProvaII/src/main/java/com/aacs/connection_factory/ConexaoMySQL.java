package com.aacs.connection_factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL implements ConexaoBDFactory {
    private final String url = "jdbc:mysql://localhost:3307/poo_prova_ii_my";
    private final String usuario = "root";      
    private final String senha = "vertrigo";
    
    @Override
    public Connection abrir() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

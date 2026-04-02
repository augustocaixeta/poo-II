package com.aacs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    final private String driver = "org.postgresql.Driver";
    final private String url = "jdbc:postgresql://localhost:5432/dept";
    final private String usuario = "postgres";
    final private String senha = "postgres";
    
    public Connection conectar() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException ex){
            ex.printStackTrace();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
}

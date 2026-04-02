package com.aacs.connection_factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoPostgre implements ConexaoBDFactory {
    final private String driver = "org.postgresql.Driver";
    final private String url = "jdbc:postgresql://localhost:5432/poo_prova_ii_pg";
    final private String usuario = "postgres";
    final private String senha = "postgres";
    
    @Override
    public Connection abrir(){
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

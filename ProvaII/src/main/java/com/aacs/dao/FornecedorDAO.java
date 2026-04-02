package com.aacs.dao;

import com.aacs.connection_factory.ConexaoFornecedorFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FornecedorDAO {
    private final ConexaoFornecedorFactory factory;
    
    public FornecedorDAO(ConexaoFornecedorFactory factory) {
        this.factory = factory;
    }
    
    public void salvarEmMySQL(int id, String nome, String cnpj) {
        try (PreparedStatement ps = factory.getMysqlConnection().prepareStatement("INSERT INTO fornecedores(id, nome, cnpj) VALUES (?, ?, ?);")) {
            ps.setInt(1, id);
            ps.setString(2, nome);
            ps.setString(3, cnpj);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void salvarEmPostgres(int id, String nome, String cnpj) {
        try (PreparedStatement ps = factory.getPgConnection().prepareStatement("INSERT INTO fornecedores(id, nome, cnpj) VALUES (?, ?, ?);")) {
            ps.setInt(1, id);
            ps.setString(2, nome);
            ps.setString(3, cnpj);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

package com.aacs.dao;

import com.aacs.connection_factory.ConexaoClienteFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
    private final ConexaoClienteFactory factory;
    
    public ClienteDAO(ConexaoClienteFactory factory) {
        this.factory = factory;
    }
    
    public void salvarEmMySQL(int id, String nome, String cpf) {
        try (PreparedStatement ps = factory.getMysqlConnection().prepareStatement("INSERT INTO clientes(id, nome, cpf) VALUES (?, ?, ?);")) {
            ps.setInt(1, id);
            ps.setString(2, nome);
            ps.setString(3, cpf);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void salvarEmPostgres(int id, String nome, String cpf) {
        try (PreparedStatement ps = factory.getPgConnection().prepareStatement("INSERT INTO clientes(id, nome, cpf) VALUES (?, ?, ?);")) {
            ps.setInt(1, id);
            ps.setString(2, nome);
            ps.setString(3, cpf);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

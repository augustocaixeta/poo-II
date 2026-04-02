package com.aacs.dao;

import com.aacs.modelos.Departamento;
import com.aacs.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO {
    Connection con;
    
    public DepartamentoDAO() {
        con = new Conexao().conectar();
    }
    
    public List<Departamento> buscarDepartamentos(String nome) {
        List<Departamento> departamentos = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM dept WHERE nome ILIKE ?;")) {
            ps.setString(1, nome + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Departamento dept = new Departamento();
                dept.setId(rs.getInt("id"));
                dept.setNome(rs.getString("nome"));
                departamentos.add(dept);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return departamentos;
    }
}

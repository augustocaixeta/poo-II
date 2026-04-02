package com.aacs.dao;

import com.aacs.modelos.Departamento;
import com.aacs.modelos.Funcionario;
import com.aacs.util.Conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    Connection con;
    
    public FuncionarioDAO() {
        con = new Conexao().conectar();
    }
    
    public Funcionario salvar(Funcionario funcionario) {
        try (PreparedStatement ps = con.prepareStatement("INSERT INTO func(id_dept, nome, nascimento, salario) VALUES (?, ?, ?, ?);")) {
            ps.setInt(1, funcionario.getDepartamento().getId());
            ps.setString(2, funcionario.getNome());
            ps.setDate(3, Date.valueOf(funcionario.getNascimento()));
            ps.setDouble(4, funcionario.getSalario());
            
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    funcionario.setId(rs.getInt("id"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return funcionario;
    }
    
    public int excluir(Funcionario funcionario) {
        int sucesso = 0;
        try (PreparedStatement ps = con.prepareStatement("DELETE FROM func WHERE id = ?;")) {
            ps.setInt(1, funcionario.getId());
            sucesso = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sucesso;
    }
    
    public List<Funcionario> buscarFuncionarios(Departamento dept) {
        List<Funcionario> funcionarios = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM func WHERE id_dept = ?;")) {
            ps.setInt(1, dept.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setNascimento(rs.getDate("nascimento").toLocalDate());
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setDepartamento(dept);
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return funcionarios;
    }
}

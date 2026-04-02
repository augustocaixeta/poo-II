package com.github.augustocaixeta.dao;

import com.github.augustocaixeta.objeto.Pessoa;
import com.github.augustocaixeta.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    Connection con;
    
    public PessoaDAO() {
        con = new Conexao().conexao();
    }
    
    public Pessoa salvar(Pessoa pessoa) {
        try (PreparedStatement ps = con.prepareStatement("INSERT INTO pessoa(nome, cpf, email, contato) VALUES (?, ?, ?, ?);")) {
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getCPF());
            ps.setString(3, pessoa.getEmail());
            ps.setString(4, pessoa.getContato());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pessoa.setId(rs.getInt("id"));
            } else {
                pessoa.setId(-1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pessoa;
    }
    
    public Pessoa editar(Pessoa pessoa) {
        try (PreparedStatement ps = con.prepareStatement("UPDATE pessoa SET nome = ?, cpf = ?, contato = ?, email = ? WHERE id = ?;")) {
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getCPF());
            ps.setString(3, pessoa.getContato());
            ps.setString(4, pessoa.getEmail());
            ps.setInt(5, pessoa.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pessoa;
    }
    
    public int excluir(Pessoa pessoa) {
        int sucesso = 0;
        try (PreparedStatement ps = con.prepareStatement("DELETE FROM pessoa WHERE id = ?;")) {
            ps.setInt(1, pessoa.getId());
            sucesso = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sucesso;
    }
    
    public List<Pessoa> consultarPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM pessoa;")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pessoas.add(getPessoaResultSet(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pessoas;
    }
    
    public List<Pessoa> consultarPessoas(String nome) {
        List<Pessoa> pessoas = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM pessoa WHERE nome ILIKE ?;")) {
            ps.setString(1, nome + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pessoas.add(getPessoaResultSet(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pessoas;
    }
    
    public Pessoa getPessoaResultSet(ResultSet rs) throws SQLException {
        Pessoa pessoa = new Pessoa(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getString("email"),
                rs.getString("contato")
        );
        return pessoa;
    }
}

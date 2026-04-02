package com.github.augustocaixeta.dao;

import com.github.augustocaixeta.objetos.Pessoa;
import com.github.augustocaixeta.util.Conexao;
import com.github.augustocaixeta.util.ManipulaData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    Connection con;
    ManipulaData md;
    
    public PessoaDAO() {
        con = new Conexao().conectar();
        md = new ManipulaData();
    }
    
    public Pessoa salvar(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa(nome, data_nascimento) VALUES (?, ?);";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, pessoa.getNome());
            ps.setDate(2, md.parseStringToDate(pessoa.getDataNascimento()));
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pessoa.setId(rs.getInt(1));
            } else {
                pessoa.setId(-1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return pessoa;
    }
    
    public void editar(Pessoa pessoa) {
        try (PreparedStatement ps = con.prepareStatement("UPDATE pessoa SET nome = ?, data_nascimento = ? WHERE id = ?;")) {
            ps.setString(1, pessoa.getNome());
            ps.setDate(2, md.parseStringToDate(pessoa.getDataNascimento()));
            ps.setInt(3, pessoa.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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
    
    public List<Pessoa> getPessoas() {
        List<Pessoa> listaPessoas = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM pessoa;")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaPessoas.add(getPessoa(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaPessoas;
    }
    
    public Pessoa getPessoas(int pessoaId) {
        Pessoa pessoa = new Pessoa();
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM pessoa WHERE id = ?;",
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            ps.setInt(1, pessoaId);
            ResultSet rs = ps.executeQuery();
            rs.first();
            pessoa = getPessoa(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pessoa;
    }

    public List<Pessoa> getPessoas(String nome) {
        List<Pessoa> listaPessoas = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM pessoa WHERE nome ILIKE ?;")) {
            ps.setString(1, nome + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaPessoas.add(getPessoa(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaPessoas;
    }

    public List<Pessoa> getPessoas(String dataInicio, String dataFinal) {
        List<Pessoa> listaPessoas = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM pessoa WHERE data_nascimento BETWEEN ? AND ?;")) {
            ps.setString(1, md.parseDateToString(dataInicio));
            ps.setString(2, md.parseDateToString(dataFinal));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaPessoas.add(getPessoa(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaPessoas;
    }

    public List<Pessoa> getPessoas(String nome, String dataInicio, String dataFinal) {
        List<Pessoa> listaPessoas = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM pessoa WHERE nome ILIKE ? AND data_nascimento BETWEEN ? AND ?;")) {
            ps.setString(1, nome + "%");
            ps.setString(2, md.parseDateToString(dataInicio));
            ps.setString(3, md.parseDateToString(dataFinal));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaPessoas.add(getPessoa(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaPessoas;
    }
    
    public Pessoa getPessoa(ResultSet rs) throws SQLException {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(rs.getInt("id"));
        pessoa.setNome(rs.getString("nome"));
        pessoa.setDataNascimento(md.parseDateToString(rs.getString("data_nascimento")));
        return pessoa;
    }
}

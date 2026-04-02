package com.github.augustocaixeta.dao;

import com.github.augustocaixeta.objetos.Pet;
import com.github.augustocaixeta.util.Conexao;
import com.github.augustocaixeta.util.ManipulaData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class PetDAO {
    Connection con;
    ManipulaData md;
    PessoaDAO pessoaDAO;
    
    public PetDAO() {
        con = new Conexao().conectar();
        md = new ManipulaData();
        pessoaDAO = new PessoaDAO();
    }
    
    public Pet salvar(Pet pet) {
        String sql = "INSERT INTO pet(nome, data_nascimento, raca, cor, porte, pessoa_id) VALUES (?, ?, ?, ?, ?, ?);";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, pet.getNome());
            ps.setDate(2, md.parseStringToDate(pet.getDataNascimento()));
            ps.setString(3, pet.getRaca());
            ps.setString(4, pet.getCor());
            ps.setString(5, pet.getPorte());
            ps.setInt(6, pet.getPessoa().getId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pet.setId(rs.getInt(1));
            } else {
                pet.setId(-1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return pet;
    }
    
    public void editar(Pet pet) {
        try (PreparedStatement ps = con.prepareStatement("UPDATE pet SET nome = ?, data_nascimento = ?, raca = ?, cor = ?, porte = ?, pessoa_id = ? WHERE id = ?;")) {
            ps.setString(1, pet.getNome());
            ps.setDate(2, md.parseStringToDate(pet.getDataNascimento()));
            ps.setString(3, pet.getRaca());
            ps.setString(4, pet.getCor());
            ps.setString(5, pet.getPorte());
            ps.setInt(6, pet.getPessoa().getId());
            ps.setInt(7, pet.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public int excluir(Pet pet) {
        int sucesso = 0;
        try (PreparedStatement ps = con.prepareStatement("DELETE FROM pet WHERE id = ?;")) {
            ps.setInt(1, pet.getId());
            sucesso = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sucesso;
    }
    
    public List<Pet> getPets() {
        List<Pet> listaPets = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM pet;")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaPets.add(getPet(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaPets;
    }
    
    public Pet getPets(int petId) {
        Pet pet = new Pet();
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM pet WHERE id = ?;")) {
            ps.setInt(1, petId);
            ResultSet rs = ps.executeQuery();
            rs.first();
            pet = getPet(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pet;
    }
    
    public List<Pet> getPets(String nome) {
        List<Pet> listaPets = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM pet WHERE nome ILIKE ?;")) {
            ps.setString(1, nome + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaPets.add(getPet(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaPets;
    }
    
    public List<Pet> getPets(String dataInicio, String dataFinal) {
        List<Pet> listaPets = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM pet WHERE data_nascimento BETWEEN ? AND ?;")) {
            ps.setString(1, md.parseDateToString(dataInicio));
            ps.setString(2, md.parseDateToString(dataFinal));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaPets.add(getPet(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaPets;
    }
    
    public List<Pet> getPets(String nome, String dataInicio, String dataFinal) {
        List<Pet> listaPets = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM pet WHERE nome ILIKE ? AND data_nascimento BETWEEN ? AND ?;")) {
            ps.setString(1, nome + "%");
            ps.setString(2, md.parseDateToString(dataInicio));
            ps.setString(3, md.parseDateToString(dataFinal));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaPets.add(getPet(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaPets;
    }
    
    public Pet getPet(ResultSet rs) throws SQLException {
        Pet pet = new Pet();
        pet.setId(rs.getInt("id"));
        pet.setNome(rs.getString("nome"));
        pet.setDataNascimento(md.parseDateToString(rs.getString("data_nascimento")));
        pet.setRaca(rs.getString("raca"));
        pet.setCor(rs.getString("cor"));
        pet.setPorte(rs.getString("porte"));
        pet.setPessoa(pessoaDAO.getPessoas(rs.getInt("pessoa_id")));
        return pet;
    }
}

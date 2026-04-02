package com.github.augustocaixeta.dao;

import com.github.augustocaixeta.objeto.Evento;
import com.github.augustocaixeta.objeto.Participante;
import com.github.augustocaixeta.objeto.Pessoa;
import com.github.augustocaixeta.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class ParticipanteDAO {
    private final Connection con;
    
    public ParticipanteDAO() {
        con = new Conexao().conexao();
    }
    
    public Participante vincular(Participante participante) {
        try (PreparedStatement ps = con.prepareStatement("INSERT INTO participante(id_evento, id_pessoa) VALUES (?, ?);")) {
            ps.setInt(1, participante.getEvento().getId());
            ps.setInt(2, participante.getPessoa().getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return participante;
    }
    
    public List<Participante> consultarParticipantes() {
        List<Participante> participantes = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement("" +
              "SELECT " +
                "    prt.*, " +
                "    e.nome AS evento_nome, e.data_inicio, e.data_termino, " +
                "    p.nome AS pessoa_nome, p.cpf, p.email, p.contato " +
                "FROM participante AS prt " +
                "JOIN pessoa AS p ON prt.id_pessoa = p.id " +
                "JOIN evento AS e ON prt.id_evento = e.id;")) {
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Participante participante = new Participante();
                participante.setEvento(new Evento(
                        rs.getInt("id_evento"),
                        rs.getString("evento_nome"),
                        rs.getDate("data_inicio").toLocalDate(),
                        rs.getDate("data_termino").toLocalDate()
                ));
                participante.setPessoa(new Pessoa(
                        rs.getInt("id_pessoa"),
                        rs.getString("pessoa_nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("contato")
                ));
                participantes.add(participante);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return participantes;
    }
    
    public List<Pessoa> consultarParticipantes(String eventoNome) {
        List<Pessoa> pessoas = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement("SELECT p.* FROM participante AS prt " +
            "JOIN pessoa AS p ON prt.id_pessoa = p.id " +
            "JOIN evento AS e ON prt.id_evento = e.id " +
            "WHERE e.nome = ? " +
            "ORDER BY p.nome;")) {
            ps.setString(1, eventoNome);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Pessoa pessoa = new Pessoa(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("contato")
                );
                pessoas.add(pessoa);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pessoas;
    }
}

package com.github.augustocaixeta.dao;

import com.github.augustocaixeta.objeto.Evento;
import com.github.augustocaixeta.util.Conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventoDAO {
    Connection con;
    
    public EventoDAO() {
        con = new Conexao().conexao();
    }
    
    public Evento salvar(Evento evento) {
        try (PreparedStatement ps = con.prepareStatement("INSERT INTO evento(nome, data_inicio, data_termino) VALUES (?, ?, ?);")) {
            ps.setString(1, evento.getNome());
            ps.setDate(2, Date.valueOf(evento.getDataInicio()));
            ps.setDate(3, Date.valueOf(evento.getDataTermino()));
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                evento.setId(rs.getInt("id"));
            } else {
                evento.setId(-1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return evento;
    }
    
    public Evento editar(Evento evento) {
        try (PreparedStatement ps = con.prepareStatement("UPDATE evento SET nome = ?, data_inicio = ?, data_termino = ? WHERE id = ?;")) {
            ps.setString(1, evento.getNome());
            ps.setDate(2, Date.valueOf(evento.getDataInicio()));
            ps.setDate(3, Date.valueOf(evento.getDataTermino()));
            ps.setInt(4, evento.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return evento;
    }
    
    public int excluir(Evento evento) {
        int sucesso = 0;
        try (PreparedStatement ps = con.prepareStatement("DELETE FROM evento WHERE id = ?;")) {
            ps.setInt(1, evento.getId());
            sucesso = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sucesso;
    }
    
    public List<Evento> consultarEventos() {
        List<Evento> eventos = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM evento;")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Evento evento = new Evento(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDate("data_inicio").toLocalDate(),
                        rs.getDate("data_termino").toLocalDate()
                );
                eventos.add(evento);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return eventos;
    }
    
    public List<Evento> consultarEventos(String nome) {
        List<Evento> eventos = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM evento WHERE nome ILIKE ?;")) {
            ps.setString(1, nome + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Evento evento = new Evento(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDate("data_inicio").toLocalDate(),
                        rs.getDate("data_termino").toLocalDate()
                );
                eventos.add(evento);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return eventos;
    }
}

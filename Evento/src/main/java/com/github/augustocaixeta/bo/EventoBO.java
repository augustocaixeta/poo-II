package com.github.augustocaixeta.bo;

import com.github.augustocaixeta.dao.EventoDAO;
import com.github.augustocaixeta.objeto.Evento;
import java.util.List;

public class EventoBO {
    EventoDAO eventoDAO;
    
    public EventoBO() {
        eventoDAO = new EventoDAO();
    }
    
    public Evento salvar(Evento evento) {
        return eventoDAO.salvar(evento);
    }
    
    public Evento editar(Evento evento) {
        return eventoDAO.editar(evento);
    }
    
    public int excluir(Evento evento) {
        return eventoDAO.excluir(evento);
    }
    
    public List<Evento> consultarEventos() {
        return eventoDAO.consultarEventos();
    }
    
    public List<Evento> consultarEventos(String nome) {
        return eventoDAO.consultarEventos(nome);
    }
}

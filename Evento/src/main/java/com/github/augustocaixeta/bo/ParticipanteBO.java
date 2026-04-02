package com.github.augustocaixeta.bo;

import com.github.augustocaixeta.dao.ParticipanteDAO;
import com.github.augustocaixeta.objeto.Participante;
import com.github.augustocaixeta.objeto.Pessoa;

import java.util.List;

public class ParticipanteBO {
    ParticipanteDAO participanteDAO;
    
    public ParticipanteBO() {
        participanteDAO = new ParticipanteDAO();
    }
    
    public Participante vincularParticipante(Participante participante) {
        return participanteDAO.vincular(participante);
    }
    
    public List<Participante> consultarParticipantes() {
        return participanteDAO.consultarParticipantes();
    }
    
    public List<Pessoa> consultarParticipantes(String eventoNome) {
        return participanteDAO.consultarParticipantes(eventoNome);
    }
}

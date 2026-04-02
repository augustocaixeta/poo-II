package com.github.augustocaixeta.bo;

import com.github.augustocaixeta.dao.PetDAO;
import com.github.augustocaixeta.objetos.Pet;
import java.util.List;

public class PetBO {
    private PetDAO petDAO;
    
    public PetBO() {
        petDAO = new PetDAO();
    }
    
    public Pet salvar(Pet pet) {
        return petDAO.salvar(pet);
    }
    
    public void editar(Pet pet) {
        petDAO.editar(pet);
    }
    
    public int excluir(Pet pet) {
        return petDAO.excluir(pet);
    }
    
    public List<Pet> getPets() {
        return petDAO.getPets();
    }
    
    public Pet getPets(int petId) {
        return petDAO.getPets(petId);
    }
    
    public List<Pet> getPets(String nome) {
        return petDAO.getPets(nome);
    }
    
    public List<Pet> getPets(String dataInicio, String dataFinal) {
        return petDAO.getPets(dataInicio, dataFinal);
    }
    
    public List<Pet> getPets(String nome, String dataInicio, String dataFinal) {
        return petDAO.getPets(nome, dataInicio, dataFinal);
    }
}

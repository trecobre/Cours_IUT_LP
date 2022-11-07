package fr.gouv.edu.iut.manager.service;

import fr.gouv.edu.iut.manager.entity.Departement;
import java.util.List;

public interface DepartementService {

    /**
     * Recuperation de tous les departements contenus dans l'EIS.
     *
     * @return la liste des departements.
     */
    List<Departement> getAllDepartements();

    /**
     * Recuperation d'un departement contenu dans l'EIS, a partir de l'id du departement.
     *
     * @param departementId l'id du departement.
     * @return le departement avec sa liste d'etudiants
     */
    Departement getDepartement(long departementId);
    
    Departement synchronizeDepartement(Departement departement);
    
    void deleteDepartement(Long id);
}

/**
 *
 */
package fr.gouv.edu.iut.manager.service;

import fr.gouv.edu.iut.manager.entity.Etudiant;
import java.util.List;

/**
 * @author vgilles
 *
 */
public interface EtudiantService {

    /**
     * Recuperation de tous les etudiants contenus dans l'EIS.
     *
     * @return la liste des etudiants.
     */
    List<Etudiant> getAllEtudiants();
}

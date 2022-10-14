/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.gouv.edu.iut.manager.web.resource;

import fr.gouv.edu.iut.manager.service.EtudiantService;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author vince
 */
@Path("etudiants")
public class EtudiantResource {

    /**
     * Le etudiant service.
     */
    @EJB
    private EtudiantService etudiantService;

    @GET
    public List<EtudiantDocument> list() {
        return this.etudiantService.getAllEtudiants().stream().map(EtudiantDocument::new).collect(Collectors.toList());
    }
}

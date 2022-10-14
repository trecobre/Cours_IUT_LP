/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.gouv.edu.iut.manager.web.resource;

import fr.gouv.edu.iut.manager.service.DepartementService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author vince
 */
@Path("departements")
public class DepartementResource {

    /**
     * Le departement service.
     */
    @EJB
    private DepartementService departementService;

    @GET
    public List<DepartementDocument> list() {
        return this.departementService.getAllDepartements().stream().map(DepartementDocument::new).collect(Collectors.toList());
    }

    @GET
    @Path("{id}")
    public Optional<DepartementDocument> get(final @PathParam("id") long id) {
        return Optional.ofNullable(this.departementService.getDepartement(id)).map(DepartementDocument::new);
    }

    @GET
    @Path("{id}/etudiants")
    public Optional<List<EtudiantDocument>> listEtudiants(final @PathParam("id") long id) {
        return Optional.ofNullable(
                this.departementService.getDepartement(id)
        ).map(
                departement -> departement.getEtudiants().stream().map(EtudiantDocument::new ).collect(Collectors.toList())
        );
    }
}

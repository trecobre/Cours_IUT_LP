/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.gouv.edu.iut.manager.web.resource;

import fr.gouv.edu.iut.manager.entity.Etudiant;
import java.util.Optional;

/**
 *
 * @author vince
 */
public final class EtudiantDocument {

    private final Etudiant delegate;

    public EtudiantDocument(final Etudiant delegate) {
        this.delegate = delegate;
    }

    public Long getId() {
        return delegate.getId();
    }

    public String getAdresse() {
        return delegate.getAdresse();
    }

    public String getNom() {
        return delegate.getNom();
    }

    public String getPrenom() {
        return delegate.getPrenom();
    }

    public Optional<DepartementDocument> getDepartement() {
        return Optional.ofNullable(delegate.getDepartement()).map(DepartementDocument::new);
    }
}

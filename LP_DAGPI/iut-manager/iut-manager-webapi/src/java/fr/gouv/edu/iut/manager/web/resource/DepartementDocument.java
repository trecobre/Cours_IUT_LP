/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.gouv.edu.iut.manager.web.resource;

import fr.gouv.edu.iut.manager.entity.Departement;

/**
 *
 * @author vince
 */
public final class DepartementDocument {

    private final Departement delegate;

    public DepartementDocument(final Departement delegate) {
        this.delegate = delegate;
    }

    public Long getId() {
        return delegate.getId();
    }

    public String getAdresse() {
        return delegate.getAdresse();
    }

    public String getDescription() {
        return delegate.getDescription();
    }

    public String getNom() {
        return delegate.getNom();
    }
}

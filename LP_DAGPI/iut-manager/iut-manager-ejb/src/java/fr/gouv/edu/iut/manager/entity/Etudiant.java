/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.gouv.edu.iut.manager.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

/**
 *
 * @author vince
 */
@Entity
@Table(name = "ETUDIANT")
@NamedNativeQuery(name = "update", query = "update ETUDIANT set etu_dpt_id = ? where etu_dpt_id = ?")
public class Etudiant implements Serializable {
    
    public static void updateDepartement(EntityManager em, Long oldID, Long newId){
        em.createNamedQuery("update").setParameter(1, newId).setParameter(2, oldID).executeUpdate();
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ETU_ID", unique = true, nullable = false)
    private Long id;
    @Column(name = "ETU_ADRESSE", nullable = false, length = 255)
    private String adresse;
    @Column(name = "ETU_NOM", nullable = false, length = 255)
    private String nom;
    @Column(name = "ETU_PRENOM", nullable = false, length = 255)
    private String prenom;
    // bi-directional many-to-one association to Departement
    @ManyToOne
    @JoinColumn(name = "ETU_DPT_ID", nullable = true)
    private Departement departement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.gouv.edu.iut.manager.entity.Etudiant[ id=" + id + " ]";
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
}

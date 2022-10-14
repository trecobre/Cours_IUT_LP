/**
 *
 */
package fr.gouv.edu.iut.manager.service.ejb;

import fr.gouv.edu.iut.manager.entity.Etudiant;
import fr.gouv.edu.iut.manager.service.EtudiantService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

/**
 * @author vgilles
 *
 */
@Stateless
@Local
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class EjbEtudiantService implements EtudiantService {

    /**
     * Logger.
     */
    private static final Logger logger = Logger.getLogger(EjbEtudiantService.class.getName());

    /**
     * L'entity manager.
     */
    @PersistenceContext(unitName = "iut-manager-ejb")
    private EntityManager entityManager;

    /*
     * (non-Javadoc)
     *
     * @see fr.gouv.edu.iut.manager.service.EtudiantService#getAllEtudiants()
     */
    @Override
    public List<Etudiant> getAllEtudiants() {
        // Log en info.
        if (logger.isLoggable(Level.INFO)) {
            logger.info("get all etudiants");
        }
        final CriteriaQuery<Etudiant> query = entityManager.getCriteriaBuilder().
                createQuery(Etudiant.class).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }
}

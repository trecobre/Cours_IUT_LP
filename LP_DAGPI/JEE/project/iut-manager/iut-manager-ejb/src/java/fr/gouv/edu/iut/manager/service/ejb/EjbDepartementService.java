/**
 *
 */
package fr.gouv.edu.iut.manager.service.ejb;

import fr.gouv.edu.iut.manager.entity.Departement;
import fr.gouv.edu.iut.manager.service.DepartementService;
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
public class EjbDepartementService implements DepartementService {

    /**
     * Logger.
     */
    private static final Logger logger = Logger.getLogger(EjbDepartementService.class.getName());

    /**
     * L'entity manager.
     */
    @PersistenceContext(unitName = "iut-manager-ejb")
    private EntityManager entityManager;

    /*
     * (non-Javadoc)
     *
     * @see
     * fr.gouv.edu.iut.manager.service.DepartementService#getAllDepartements()
     */
    @Override
    public List<Departement> getAllDepartements() {
        // Log en info.
        if (logger.isLoggable(Level.INFO)) {
            logger.info("get all departements");
        }
        final CriteriaQuery<Departement> query = entityManager.getCriteriaBuilder().
                createQuery(Departement.class).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * fr.gouv.edu.iut.manager.service.DepartementService#getDepartement(java
     * .lang.Long)
     */
    @Override
    public Departement getDepartement(long departementId) {
        // Log en info.
        if (logger.isLoggable(Level.INFO)) {
            logger.log(Level.INFO, "get departement with id [{0}]", departementId);
        }
        return entityManager.find(Departement.class, departementId);
    }
}

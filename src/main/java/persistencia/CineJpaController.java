package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Cine;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author nico-ruiz
 */
public class CineJpaController implements Serializable {

    public CineJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public CineJpaController() {
        emf = Persistence.createEntityManagerFactory("retroScopeUP");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cine cine) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cine);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cine cine) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cine = em.merge(cine);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = cine.getId();
                if (findCine(id) == null) {
                    throw new NonexistentEntityException("The cine with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cine cine;
            try {
                cine = em.getReference(Cine.class, id);
                cine.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cine with id " + id + " no longer exists.", enfe);
            }
            em.remove(cine);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cine> findCineEntities() {
        return findCineEntities(true, -1, -1);
    }

    public List<Cine> findCineEntities(int maxResults, int firstResult) {
        return findCineEntities(false, maxResults, firstResult);
    }

    private List<Cine> findCineEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cine.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cine findCine(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cine.class, id);
        } finally {
            em.close();
        }
    }

    public int getCineCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cine> rt = cq.from(Cine.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

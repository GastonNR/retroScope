/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import model.SalaVip;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author nico-ruiz
 */
public class SalaVipJpaController implements Serializable {

    public SalaVipJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public SalaVipJpaController() {
        emf = Persistence.createEntityManagerFactory("retroScopeUP");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SalaVip salaVip) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(salaVip);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSalaVip(salaVip.getNumero()) != null) {
                throw new PreexistingEntityException("SalaVip " + salaVip + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SalaVip salaVip) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            salaVip = em.merge(salaVip);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = salaVip.getNumero();
                if (findSalaVip(id) == null) {
                    throw new NonexistentEntityException("The salaVip with id " + id + " no longer exists.");
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
            SalaVip salaVip;
            try {
                salaVip = em.getReference(SalaVip.class, id);
                salaVip.getNumero();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The salaVip with id " + id + " no longer exists.", enfe);
            }
            em.remove(salaVip);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SalaVip> findSalaVipEntities() {
        return findSalaVipEntities(true, -1, -1);
    }

    public List<SalaVip> findSalaVipEntities(int maxResults, int firstResult) {
        return findSalaVipEntities(false, maxResults, firstResult);
    }

    private List<SalaVip> findSalaVipEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SalaVip.class));
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

    public SalaVip findSalaVip(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SalaVip.class, id);
        } finally {
            em.close();
        }
    }

    public int getSalaVipCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SalaVip> rt = cq.from(SalaVip.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

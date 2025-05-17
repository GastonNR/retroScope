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
import model.ClienteVip;
import persistencia.exceptions.NonexistentEntityException;

public class ClienteVipJpaController implements Serializable {

    public ClienteVipJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public ClienteVipJpaController() {
        emf = Persistence.createEntityManagerFactory("retroScopeUP");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ClienteVip clienteVip) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(clienteVip);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ClienteVip clienteVip) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            clienteVip = em.merge(clienteVip);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = clienteVip.getId();
                if (findClienteVip(id) == null) {
                    throw new NonexistentEntityException("The clienteVip with id " + id + " no longer exists.");
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
            ClienteVip clienteVip;
            try {
                clienteVip = em.getReference(ClienteVip.class, id);
                clienteVip.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clienteVip with id " + id + " no longer exists.", enfe);
            }
            em.remove(clienteVip);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ClienteVip> findClienteVipEntities() {
        return findClienteVipEntities(true, -1, -1);
    }

    public List<ClienteVip> findClienteVipEntities(int maxResults, int firstResult) {
        return findClienteVipEntities(false, maxResults, firstResult);
    }

    private List<ClienteVip> findClienteVipEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ClienteVip.class));
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

    public ClienteVip findClienteVip(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ClienteVip.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteVipCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ClienteVip> rt = cq.from(ClienteVip.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

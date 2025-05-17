/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Funcion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Pelicula;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author nico-ruiz
 */
public class PeliculaJpaController implements Serializable {

    public PeliculaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public PeliculaJpaController() {
        emf = Persistence.createEntityManagerFactory("retroScopeUP");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pelicula pelicula) {
        if (pelicula.getFunciones() == null) {
            pelicula.setFunciones(new ArrayList<Funcion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Funcion> attachedFunciones = new ArrayList<Funcion>();
            for (Funcion funcionesFuncionToAttach : pelicula.getFunciones()) {
                funcionesFuncionToAttach = em.getReference(funcionesFuncionToAttach.getClass(), funcionesFuncionToAttach.getId());
                attachedFunciones.add(funcionesFuncionToAttach);
            }
            pelicula.setFunciones(attachedFunciones);
            em.persist(pelicula);
            for (Funcion funcionesFuncion : pelicula.getFunciones()) {
                funcionesFuncion.getPelicula().add(pelicula);
                funcionesFuncion = em.merge(funcionesFuncion);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pelicula pelicula) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pelicula persistentPelicula = em.find(Pelicula.class, pelicula.getIdPelicula());
            List<Funcion> funcionesOld = persistentPelicula.getFunciones();
            List<Funcion> funcionesNew = pelicula.getFunciones();
            List<Funcion> attachedFuncionesNew = new ArrayList<Funcion>();
            for (Funcion funcionesNewFuncionToAttach : funcionesNew) {
                funcionesNewFuncionToAttach = em.getReference(funcionesNewFuncionToAttach.getClass(), funcionesNewFuncionToAttach.getId());
                attachedFuncionesNew.add(funcionesNewFuncionToAttach);
            }
            funcionesNew = attachedFuncionesNew;
            pelicula.setFunciones(funcionesNew);
            pelicula = em.merge(pelicula);
            for (Funcion funcionesOldFuncion : funcionesOld) {
                if (!funcionesNew.contains(funcionesOldFuncion)) {
                    funcionesOldFuncion.getPelicula().remove(pelicula);
                    funcionesOldFuncion = em.merge(funcionesOldFuncion);
                }
            }
            for (Funcion funcionesNewFuncion : funcionesNew) {
                if (!funcionesOld.contains(funcionesNewFuncion)) {
                    funcionesNewFuncion.getPelicula().add(pelicula);
                    funcionesNewFuncion = em.merge(funcionesNewFuncion);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = pelicula.getIdPelicula();
                if (findPelicula(id) == null) {
                    throw new NonexistentEntityException("The pelicula with id " + id + " no longer exists.");
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
            Pelicula pelicula;
            try {
                pelicula = em.getReference(Pelicula.class, id);
                pelicula.getIdPelicula();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pelicula with id " + id + " no longer exists.", enfe);
            }
            List<Funcion> funciones = pelicula.getFunciones();
            for (Funcion funcionesFuncion : funciones) {
                funcionesFuncion.getPelicula().remove(pelicula);
                funcionesFuncion = em.merge(funcionesFuncion);
            }
            em.remove(pelicula);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pelicula> findPeliculaEntities() {
        return findPeliculaEntities(true, -1, -1);
    }

    public List<Pelicula> findPeliculaEntities(int maxResults, int firstResult) {
        return findPeliculaEntities(false, maxResults, firstResult);
    }

    private List<Pelicula> findPeliculaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pelicula.class));
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

    public Pelicula findPelicula(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pelicula.class, id);
        } finally {
            em.close();
        }
    }

    public int getPeliculaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pelicula> rt = cq.from(Pelicula.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public Pelicula buscarPelicula(String titulo) {
        EntityManager em = getEntityManager();
        try{
            return em.createQuery("SELECT p FROM Pelicula p WHERE p.titulo = :titulo", Pelicula.class)
                .setParameter("titulo", titulo)
                .getSingleResult();
        }catch(Exception e){
            return null;
        }finally{
            em.close();
        }
    }
    
}

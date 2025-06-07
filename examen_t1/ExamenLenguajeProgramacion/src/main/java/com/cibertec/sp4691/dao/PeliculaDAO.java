package com.cibertec.sp4691.dao;

import com.cibertec.sp4691.model.Pelicula;
import com.cibertec.sp4691.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class PeliculaDAO {

    public List<Pelicula> listarPeliculas() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Pelicula> peliculas = null;
        try {
            // JOIN FETCH para cargar el género en la misma consulta y evitar N+1
            Query query = em.createQuery("SELECT p FROM Pelicula p JOIN FETCH p.genero");
            peliculas = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return peliculas;
    }

    public Pelicula obtenerPeliculaPorId(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Pelicula pelicula = null;
        try {
            pelicula = em.find(Pelicula.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return pelicula;
    }

    public void insertarPelicula(Pelicula pelicula) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(pelicula);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void actualizarPelicula(Pelicula pelicula) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(pelicula);  
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void eliminarPelicula(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Pelicula pelicula = em.find(Pelicula.class, id);
            if (pelicula != null) {
                em.remove(pelicula);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
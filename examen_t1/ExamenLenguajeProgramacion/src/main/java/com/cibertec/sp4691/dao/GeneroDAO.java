package com.cibertec.sp4691.dao;

import com.cibertec.sp4691.model.Genero;
import com.cibertec.sp4691.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class GeneroDAO {

    public List<Genero> listarGeneros() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Genero> generos = null;
        try {
            Query query = em.createQuery("SELECT g FROM Genero g");
            generos = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return generos;
    }

    public Genero obtenerGeneroPorId(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Genero genero = null;
        try {
            genero = em.find(Genero.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return genero;
    }
}
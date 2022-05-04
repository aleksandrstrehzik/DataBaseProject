package DAO.Impl;

import DAO.Interfaces.DAO;
import Utils.HibernateUtils;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public abstract class BaseDAO<T> implements DAO<T> {

    private final Class<T> clazz;
    private EntityManager em;

    @Override
    public T findById(Integer id) {
        em = HibernateUtils.getEntityManager();
        T entity = em.find(clazz, id);
        em.close();
        return entity;
    }

    @Override
    public void deleteById(Integer id) {
        T entity = findById(id);
        em = HibernateUtils.getEntityManager();
        em.getTransaction().begin();
        T merge = em.merge(entity);
        em.remove(merge);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<T> findAll() {
        em = HibernateUtils.getEntityManager();
        List<T> resultList = em.createQuery("from " + clazz.getName()).getResultList();
        em.close();
        return resultList;
    }

    @Override
    public void save(T entity) {
        em = HibernateUtils.getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(T entity) {
        em = HibernateUtils.getEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }

}

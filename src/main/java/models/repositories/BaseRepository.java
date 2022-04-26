package models.repositories;

import models.domain.SubjectEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class BaseRepository<T> implements IRepository<T, Integer> {

    protected EntityManagerFactory entityManagerFactory;
    protected static EntityManager entityManager;

    public  BaseRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("school");
        entityManager = entityManagerFactory.createEntityManager();
    }



    public  void save(SubjectEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    public void update(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    public void delete(T entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    public abstract T findById(Integer id);
}

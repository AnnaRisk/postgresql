package models.repositories;



import models.domain.StudentsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class StudentsRepository implements IRepository <StudentsEntity, Integer> {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;


    public StudentsRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("school");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void save(StudentsEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(StudentsEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.refresh(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public StudentsEntity findById(int id) {
        return entityManager.find(StudentsEntity.class, id);
    }




    @Override
    public void delete(StudentsEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();

    }

    @Override
    public List<StudentsEntity> findAll() {
        return entityManager.createQuery("from StudentsEntity").getResultList();
    }

    @Override
    public void deleteAll() {
        List<StudentsEntity> students = findAll();
        for (var student : students) {
            delete(student);
        }
    }


}



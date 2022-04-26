package models.repositories;

import models.domain.SubjectEntity;

import java.util.List;

public class SubjectsRepository extends BaseRepository <SubjectEntity> {


    public static List<SubjectEntity> findAllByName(String subject) {
        String query = String.format("from SubjectEntity where name_subject is '%s'", subject);
        return entityManager.createQuery(query).getResultList();
    }

    public static List<SubjectEntity> findAllByNameContains(String subName) {
        String query = "from SubjectEntity where name_subject like '%" + subName + "%'";
        return entityManager.createQuery(query).getResultList();
    }


    @Override
    public SubjectEntity findById(int id) {
        return null;
    }

    @Override
    public List<SubjectEntity> findAll() {
        String query = String.format("from SubjectEntity where name_subject is '%s'");
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void deleteAll() {

    }


    @Override
    public SubjectEntity findById(Integer id) {
        return entityManager.find(SubjectEntity.class, id);
    }
}

package models.services;

import models.domain.SubjectEntity;

import models.repositories.BaseRepository;
import models.repositories.SubjectsRepository;
import java.util.List;

public class SubjectServices {


    private static SubjectsRepository subjectsRepository;

    public SubjectServices() {
        subjectsRepository = new SubjectsRepository();
    }

    public int create(SubjectEntity subject) throws Exception {
        if (subject.getName_subject().isBlank()) {
            throw new Exception("name_subject cannot be blank");
        }

        subjectsRepository.save(subject);
        return subject.getId();
    }

    public void delete(int id) {
        var existingBook = subjectsRepository.findById(id);

        if (existingBook != null) {
           subjectsRepository.delete(existingBook);
        }
    }

    public List<SubjectEntity> getAllByName(String name) {
        return SubjectsRepository.findAllByName(name);
    }

    public List<SubjectEntity> getAllByNameContains(String subName) {
        return SubjectsRepository.findAllByNameContains(subName);
    }


}

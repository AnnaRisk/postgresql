package models.services;


import models.domain.StudentsEntity;
import models.repositories.StudentsRepository;

import java.util.Objects;


public class StudentsServices {

    private static StudentsRepository studentsRepository;

    public StudentsServices() {
        studentsRepository = new StudentsRepository();
    }

    public int create(StudentsEntity student) throws Exception {
       var existingStudent = studentsRepository.findAll().stream()
                .filter(a -> Objects.equals(a.getNumber_group(),student.getNumber_group()) &&
                        a.getFio().equals(student.getFio()))
                .findFirst();

        if (existingStudent.isPresent()) {
            throw new Exception("This student already exists");
        }

        studentsRepository.save(student);
        return student.getId();
    }

    public void update(StudentsEntity student) {
        studentsRepository.update(student);
    }

    public StudentsEntity getById(int id) {
        return studentsRepository.findById(id);
    }

    public void delete(int id) {
        StudentsEntity student = studentsRepository.findById(id);
        studentsRepository.delete(student);
    }


    }


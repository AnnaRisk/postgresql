import models.domain.StudentsEntity;
import models.domain.SubjectEntity;
import models.services.StudentsServices;
import models.services.SubjectServices;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseTest {

    private StudentsServices studentsServices;
    private  SubjectServices subjectServices;
    private int studentId;
    private int  subjectId1;
    private int subjectId2;
   // private int id;

    @BeforeEach
    public void setup() {
        studentsServices = new StudentsServices();
        subjectServices = new SubjectServices();
    }

    @AfterEach
    public void teardown() {
        studentsServices.delete(studentId);
        subjectServices.delete(subjectId1);
        subjectServices.delete(subjectId2);
    }

    @Test
    public void whenCreateExistingStudentShouldReturnError() throws Exception {
       StudentsEntity student = new StudentsEntity();
        student.setNumber_group(6407);
        student.setFio("Anna Rain Test3");

        studentId = studentsServices.create(student);


        // ... UI Actions
    }
    @Test
    public void whenCreateSubjectShouldReturnOk() throws Exception {
        SubjectEntity subject1 = new  SubjectEntity();
        subject1.setName_subject("English");

        SubjectEntity subject2 = new  SubjectEntity();
        subject2.setName_subject("Economic");

       subjectId1 = subjectServices.create(subject1);
        subjectId2 = subjectServices.create(subject2);

        assertNotEquals(subjectId1,  subjectId2);
    }

    @Test
    public void whenGetSubWithNameShouldReturnExactId() {
        List<SubjectEntity> subject = subjectServices.getAllByName("English");
        assertTrue(subject.stream().anyMatch(b -> b.getId() == 2));
    }

    @Test
    public void whenGetSubWithNameContainsShouldReturnExactId() {
        List<SubjectEntity> subject  = subjectServices.getAllByNameContains("English");
        assertTrue(subject.stream().anyMatch(b -> b.getId() == 2));
    }

}

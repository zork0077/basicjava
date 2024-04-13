package Controller;

import Model.Sex;
import Model.Student;

public class StudentCreator implements HumanCreatable<Student>{
    @Override
    public Student create(String firstName, String lastName, String middleName, Sex sex, String id) {
        return new Student(firstName, lastName, middleName, sex, id);
    }
}

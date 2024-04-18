package org.example;

import Controller.*;
import Model.Head;
import Model.Sex;
import Model.Student;
import Model.University;
import org.junit.Test;


import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class UniversityTest {

    @Test
    public void testJsonSerializationDeserialization() throws IOException {
        University oldUniversity = createOldUniversity();

        JsonManager.writeToJson(oldUniversity, "oldUniversity.json");

        University newUniversity = JsonManager.readFromJson(University.class, "oldUniversity.json");

        oldUniversity.equals(newUniversity);

    }

    public University createOldUniversity() {
        HeadCreator headCreator = new HeadCreator();
        StudentCreator studentCreator = new StudentCreator();
        GroupCreator groupCreator = new GroupCreator();
        DepartmentCreator departmentCreator = new DepartmentCreator();
        FacultyCreator facultyCreator = new FacultyCreator();

        Head universityHead = headCreator.create("Anastasiia", "Andriyivna", "A", Sex.Female, "1");
        Head facultyHead = headCreator.create("Bohdan", "Bilous", "B", Sex.Male, "2");
        Head departmentHead = headCreator.create("Dmytro", "Dovzhenko", "D", Sex.Male, "3");
        Head groupHead = headCreator.create("Ivan", "Ivanov", "I", Sex.Male, "4");

        Student student1 = studentCreator.create("Andrii", "Andriiovych", "Andrii", Sex.Male, "001");
        Student student2 = studentCreator.create("Bohdana", "Bilous", "Bohdan", Sex.Female, "002");

        University university = new University("Old University", facultyCreator.create("122", facultyHead,
                departmentCreator.create("20", departmentHead,
                        groupCreator.create("1", groupHead, student1),
                        groupCreator.create("2", groupHead, student2))),
                universityHead);

        return university;
    }
}
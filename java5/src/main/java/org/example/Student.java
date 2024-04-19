package org.example;

import java.time.LocalDate;
import java.util.Objects;

public class Student {
    public int id;
    public int gradebookId;
    public String firstName;
    public String lastName;
    public String patronymic;
    public LocalDate dateOfBirth;
    public Student(int id, int gradebookId, String firstName, String lastName, String patronymic, LocalDate dateOfBirth) {
        this.id = id;
        this.gradebookId = gradebookId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                gradebookId == student.gradebookId &&
                firstName.equals(student.firstName) &&
                lastName.equals(student.lastName) &&
                patronymic.equals(student.patronymic) &&
                dateOfBirth.equals(student.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gradebookId, firstName, lastName, patronymic, dateOfBirth);
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", gradebookId=" + gradebookId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
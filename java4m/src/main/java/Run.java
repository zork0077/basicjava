import Controller.*;
import Model.*;

public class Run {
    public static void main(String[] args) {
        UniversityCreator universityCreator = new UniversityCreator();
        University university = universityCreator.createTypicalUniversity();

        if (university != null) {
            System.out.println("University Name: " + university.getName());
            System.out.println("University Head: " + university.getHead());
            System.out.println("Faculties:");

            for (Faculty faculty : university.getSubComponent()) {
                System.out.println("\tFaculty Name: " + faculty.getName());
                System.out.println("\tFaculty Head: " + faculty.getHead());
                System.out.println("\tDepartments:");

                for (Department department : faculty.getSubComponent()) {
                    System.out.println("\t\tDepartment Name: " + department.getName());
                    System.out.println("\t\tDepartment Head: " + department.getHead());
                    System.out.println("\t\tGroups:");

                    for (Group group : department.getSubComponent()) {
                        System.out.println("\t\t\tGroup Name: " + group.getName());
                        System.out.println("\t\t\tGroup Head: " + group.getHead());
                        System.out.println("\t\t\tStudents:");

                        for (Student student : group.getSubComponent()) {
                            System.out.println("\t\t\t\tStudent Name: " + student.getFirstName() + " " + student.getLastName());
                            System.out.println("\t\t\t\tStudent ID: " + student.getStudentId());
                        }
                    }
                }
            }
        } else {
            System.out.println("Failed to create university.");
        }



    }
}

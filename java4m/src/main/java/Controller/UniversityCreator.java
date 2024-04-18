package Controller;

import Model.Faculty;
import Model.Head;
import Model.Student;
import Model.University;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Model.Sex.Female;
import static Model.Sex.Male;

public class UniversityCreator implements UniversityComponentCreatable<University, Faculty> {

    @Override
    public University create(String name, Head head, List<Faculty> subComponentOfUniversity) {
        if (subComponentOfUniversity.isEmpty()) {
            return null;
        }
        return new University(name, subComponentOfUniversity, head);
    }

    @Override
    public University create(String name, Head head, Faculty... subComponentsOfUniversity) {
        if (subComponentsOfUniversity == null) {
            return null;
        }
        List<Faculty> FacultyList = new ArrayList<>();
        Collections.addAll(FacultyList, subComponentsOfUniversity);
        return new University(name, FacultyList, head);
    }

    public University createTypicalUniversity() {
        HeadCreator HeadCreator = new HeadCreator();
        StudentCreator StudentCreator = new StudentCreator();
        GroupCreator GroupCreator = new GroupCreator();
        DepartmentCreator DepartmentCreator = new DepartmentCreator();
        FacultyCreator FacultyCreator = new FacultyCreator();

        Head UniversityHead = HeadCreator.create("Anastasiia", "Andriyivna", "A", Female, "1");
        Head FacultyFirstHead = HeadCreator.create("Bohdan", "Bilous", "B", Male, "2");
        Head DepartmentFirstHead = HeadCreator.create("Dmytro", "Dovzhenko", "D", Male, "3");
        Head GroupFirstHead = HeadCreator.create("Ivan", "Ivanov", "I", Male, "4");

        Student StudentFirst = StudentCreator.create("Andrii", "Andriiovych", "Andrii", Male, "001");
        Student StudentSecond = StudentCreator.create("Bohdana", "Bilous", "Bohdan", Female, "002");
        Student StudentThird = StudentCreator.create("Bohdan", "Kalinkin", "Pavel", Male, "003");
        Student StudentFourth = StudentCreator.create("Daryna", "Dovzhenko", "Andrii", Female, "004");
        Student StudentFifth = StudentCreator.create("Yelyzaveta", "Yaroslavivna", "Yaroslav", Female, "005");
        Student StudentSixth = StudentCreator.create("Yaroslav", "Yaroslavovych", "Yaroslav", Male, "006");



        University UniversityTypical = new UniversityCreator().create("NTU DP", UniversityHead,
                FacultyCreator.create("122", FacultyFirstHead,
                        DepartmentCreator.create("20", DepartmentFirstHead,
                                GroupCreator.create("1", GroupFirstHead, StudentFirst),
                                GroupCreator.create("2", GroupFirstHead, StudentSecond),
                                GroupCreator.create("3", GroupFirstHead, StudentThird))),

                FacultyCreator.create("125", FacultyFirstHead,
                        DepartmentCreator.create("20", DepartmentFirstHead,
                                GroupCreator.create("1", GroupFirstHead, StudentFourth),
                                GroupCreator.create("2", GroupFirstHead, StudentFifth),
                                GroupCreator.create("3", GroupFirstHead, StudentSixth)
)
                )
        );
        return UniversityTypical;
    }

}
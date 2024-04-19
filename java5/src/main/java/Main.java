import org.example.Student;

import java.sql.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "admin");

            if(connection !=null){
                System.out.println("Connected to database.");
            }
            List<Student> students = getStudents(connection);
            Map<Month, List<Student>> studentsByMonth = groupStudentsByBirthMonth(students);
            Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.println("Enter number of month: ");
                try {
                    int input = scanner.nextInt();
                    if (input < 1 || input > 12) { break; }
                    List<Student> studentsInMonth = studentsByMonth.get(Month.of(input));
                    for (Student student : studentsInMonth) {
                        System.out.println(student);
                    }
                }
                catch (NullPointerException e) {
                    System.out.println("No students with such month of birth.");
                }
                catch (InputMismatchException e) {
                    System.out.println("You should enter number of month.");
                    scanner.nextLine();
                }
            }
            connection.close();
        }
        catch (SQLException e) {
            System.out.println("Connection failed");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
    }
    private static List<Student> getStudents(Connection connection) throws SQLException {
        List<Student> students = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.\"Student\"");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int gradebookId = resultSet.getInt("gradebook_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String patronymic = resultSet.getString("patronymic");
            LocalDate dateOfBirth = resultSet.getDate("date_of_birth").toLocalDate();

            Student student = new Student(id, gradebookId, firstName, lastName, patronymic, dateOfBirth);
            students.add(student);
        }

        resultSet.close();
        statement.close();

        return students;
    }
    private static Map<Month, List<Student>> groupStudentsByBirthMonth(List<Student> students) {
        Map<Month, List<Student>> studentsByMonth = new HashMap<>();

        for (Student student : students) {
            Month birthMonth = student.dateOfBirth.getMonth();
            studentsByMonth.computeIfAbsent(birthMonth, k -> new ArrayList<>()).add(student);
        }

        return studentsByMonth;
    }
}
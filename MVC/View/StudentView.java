package View;

import Controller.ClassesController;
import Controller.StudentController;
import Model.Student;

import java.util.List;

public class StudentView {

    StudentController studentController = new StudentController();

    /**
     * VIEW <--> CONTROLLER
     * View call the controller for an updated list of students
     */
    public void showMeListOfStudents(){
        List<Student> allStudents = studentController.findStudentListFromDB();
        allStudents.stream().
                forEach(
                    students-> System.out.println(students.getName() + " " + students.getAge())
                );
    }

    /**
     * VIEW <--> CONTROLLER
     * tells controller to request student update
     * View prints an informative message for the user
     * @param name
     * @param newAge
     */
    public void updateUserAge(String name, int newAge){
        String status = studentController.updateStudentAge(name, newAge);
        System.out.println("\nUpdating user Age...");
        if (status == "ASSIGNED TO CLASSES"){
            System.out.println("INFO: Teacher's will be notified of student's age change");
        } else {
            System.out.println("INFO: Student is not assigned to classes at the moment");
        }
    }

    /**
     * VIEW <--> CONTROLLER
     * @param name
     */
    public void showMeSpecificStudent(String name) {
        Student student = studentController.findSpecificStudent(name);
        System.out.println(student.getName() + " " + student.getAge());
    }
}

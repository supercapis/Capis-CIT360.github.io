package Controller;

import Model.Student;
import Model.StudentModel;

import java.util.List;

public class StudentController {


    /**
     *
     * Redirects to the Model user request for finding all students
     * @return Student List
     */
    public List<Student> findStudentListFromDB(){
        return StudentModel.getStudentModelInstance().getAllStudentsFromDB();
    }


    /**
     * CONTROLLER <--> CONTROLLER
     * Calling Classes Controller from Student Controller to check extra information and notify teachers if necessary
     *
     * CONTROLLER <--> MODEL
     * Calling Student Model to update student age
     *
     * @param name
     * @param newAge
     * @return String status to View
     */

    public String updateStudentAge(String name, int newAge) {
        ClassesController classesController = new ClassesController();
        String status = null;
        if(classesController.isStudentAssignedToClasses(name)){
            status = "ASSIGNED TO CLASSES";
        } else {
            status = "NOT ASSIGNED TO CLASSES";
        }
        StudentModel.getStudentModelInstance().updateStudentAge(name, newAge);
        return status;
    }

    /**
     * CONTROLLER <--> MODEL
     * @param name
     * @return
     */
    public Student findSpecificStudent(String name) {
        return StudentModel.getStudentModelInstance().getStudentFromDB(name);
    }
}

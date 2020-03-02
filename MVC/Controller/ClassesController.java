package Controller;

import Model.ClassesModel;
import Model.Student;
import Model.StudentModel;

/**
 * CONTROLLER <--> MODEL
 * Controller for all Student Classes related actions
 */
public class ClassesController {
    ClassesModel classesModel = new ClassesModel();

    public boolean isStudentAssignedToClasses(String name) {

        //Calls Student Model to get studentID
        // CONTROLLER <--> MODEL
       Student student =  StudentModel.getStudentModelInstance().getStudentFromDB(name);

       //Calls Class Model to check if student is assigned to any class and return information to Student controller
       // CONTROLLER <--> MODEL
       return classesModel.checkIfStudentIsInClass(student.getId());

    }
}

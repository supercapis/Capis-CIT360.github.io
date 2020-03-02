package Model;

import java.util.ArrayList;
import java.util.List;

public class ClassesModel {
    private List<Classes> currentClasses = new ArrayList<>();

    public ClassesModel(){
        this.createClasses();
    }


    public boolean checkIfStudentIsInClass(int studentId){
        return false;
    }

    private void createClasses() {
        Classes classes = new Classes();
        classes.setStudentClass("Calculus");
        classes.setStudentID(4);
        currentClasses.add(classes);

        classes = new Classes();
        classes.setStudentClass("History");
        classes.setStudentID(5);
        currentClasses.add(classes);

        classes = new Classes();
        classes.setStudentClass("Religion");
        classes.setStudentID(1);
        currentClasses.add(classes);
    }


}

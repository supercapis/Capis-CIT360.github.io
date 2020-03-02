package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentModel {

    private static StudentModel studentModelInstance = null;
   private List<Student> studentsFromDB;


    public StudentModel() {
        this.createStudentDBList();
    }

    public static StudentModel getStudentModelInstance(){
        if (studentModelInstance == null) {
            studentModelInstance = new StudentModel();
        }
        return studentModelInstance;
    }

    /**
     * @param name
     * @return Returns student object to controller calls
     */
    public Student getStudentFromDB(String name){
        Student studentFromDB = this.getAllStudentsFromDB().stream()
                .filter(student -> student.getName().equals(name))
                .collect(Collectors.toList()).get(0);

        return studentFromDB ;
    }

    /**
     * Accepts information passed by controllers to change data
     * @param name
     * @param newAge
     */
    public void updateStudentAge(String name, int newAge) {
        List<Student> tempStudentList = this.getAllStudentsFromDB();
        Student studentObj = tempStudentList.stream()
                .filter(student -> student.getName().equals(name))
                .collect(Collectors.toList()).get(0);

        Student newStudent = studentObj;
        newStudent.setAge(newAge);
        tempStudentList.set(tempStudentList.indexOf(studentObj),newStudent);
    }




    public List<Student> getAllStudentsFromDB() {
        return studentsFromDB;
    }
    public void setStudentsFromDB(List<Student> studentsFromDB) {
        this.studentsFromDB = studentsFromDB;
    }

    /**
     * Creates a fake list simulating database data
     * @return Student fake database list
     */
    public void createStudentDBList(){
        List<Student> studentList = new ArrayList<>();
        Student student = new Student();
        student.setName("John Doe");
        student.setAge(29);
        student.setId(1);
        studentList.add(student);
        student = new Student();
        student.setName("Alex Xavier");
        student.setAge(19);
        student.setId(2);
        studentList.add(student);
        student = new Student();
        student.setName("Donald Trump");
        student.setAge(17);
        student.setId(3);
        studentList.add(student);
        this.setStudentsFromDB(studentList);
    }


}

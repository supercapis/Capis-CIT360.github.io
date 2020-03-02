import View.StudentView;

/**
 * @author:
 * @date: 3/1/2020
 *
 * Diagram: https://alvinalexander.com/uml/uml-model-view-controller-mvc-diagram
 *
 * RULES:
 * A) Users interact with View objects
 * B) View objects and Controller objects talk to each other
 * C) Different Controller objects talk to each other
 * D) Controller objects talk to Model objects
 * E) No other forms of communication between objects are allowed
 *
 * ------ MVC Pattern flow: ---------
 * USER --> VIEW
 * VIEW <--> CONTROLLER
 * CONTROLLER <--> CONTROLLER
 * CONTROLLER <--> MODEL
 *
 * DEMO FLOW EXPLAINED:
 * 1) User hypothetically interacts with software consulting student name (USER --> VIEW)
 * 2) View interacts with controllers to find student's name and show it to user (VIEW <--> CONTROLLER, CONTROLLER <--> MODEL)
 * 3) User then selects name and chooses to update age (USER --> VIEW, VIEW <--> CONTROLLER, CONTROLLER <--> CONTROLLER, CONTROLLER <--> MODEL)
 * 4) View interacts with controller which interacts with models and perform operation of update age
 * 5) view presents values to user in console.
 */
public class UserDemo {

    public static void main(String[] args) {
        //software creates a view instance
        StudentView view = new StudentView();
        //User interacts only with View. Request a list of all students available
        System.out.println("Full List of Students:");
        view.showMeListOfStudents();

        //User spots wrong age and changes John Doe from 29 to 19
        view.updateUserAge("John Doe", 19);

        //Check if user has now the date updated.
        System.out.println("\nStudent after change:");
        view.showMeSpecificStudent("John Doe");

        //User see changes presented by view after changes.
    }

}

/** The View presents the model’s data to the user.  * The view knows how to access the model’s data,
 * but it does not know what this data means or what the user can do to manipulate it. **/

/** The ""View"" is what the user sees **/

/** In this program, the user will interact with the "view" by choosing 1 out of 7 options,
 and this is how the view communicates with the controller **/

package view;

import controller.BoatController;

import java.util.Scanner;

public class BoatView {
    public static void main(String[] args) {
        BoatController controller = new BoatController();

        /*Creating a scanner*/
        Scanner input = new Scanner(System.in);
        int command = 0;
        System.out.println("\nChoose one of the options to make the boat work:");
        boolean running = true;
        while (running) {
            System.out.println("(1) accelerate");
            System.out.println("(2) reduce speed");
            System.out.println("(3) full power ahead");
            System.out.println("(4) full stop");
            System.out.println("(5) Launch the anchor");
            System.out.println("(6) Pull the anchor back");
            System.out.println("(7) Abandon ship!");
            System.out.printf("\nPlease, select a number from 1 to 7: ");
            command = input.nextInt();

            if (command == 1) {
                controller.accelerate();
            } else if (command == 2) {
                controller.reducespeed();
            } else if (command == 3) {
                controller.fullpower();
            } else if (command == 4) {
                controller.fullstop();
            } else if (command == 5) {
                controller.anchorDown();
            } else if (command == 6) {
                controller.anchorUp();
            }
            if (command > 0 && command < 7) {
                System.out.println(controller.getBoatStatus());
            }else if (command == 7) {
                running = false;
                System.out.println("Go ahead and pull up the boat in the garage");
            }else{
                System.out.println("Command Invalid - Try a number between 1 and 7");
            }

    }
    }
}


/** The Controller exists between the view and the model.
 * It listens to events triggered by the view
 * (or another external source) and executes the appropriate reaction to these events.
 * In most cases, the reaction is to call a method on the model.
 * Since the view and the model are connected through a notification mechanism,
 * the result of this action is then automatically reflected in the view. **/

 /** In this program, the Controller comes to control power and boat status **/

 /** Controllers talk to each other and  the view communicates with the controllers with the user's intervention**/

/*Creating the "controller package" to have the concerns and structures separated*/
package controller;

import model.BoatModel;

public class BoatController {
    private BoatModel boat;

    public BoatController() {
        boat = new BoatModel(0, "Forward", true);
    }

    public void accelerate() {
        double power = boat.getPower() + 5;
        if (power <= 100) {
            boat.setPower(power);
        }
    }

    public void reducespeed() {
        double power = boat.getPower() - 5;
        if (power >= 0) {
            boat.setPower(power);
        }
    }

    public void fullpower() {
        boat.setPower(100);
        boat.setStatus("forward");
    }

      public void fullstop() {
        boat.setPower(0);
        boat.setStatus("stop");
    }

    public void anchorDown() {
        boat.setPower(0);
        boat.setAnchored(true);
    }

    public void anchorUp() {
        boat.setPower(0);
        boat.setAnchored(false);
    }

    public String getBoatStatus(){
        return "The power is in " + boat.getPower() + "%; Boat Status = " + boat.getStatus();
    }
}


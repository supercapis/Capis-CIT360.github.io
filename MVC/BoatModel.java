/** The Model contains only the pure application data,
 * it contains no logic describing how to present the data to a user. **/

/** The purpose of the model is to design and structure the program with classes
 * The model in this program provides all the structure that the controllers need,
 * so the controllers can communicate with the view **/

/*Creating the "model package" to have the concerns and structures separated*/
package model;

/*Creating the Boat class*/
public class BoatModel {

        /*Creating methods to get the Boat to work */
        private double power; /*0% to 100%*/
        private String status;  /*That will go forward*/
        private Boolean anchored; /* that will completely stop*/

        /* Creating the constructor for this file*/
        public BoatModel(double power, String direction, Boolean anchored) {
                this.power = power;
                this.status = direction;
                this.anchored = anchored;
        }
        /*Creating the getters*/
        public double getPower() {
                return power;
        }

        public String getStatus() {
                return status;
        }

        public Boolean getAnchored() {
                return anchored;
        }

        /*Creating the setters*/
        public void setPower(double power) {
                this.power = power;
        }

        public void setStatus(String status) {
                this.status = status;
        }

        public void setAnchored(Boolean anchored) {
                this.anchored = anchored;
        }
}

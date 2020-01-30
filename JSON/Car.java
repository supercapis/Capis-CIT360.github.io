/*This is the class called Car, where I will create the getters and setters*/
public class Car {
    /*Stating attributes/class properties*/
    private String brand;
    private int year;
    private String model;
    private String color;

    /*I generated these getters and setters for this class*/
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /*Setting the information I wanted to be printed*/
    public String toString() {
        return "Brand: " + brand + "  Year: " + year + "  Model: " + model + "  Color: " + color;
    }
}
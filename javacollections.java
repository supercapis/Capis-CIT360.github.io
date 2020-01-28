/*
* My wife convinced me that I need to improve the quality of my meals during the week,
* so she will prepare a combination of what I need to eat from Monday to Friday.
She is going to select a variety of food that will compose my lunchbox for the five days of one week.
* She went to the market and bought: Peas, Corn, Garbanzos, Tomato, Rice, Beans, Chicken, Carrots,
* Lettuce, Onions, Broccoli and Beet.
I will use java collections to assist me in a program to select the ingredients to compose my weekly lunchbox.
* */

import java.util.*;

public class javacollections {
    public static void main(String[] args) {
        System.out.println("\nThis program comes to help me select a menu of ingredients to compose my weekly lunchbox.\n");

        System.out.println("----------Weekly Menu----------\n");
        /*
         * Using the set collections to write my program.
         * Credits: Inspired myself on the video instructions provided by Troy Tuckett, CIT 360 Instructor in BYU-I
         * */
        Set<String> set = new TreeSet<>();
        set.add("Peas");
        set.add("Corn");
        set.add("Garbanzos");
        set.add("Tomato");
        set.add("Rice");
        set.add("Beans");
        set.add("Carrots");
        set.add("Lettuce");
        set.add("Onions");
        set.add("Chicken");
        set.add("Beet");
        set.add("Broccoli");
        /*
         * Printing the menu from Monday to Friday
         * */
        System.out.println("This is my menu for Monday: ");
        System.out.println(getDailyList(set));

        System.out.println("\nThis is my menu for Tuesday: ");
        System.out.println(getDailyList(set));

        System.out.println("\nThis is my menu for Wednesday: ");
        System.out.println(getDailyList(set));

        System.out.println("\nThis is my menu for Thursday: ");
        System.out.println(getDailyList(set));

        System.out.println("\nThis is my menu for Friday: ");
        System.out.println(getDailyList(set));

        System.out.println("\n-------------------------------\n");

        System.out.println("I am doing all that I can to eat healthier. Goodbye");
    }

    /*My intention is to get 3 different and random itens on the menu list.
    This while loop is crucial to help me with this intention.
    This method comes to show that while there is not 3 itens on the menu list;
    it will still be looking for an item to include in the list*/
    private static ArrayList getDailyList(Set<String> set) {
        ArrayList dailyMenu = new ArrayList();
        while (dailyMenu.size() < 3) {
            String food = getRandomValue(set);
            /*
            * IndexOF verification comes to help verify an item that is not on the menu list yet.
            * */
            if (dailyMenu.indexOf(food) == -1) {
                dailyMenu.add(food);
            }
        }
        return dailyMenu;
    }

    /*This method is supposed to assist the previous one to get a ramdom value for the list*/
    private static String getRandomValue(Set<String> set) {
        int size = set.size();
        int item = new Random().nextInt(size);/*This s the crucial line of code generates a random number*/
        var i = 0;
        String randomFood = "";
        for (String food : set) {
            if (i == item)
                randomFood = food;
            i++;
        }
        return randomFood;
    /*Credits for helping me with these two methods:
    https://stackoverflow.com/questions/124671/picking-a-random-element-from-a-set?answertab=votes#tab-top*/
    }
}

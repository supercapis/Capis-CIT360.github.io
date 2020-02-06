import java.util.*;

public class javacollections2 {
    public static void main(String[] args) {
        Map map = new HashMap();
        /*---------------MAP LIST---------------*/
        System.out.println("\nMap the order of songs styles I want to set in my mp4 player.\n");
        map.put(5, "Blues");
        map.put(4, "Country");
        map.put(3, "Pop");
        map.put(6, "Rock");
        map.put(8, "Techno");
        map.put(2, "Soul");
        map.put(7, "Blues");
        map.put(1, "Hip-Hop");

        for (int i = 1; i < 9; i++) {
            String music = (String) map.get(i);
            System.out.println(music);
        }

        /*---------------QUEUE LIST---------------*/
        System.out.println("\nQueue the student's names in Alphabetical order.\n");
        Queue queue = new PriorityQueue();
        queue.add("Jason");
        queue.add("Desiree");
        queue.add("Sandra");
        queue.add("Alvin");
        queue.add("Rebecca");
        queue.add("Cindy");
        queue.add("Monica");
        queue.add("Elvis");
        queue.add("Larry");
        queue.add("Zoe");

        Iterator students = queue.iterator();
        while (students.hasNext()) {
            System.out.println(queue.poll());
        }

        /*---------------TREESET LIST---------------*/
        System.out.println("\nThis program helps the user to remove a random number from the Tree list:\n");
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(10) + 1;
        /*Creates a TreeSet*/
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(4);
        numbers.add(2);
        numbers.add(10);
        numbers.add(5);
        numbers.add(8);
        numbers.add(7);
        numbers.add(1);
        numbers.add(9);
        numbers.add(3);
        numbers.add(6);

        System.out.print("Treset contents before removing a random: " + numbers);
        /*Removes a random number from the list*/
        numbers.remove(randomInt);
        System.out.print("\nTreset contents after removing a random: " + numbers);

    }
}

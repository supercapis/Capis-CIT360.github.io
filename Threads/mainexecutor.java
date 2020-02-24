package threadProject;

    /**Create main executor with the objective of calling the runnable class**/
class MainExecutor {
    /**Create 6 threads; when the instances start,
     * they go to runnable and use the method called "public void startThread()",
     * so it can work**/
    static int numberOfThreadsToRun = 6;

    public static void main(String[] args) {
        for (int i = 0; i < numberOfThreadsToRun ; i++) {
            RunnableClass runnable = new RunnableClass("Thread-"+ i );
            runnable.startThread();

     /**EXPLANAINING THE OUTPUT:
      * Regardless of being in a different execution,
      * WHEN IT STARTS RUNNING, each of them is accessing the same value (1).
      * It means that if you have a concurrence, and you access for example 100 users,
      * all of them will access the same value
      **/

     /** OUTPUT:
      *Starting Thread-0
      * Starting Thread-1
      * Starting Thread-2
      * Starting Thread-3
      * Starting Thread-4
      * Starting Thread-5
      * Running Thread-0
      * Thread: Thread-0-4 - Accessing Atomic Value
      * Running Thread-1
      * Thread: Thread-1-4 - Accessing Atomic Value
      * Atomic value for Thread Thread-1-4 is 1
      * Running Thread-2
      * Thread: Thread-2-4 - Accessing Atomic Value
      * Atomic value for Thread Thread-2-4 is 1
      * Running Thread-3
      * Thread: Thread-3-4 - Accessing Atomic Value
      * Atomic value for Thread Thread-3-4 is 1
      * Running Thread-4
      * Thread: Thread-4-4 - Accessing Atomic Value
      * Atomic value for Thread Thread-4-4 is 1
      * Running Thread-5
      * Thread: Thread-5-4 - Accessing Atomic Value
      * Atomic value for Thread Thread-5-4 is 1
      * Atomic value for Thread Thread-0-4 is 1
      * Thread: Thread-0-3 - Accessing Atomic Value
      * Atomic value for Thread Thread-0-3 is 2
      * Thread: Thread-5-3 - Accessing Atomic Value
      * Atomic value for Thread Thread-5-3 is 2
      * Thread: Thread-4-3 - Accessing Atomic Value
      * Atomic value for Thread Thread-4-3 is 2
      * Thread: Thread-3-3 - Accessing Atomic Value
      * Atomic value for Thread Thread-3-3 is 2
      * Thread: Thread-2-3 - Accessing Atomic Value
      * Atomic value for Thread Thread-2-3 is 2
      * Thread: Thread-1-3 - Accessing Atomic Value
      * Atomic value for Thread Thread-1-3 is 2
      * Thread: Thread-4-2 - Accessing Atomic Value
      * Thread: Thread-5-2 - Accessing Atomic Value
      * Atomic value for Thread Thread-5-2 is 3
      * Atomic value for Thread Thread-4-2 is 3
      * Thread: Thread-1-2 - Accessing Atomic Value
      * Thread: Thread-2-2 - Accessing Atomic Value
      * Thread: Thread-3-2 - Accessing Atomic Value
      * Thread: Thread-0-2 - Accessing Atomic Value
      * Atomic value for Thread Thread-2-2 is 3
      * Atomic value for Thread Thread-1-2 is 3
      * Atomic value for Thread Thread-0-2 is 3
      * Atomic value for Thread Thread-3-2 is 3
      * Thread: Thread-3-1 - Accessing Atomic Value
      * Atomic value for Thread Thread-3-1 is 4
      * Thread: Thread-0-1 - Accessing Atomic Value
      * Atomic value for Thread Thread-0-1 is 4
      * Thread: Thread-1-1 - Accessing Atomic Value
      * Atomic value for Thread Thread-1-1 is 4
      * Thread: Thread-2-1 - Accessing Atomic Value
      * Atomic value for Thread Thread-2-1 is 4
      * Thread: Thread-4-1 - Accessing Atomic Value
      * Atomic value for Thread Thread-4-1 is 4
      * Thread: Thread-5-1 - Accessing Atomic Value
      * Atomic value for Thread Thread-5-1 is 4
      * Thread Thread-5 exiting.
      * Thread Thread-2 exiting.
      * Thread Thread-4 exiting.
      * Thread Thread-0 exiting.
      * Thread Thread-1 exiting.
      * Thread Thread-3 exiting.
      *
      * Process finished with exit code 0
      **/

     /*Credits: Google Tutorials Point and Baeldung*/
        }
    }
}

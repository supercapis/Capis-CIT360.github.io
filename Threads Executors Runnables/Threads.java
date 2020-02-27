import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static java.lang.Thread.*;

/**
 * This is a single program with multiple classes that incorporates threads, runnables, and executors.
 * This is a pattern that is very commonly used in software development.
 **/

/*Creating Threads*/
class myThreads extends Thread {
    public void run() {
        System.out.println("2 - Running Threads");
    }
}
/*Creating runnables*/
class myRunnables implements Runnable {
    public void run() {
        System.out.println("3 - Representing Runnable class");
    }
}
class ThreadsExecutorsRunnable {
/*Main class*/
    static class Main {
        public static void main(String[] args) {
            System.out.println("\n1 - Starting my Threads");

            myThreads Thread_1;
            Thread_1 = new myThreads();
            Thread_1.start();

            Thread Thread_2;
            Thread_2 = new Thread(new myRunnables());
            Thread_2.start();

            try {
                sleep(3000);
                System.out.println("4 - Sleeping for (3) two seconds");
            } catch (InterruptedException exception) {
                System.out.println("Exception working " + exception);
            }
            /*Executors*/
            ExecutorService myExecutors;
            myExecutors = Executors.newSingleThreadExecutor();
            myExecutors.submit(() -> {
                String threadName;
                threadName = currentThread().getName();
                System.out.println("6 - Thread and Pool name: " + threadName);
            });

            try {
                System.out.println("5 - Shutting down myExecutors");
                myExecutors.shutdown();

            } finally {
                if (myExecutors.isTerminated()) {
                    System.err.println("\nGood Bye");
                }
                myExecutors.shutdownNow();
                System.out.println("7 - Exiting threads");
            }

        }
    }
}
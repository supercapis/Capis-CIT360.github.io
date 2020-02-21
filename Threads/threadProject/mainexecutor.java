package threadProject;

class MainExecutor {

    static int numberOfThreadsToRun = 6;

    public static void main(String[] args) {
        for (int i = 0; i < numberOfThreadsToRun ; i++) {
            RunnableClass runnable = new RunnableClass("Thread-"+ i );
            runnable.startThread();
        }
    }
}

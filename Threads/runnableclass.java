
package threadProject;

/**
 * Create a Thread by Implementing a Runnable Interface
 **/
class RunnableClass implements Runnable {
/**
 * Instantiate the Thread object using the constructor below
 **/
    private AtomicClass atomicClass;
    private String threadName;
    private Thread myRunnableThread;

    RunnableClass(String threadName){
        this.threadName = threadName;
    }
    /**This override inherits and implements the method from the runnable interface**/
    @Override
    /**The objective of this method is to provide an entry point for the thread**/
    public void run() {
        System.out.println("Running " +  threadName );
    /**Creating the instance to call the atomic class**/
        atomicClass = new AtomicClass();

        try {
            /**In this "for loop" for each thread I start, I created 4 mini threads of it.
             * This same thread will get the values from the atomic class
             **/
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + "-" + i + " - Accessing Atomic Value");
                atomicClass.increment();
                int currentAtomic = atomicClass.getValue();
                System.out.println("Atomic value for Thread " + threadName + "-" + i + " is " + currentAtomic);
                Thread.sleep(100);
            }
            /**You will see it at the end of the output**/
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }
    /**After creating the thread object, you start it and calling the method below,
     * which executes a call to run()method
     * **/
    public void startThread(){
        System.out.println("Starting " +  threadName );
        if (myRunnableThread == null) {
            myRunnableThread = new Thread (this, threadName);
            myRunnableThread.start();
        }

    }
}

package threadProject;

class RunnableClass implements Runnable {

    private AtomicClass atomicClass;
    private String threadName;
    private Thread myRunnableThread;

    RunnableClass(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("Running " +  threadName );
        atomicClass = new AtomicClass();

        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + "-" + i + " - Accessing Atomic Value");
                atomicClass.increment();
                int currentAtomic = atomicClass.getValue();
                System.out.println("Atomic value for Thread " + threadName + "-" + i + " is " + currentAtomic);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void startThread(){
        System.out.println("Starting " +  threadName );
        if (myRunnableThread == null) {
            myRunnableThread = new Thread (this, threadName);
            myRunnableThread.start();
        }

    }
}

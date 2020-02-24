package threadProject;

import java.util.concurrent.atomic.AtomicInteger;
    /**Creation of Atomic class - their objective is to read and write from the variable**/
class AtomicClass {
    /**The variable counter starts with "0"**/
    private final AtomicInteger counter = new AtomicInteger(0);

    /**The getValue returns the variable counter, which pulls its value "0" **/
    public int getValue() {
        return counter.get();
    }

    /**The while loop uses compareAndSet() and combines three steps below:
     * 1) getting the value,
     * 2)comparing the value and
     * 3)updating the value – into a single machine level operation.**/
    public void increment() {
        while(true) {
            int existingValue = getValue();
            int newValue = existingValue + 1;
            if(counter.compareAndSet(existingValue, newValue)) {
                return;
    /**More detailed explanation of what happened above:
     * When multiple threads attempt to update the same value through compare-and-swap(CAS), one of them wins and updates the value.
     * However, unlike in the case of locks, no other thread gets suspended; instead, they're simply informed that they
     * did not manage to update the value. The threads can then proceed to do further work and context switches are completely avoided.,
     * returns true when it succeeds, else false
     **/
            }
        }
    }

}

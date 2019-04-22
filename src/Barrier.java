package BarrierS;
import java.util.concurrent.Semaphore;

public class Barrier {
	
	// add missing variables
	int size; // number of threads
	int counter = 0; // variable that will be accessed by all threads, checks number of threads at barrier. 
	int held = 1; 
	int unheld = 0;

	public Semaphore arrival = new Semaphore(held);
    public Semaphore departure = new Semaphore(unheld);
	
	Barrier(int n) {
		// complete this constructor
		this.size = n;	
	}
	
	
	public void b_wait() throws InterruptedException{
		// this is the only additional method you will need to complete

		// acquire arrival and set arrival to o 
        arrival.acquire(); // arrival = 0, blocks other threads from accessing counter
        // modify counter 
        counter++; // critical section 
        // check if counter is less than number of theads
        if (counter < size) { 
            arrival.release(); // release counter after modification. Notify other threads.
        }else{
        	// line will be executed if counter > size 
        	// should be executed once final thread has modified counter. 
            departure.release(); 
        }

        departure.acquire(); 
        counter--; // critical section 
        if (counter > 0) {
            departure.release();
	    }
	}
}

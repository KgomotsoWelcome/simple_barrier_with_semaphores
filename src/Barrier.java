package BarrierS;
import java.util.concurrent.Semaphore;

public class Barrier {
	
	// add missing variables
	int size;
	public Semaphore sem;
	
	Barrier(int n) {
		// complete this constructor
		this.size = n;
		sem = new Semaphore(1);
	}

	
	public void b_wait() throws InterruptedException{
		// this is the only additional method you will need to complete
		try {
      		
     		sem.acquire();
      		
	    } catch (InterruptedException e) {
	      	e.printStackTrace();
	    }
	    finally{
	    	sem.release();
	    }
	}

}

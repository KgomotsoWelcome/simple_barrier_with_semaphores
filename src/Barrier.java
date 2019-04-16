package BarrierS;
import java.util.concurrent.Semaphore;

public class Barrier {
	
	// add missing variables
	int size;
	
	Barrier(int n) {
		// complete this constructor
		this.size = n;	
	}
	public Semaphore arrival = new Semaphore(1);
    public Semaphore departure = new Semaphore(0);
	int counter = 0;
	
	public void b_wait() throws InterruptedException{
		// this is the only additional method you will need to complete
		/*
		arrival.acquire();
		counter++;
		arrival.release();

		if(counter == size){
			departure.release();
		}

		departure.acquire();
		departure.release();
		*/
		
        arrival.acquire();
        counter++;
        if (counter < size) {
            arrival.release();
        }else{
            departure.release();
        }

        departure.acquire();
        counter--;
        if (counter > 0) {
            departure.release();
	    }
	}

}

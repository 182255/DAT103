package bounded_buffer;

import java.util.concurrent.Semaphore;

public class Q {
	int n;
	static Semaphore semCon = new Semaphore(0);
	static Semaphore semProd = new Semaphore(1);

	void get() {
		try {
			// before consumer can consume an item,
			// it must acquire a permit from semCon
			semCon.acquire();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException caught");
		}
		// consumer consuming an item
		System.out.println("Consumer consumed item: " + n);

		// After consumer consumes the item,
		// it releases semProd to notify producer
		semProd.release();
	}

	// to put an item in buffer
	void put(int item) {
		try {
			// Before producer can produce an item,
			// it must acquire a permit from semProd
			semProd.acquire();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException caught");
		}

		// producer producing an item
		n = item;

		System.out.println("Producer produced item : " + item);

		// After producer produces the item,
		// it releases semCon to notify consumer
		semCon.release();
	}
}

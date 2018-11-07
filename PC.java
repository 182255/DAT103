package bounded_buffer;
//Driver class
public class PC {

	public static void main(String[] args) {
		// creating buffer queue
		Q q = new Q();
		
		new Consumer(q) ;
		new Producer(q);
	}
}

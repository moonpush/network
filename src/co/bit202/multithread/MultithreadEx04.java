package co.bit202.multithread;

public class MultithreadEx04 {
	
	public static void main(String[] args) {
	 Thread thread1 = new DigitThread();
	 Thread thread2 = new Thread(new AlphabetRunnableImpl2());
	 
	 thread1.start();
	 thread2.start();
		
	}

}

package co.bit202.multithread;

public class MultithreadEx03 {

	public static void main(String[] args) {
		Thread thread1 = new DigitThread();
		Thread thread2 = new Thread(new AlphabetRunnableImpl());
		
		thread1.start();
		thread2.start();
		

	}

}

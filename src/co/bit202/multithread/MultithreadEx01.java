package co.bit202.multithread;

public class MultithreadEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread = new DigitThread();
		thread.start();
		
		for(char c = 'A'; c<='Z'; c++){
			System.out.print(c);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

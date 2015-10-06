package co.bit202.multithread;

public class AlphabetRunnableImpl implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
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

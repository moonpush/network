package co.bit202.multithread;

public class AlphabetThread extends Thread {

	@Override
	public void run() {
		for(char c = 'A'; c<='Z'; c++){
			System.out.print(c);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// TODO Auto-generated method stub
		super.run();
	}

	
}

package src.com.examSystem.onlineExam;

public class TimerThread extends Thread {
	long t;

	public TimerThread(long tm) {
		this.t = tm;
	}

	public void run() {
		try {
			this.sleep(t);
			
		} catch (InterruptedException e) {
			//e.printStackTrace();
			System.out.println("Visit Next Time.");
		}
	}
}

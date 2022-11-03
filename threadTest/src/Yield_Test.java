public class Yield_Test {
	private static final int RUNNING_TIME = 2500;
	

	public static void main(String[] args) {
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		
		// threadA,B start
		System.out.println("ThreadA and ThreadB : simultaneous start");
		threadA.start();
		threadB.start();
		
		try {
			Thread.sleep(RUNNING_TIME);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}

		// only threadB start
		System.out.println("ONLY ThreadB start");
		threadA.setFlag(false);
		
		try {
			Thread.sleep(RUNNING_TIME);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}

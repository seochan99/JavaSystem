class ThreadB extends Thread{
	private boolean stop = false;
	private boolean flag = true;
	private static final int DELAY_TIME = 500;
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	public void run() {
		while(!stop) {
//			if(flag) {
//				System.out.println("THREAD B IS WORKING");
//			}else {
//				// flag false-> other thread
//				Thread.yield();
//			}
			try{
				Thread.sleep(DELAY_TIME);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

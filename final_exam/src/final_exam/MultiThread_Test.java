package final_exam;

public class MultiThread_Test {

	public static void main(String[] args) {
		ThreadClass_s thread1 = new ThreadClass_s ();
		thread1.setName("첫 번째 thread");
		thread1.start();
		
		ThreadClass_s thread2 = new ThreadClass_s ();
		thread2.setName("두 번째 thread");
		thread2.start();
		try {
			thread2.join();
			thread1.join();
		}catch(Exception e) {
		}
		System.out.println("프로그램 종료");

	}
}

class ThreadClass_s extends Thread{
	@Override
	public void run() {
		for(int i=0;i<10;i++)
		{
			System.out.println(Thread.currentThread().getName() + " : " + (i+1));
		}
	}
}

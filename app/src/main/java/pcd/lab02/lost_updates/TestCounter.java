package pcd.lab02.lost_updates;

public class TestCounter {

	public static void main(String[] args) throws Exception {
		int ntimes = 100000000;// Integer.parseInt(args[0]);
		UnsafeCounter c = new UnsafeCounter(0);
		Object lock = new Object();
		Worker w1 = new Worker(c, ntimes, lock);
		Worker w2 = new Worker(c, ntimes, lock);

		Cron cron = new Cron();
		cron.start();
		w1.start();
		w2.start();
		w1.join();
		w2.join();
		cron.stop();
		System.out.println("Counter final value: " + c.getValue() + " in " + cron.getTime() + "ms.");

	}
}

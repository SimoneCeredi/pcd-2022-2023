package pcd.lab02.lost_updates;

public class Worker extends Thread {

	private UnsafeCounter counter;
	private int ntimes;
	private Object lock;

	public Worker(UnsafeCounter c, int ntimes, Object lock) {
		counter = c;
		this.ntimes = ntimes;
		this.lock = lock;
	}

	public Worker(UnsafeCounter c, int ntimes) {
		counter = c;
		this.ntimes = ntimes;
		this.lock = null;
	}

	public void run() {
		for (int i = 0; i < ntimes; i++) {
			if (this.lock != null) {
				synchronized (this.lock) {
					counter.inc();
				}
			} else {
				counter.inc();
			}
		}
	}
}

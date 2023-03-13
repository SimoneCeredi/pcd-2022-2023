package pcd.lab02.lost_updates;

public class Worker2 extends Thread {

    private UnsafeCounter counter;
    private int ntimes;

    public Worker2(UnsafeCounter c, int ntimes) {
        counter = c;
        this.ntimes = ntimes;
    }

    public void run() {
        for (int i = 0; i < ntimes; i++) {
            counter.inc();
        }
    }
}

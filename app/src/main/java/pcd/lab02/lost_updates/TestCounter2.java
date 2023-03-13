package pcd.lab02.lost_updates;

public class TestCounter2 {
    public static void main(String[] args) throws Exception {
        int ntimes = 100000000;// Integer.parseInt(args[0]);
        UnsafeCounter c = new UnsafeCounter(0);
        Worker2 w1 = new Worker2(c, ntimes);
        Worker2 w2 = new Worker2(c, ntimes);

        Cron cron = new Cron();
        cron.start();
        w1.start();
        w2.start();
        w1.join();
        w2.join();
        cron.stop();
        System.out.println("Unsafe Counter final value: " + c.getValue() + " in " + cron.getTime() + "ms.");
    }
}
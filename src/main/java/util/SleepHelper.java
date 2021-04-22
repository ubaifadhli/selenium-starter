package util;

public class SleepHelper {
    public static void sleepForSeconds(int second) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

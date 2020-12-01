package wit.edu.comp1050;

import java.util.Timer;
import java.util.TimerTask;

public class TimerThread extends Thread{
    int i = 120;
    public void run(){
        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                i--;
                if (i < 0) {
                    timer.cancel();
                    System.out.println("\nYou have run out of time.");
                    System.exit(0);
                }
            }
        }, 0, 1000);
    }

    public int getI() {
        return i;
    }
}

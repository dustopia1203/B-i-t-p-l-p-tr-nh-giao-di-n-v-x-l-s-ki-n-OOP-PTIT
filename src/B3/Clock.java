package B3;

import javax.swing.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Clock extends JPanel implements Runnable {
    private int hour, minute, second;
    Thread clockThread;

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public Clock() {
        clockThread = new Thread(this);
        clockThread.start();
    }

    void update() {
        Calendar calendar = new GregorianCalendar();
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
    }

    @Override
    public void run() {
        int tmp = second;
        while (clockThread != null) {
            update();
            if (second - tmp > 0) {
                repaint();
            }
        }
    }
}

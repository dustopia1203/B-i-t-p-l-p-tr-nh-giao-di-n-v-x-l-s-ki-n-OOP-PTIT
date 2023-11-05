package B3;

import java.awt.*;

public class RoundClock extends Clock {
    public RoundClock() {
        setPreferredSize(new Dimension(800, 500));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw clock
        int clockRadius = (int) (Math.min(getWidth(), getHeight()) * 0.8 * 0.5);
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        // Draw circle
        g.setColor(Color.black);
        g.drawOval(xCenter - clockRadius, yCenter - clockRadius, 2 * clockRadius, 2 * clockRadius);
        g.drawString("12", xCenter - 5, yCenter - clockRadius + 12);
        g.drawString("9", xCenter - clockRadius + 3, yCenter + 5);
        g.drawString("3", xCenter + clockRadius - 10, yCenter + 3);
        g.drawString("6", xCenter - 3, yCenter + clockRadius - 3);
        // Draw second hand
        int sLength = (int) (clockRadius * 0.8);
        int xSecond = (int) (xCenter + sLength * Math.sin(getSecond() * (2 * Math.PI / 60)));
        int ySecond = (int) (yCenter - sLength * Math.cos(getSecond() * (2 * Math.PI / 60)));
        g.setColor(Color.red);
        g.drawLine(xCenter, yCenter, xSecond, ySecond);
        // Draw minute hand
        int mLength = (int) (clockRadius * 0.65);
        int xMinute = (int) (xCenter + mLength * Math.sin(getMinute() * (2 * Math.PI / 60)));
        int yMinute = (int) (yCenter - mLength * Math.cos(getMinute() * (2 * Math.PI / 60)));
        g.setColor(Color.blue);
        g.drawLine(xCenter, yCenter, xMinute, yMinute);
        // Draw hour hand
        int hLength = (int) (clockRadius * 0.5);
        int xHour = (int) (xCenter + hLength * Math.sin((getHour() % 12 + getMinute() / 60.0) * (2 * Math.PI / 12)));
        int yHour = (int) (yCenter - hLength * Math.cos((getHour() % 12 + getMinute() / 60.0) * (2 * Math.PI / 12)));
        g.setColor(Color.BLACK);
        g.drawLine(xCenter, yCenter, xHour, yHour);
    }
}

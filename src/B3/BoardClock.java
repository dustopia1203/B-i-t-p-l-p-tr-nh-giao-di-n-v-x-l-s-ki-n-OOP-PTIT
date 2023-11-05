package B3;

import javax.swing.*;
import java.awt.*;

public class BoardClock extends Clock {
    public BoardClock() {
        setPreferredSize(new Dimension(800, 100));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        String text = String.format("%02d : %02d : %02d", getHour(), getMinute(), getSecond());
        FontMetrics fm = g.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(text)) / 2;
        int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
        g.drawString(text, x, y);
    }
}

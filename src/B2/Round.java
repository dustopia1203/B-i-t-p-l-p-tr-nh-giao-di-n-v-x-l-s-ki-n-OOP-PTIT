package B2;

import java.awt.*;

public class Round extends Shape {
    private int val;

    public Round(int val, boolean isSolid) {
        this.val = val;
        setSolid(isSolid);
    }

    @Override
    public void draw(Graphics g) {
        if (isSolid()) g.fillOval(10, 10, val, val);
        else g.drawOval(10, 10, val, val);
    }
}

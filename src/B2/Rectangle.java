package B2;

import java.awt.*;

public class Rectangle extends Shape {
    private int val1, val2;

    public Rectangle(int val1, int val2, boolean isSolid) {
        this.val1 = val1;
        this.val2 = val2;
        setSolid(isSolid);
    }

    @Override
    public void draw(Graphics g) {
        if (isSolid()) g.fillRect(10, 10, val1, val2);
        else g.drawRect(10, 10, val1, val2);
    }
}

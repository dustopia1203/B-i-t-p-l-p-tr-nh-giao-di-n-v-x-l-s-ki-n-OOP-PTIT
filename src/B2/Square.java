package B2;

import java.awt.*;

public class Square extends Shape {
    private int val;

    public Square(int val, boolean isSolid) {
        this.val = val;
        setSolid(isSolid);
    }

    @Override
    public void draw(Graphics g) {
        if (isSolid()) g.fillRect(10, 10, val, val);
        else g.drawRect(10, 10, val, val);
    }
}

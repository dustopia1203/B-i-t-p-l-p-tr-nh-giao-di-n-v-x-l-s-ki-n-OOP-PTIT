package B2;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Polygon extends Shape {
    private int[] x, y;

    public Polygon(ArrayList<Integer> a, ArrayList<Integer> b, boolean isSolid) {
        x = new int[a.size()];
        y = new int[b.size()];
        for (int i = 0; i < a.size(); i++) {
            x[i] = a.get(i);
            y[i] = b.get(i);
        }
        setSolid(isSolid);
    }

    @Override
    public void draw(Graphics g) {
        if (isSolid()) g.fillPolygon(x, y, x.length);
        else g.drawPolygon(x, y, x.length);
    }
}

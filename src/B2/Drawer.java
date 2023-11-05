package B2;

import javax.swing.*;
import java.awt.*;

public class Drawer extends JPanel {
    private Shape shape;
    private Color shapeColor;

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void setShapeColor(Color color) {
        shapeColor = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(shapeColor);
        if (shape != null) shape.draw(g);
        repaint();
    }
}

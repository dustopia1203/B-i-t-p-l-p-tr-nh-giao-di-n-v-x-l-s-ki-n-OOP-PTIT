package B2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Frame extends JFrame implements ActionListener {
    private String[] options = {"(Choose shape to draw)", "Square", "Rectangle", "Round", "Polygon"};
    private JComboBox jc = new JComboBox(options);
    private JCheckBox checkSolid = new JCheckBox("Solid");
    private JButton confirm = new JButton("Confirm");
    private JButton colorPicker = new JButton("Choose shape color");
    private JPanel controller = new JPanel();
    private Drawer drawer = new Drawer();

    public Frame() {
        // main frame
        setTitle("Shape Drawer");
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(drawer, BorderLayout.CENTER);
        add(controller, BorderLayout.SOUTH);
        // drawer

        // controller
        controller.setLayout(new FlowLayout());
        controller.add(jc);
        controller.add(checkSolid);
        controller.add(colorPicker);
        controller.add(confirm);
        // confirm button
        confirm.setFocusable(false);
        confirm.addActionListener(this);
        // color picker
        colorPicker.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tmp, tmp1, tmp2;
        boolean isSolid = checkSolid.isSelected();
        if (e.getSource() == colorPicker) {
            Color color = JColorChooser.showDialog(null, "Choose shape color", Color.BLACK);
            drawer.setShapeColor(color);
        }
        if (e.getSource() == confirm) {
            switch (jc.getSelectedItem().toString()) {
                case "Square":
                    tmp = JOptionPane.showInputDialog("Type the edge value");
                    if (tmp != null) {
                        try {
                            int val = Integer.parseInt(tmp);
                            drawer.setShape(new Square(val, isSolid));
                        } catch (Exception ext) {
                            JOptionPane.showMessageDialog(this, "Invalid value", "Error!", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case "Rectangle":
                    tmp1 = JOptionPane.showInputDialog("Type the edge 1 value");
                    tmp2 = JOptionPane.showInputDialog("Type the edge 2 value");
                    if (tmp1 != null && tmp2 != null) {
                        try {
                            int val1 = Integer.parseInt(tmp1);
                            int val2 = Integer.parseInt(tmp2);
                            drawer.setShape(new Rectangle(val1, val2, isSolid));
                        } catch (Exception ext) {
                            JOptionPane.showMessageDialog(this, "Invalid value", "Error!", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case "Round":
                    tmp = JOptionPane.showInputDialog("Type the diameter value");
                    if (tmp != null) {
                        try {
                            int val = Integer.parseInt(tmp);
                            drawer.setShape(new Round(val, isSolid));
                        } catch (Exception ext) {
                            JOptionPane.showMessageDialog(this, "Invalid value", "Error!", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case "Polygon":
                    tmp = JOptionPane.showInputDialog("Type the vertex amounts");
                    if (tmp != null) {
                        try {
                            int val = Integer.parseInt(tmp);
                            int x, y;
                            ArrayList<Integer> a = new ArrayList<>();
                            ArrayList<Integer> b = new ArrayList<>();
                            for (int i = 1; i <= val; i++) {
                                x = Integer.parseInt(JOptionPane.showInputDialog("Type the x" + i + " value"));
                                y = Integer.parseInt(JOptionPane.showInputDialog("Type the y" + i + " value"));
                                a.add(x);
                                b.add(y);
                                drawer.setShape(new Polygon(a, b, isSolid));
                            }
                        } catch (Exception ext) {
                            JOptionPane.showMessageDialog(this, "Invalid value", "Error!", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
            }
        }
    }
}

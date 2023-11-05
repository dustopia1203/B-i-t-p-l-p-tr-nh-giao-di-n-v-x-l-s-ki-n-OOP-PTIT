package B1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorModifier extends JFrame implements ActionListener {
    private JPanel colorPanel = new JPanel();
    private JPanel controlPanel = new JPanel();
    private JButton colorChooser = new JButton("Choose a color");
    public ColorModifier() {
        // set window
        setTitle("Color Modifier");
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(colorPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        // color panel

        // control panel
        controlPanel.setBackground(Color.LIGHT_GRAY);
        controlPanel.add(colorChooser);
        // color chooser
        colorChooser.addActionListener(this);
        colorChooser.setFocusable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == colorChooser) {
            Color color = JColorChooser.showDialog(null, "Pick color you want", Color.BLACK);
            colorPanel.setBackground(color);
        }
    }
}

package B6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {
    private JButton b1 = new JButton("J01001");
    private JButton b2 = new JButton("J01002");
    private JButton b3 = new JButton("J01003");
    private JButton b4 = new JButton("J01004");
    private JButton b5 = new JButton("J01005");

    public Frame() {
        // main frame
        setTitle("Code.ptit Problems");
        setSize(800, 600);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout());
        //add buttons
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            new J01001S();
        }
        if (e.getSource() == b2) {
            new J01002S();
        }
        if (e.getSource() == b3) {
            new J01003S();
        }
        if (e.getSource() == b4) {
            new J01004S();
        }
        if (e.getSource() == b5) {
            new J01005S();
        }
    }
}

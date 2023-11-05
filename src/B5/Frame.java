package B5;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class Frame extends JFrame implements ActionListener {
    private JTextField width = new JTextField("800"), height = new JTextField("600");
    private JLabel w = new JLabel("Width:"), h = new JLabel("Height");
    private JPanel picture = new JPanel(), control = new JPanel();
    private JButton fc = new JButton("Choose picture"), confirm = new JButton("Change Frame Size");

    public Frame() {
        // main frame
        setTitle("Picture Chooser");
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(picture, BorderLayout.CENTER);
        add(control, BorderLayout.SOUTH);
        // picture panel
        picture.setLayout(new FlowLayout());
        // control
        control.setBackground(Color.LIGHT_GRAY);
        control.setLayout(new FlowLayout());
        control.add(fc);
        control.add(w);
        control.add(width);
        control.add(h);
        control.add(height);
        control.add(confirm);
        // file chooser
        fc.addActionListener(this);
        fc.setFocusable(false);
        // confirm button
        confirm.addActionListener(this);
        confirm.setFocusable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fc) {
            JFileChooser jfc = new JFileChooser();
            int result = jfc.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    BufferedImage pic = ImageIO.read(new File(jfc.getSelectedFile().getAbsolutePath()));
                    picture.add(new Picture(pic));
                    setVisible(true);
                } catch (Exception ext) {
                    JOptionPane.showMessageDialog(null, "Error!", "Failure", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (e.getSource() == confirm) {
            setSize(Integer.parseInt(width.getText()), Integer.parseInt(height.getText()));
            setLocationRelativeTo(null);
            setVisible(true);
        }
    }
}

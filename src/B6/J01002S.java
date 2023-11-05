package B6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class J01002S extends JFrame implements ActionListener {
    private JPanel p1 = new JPanel(), p2 = new JPanel();
    private JLabel l1 = new JLabel("Số bộ test: "), l2 = new JLabel("Số nguyên dương N: "), result = new JLabel();
    private JTextField t1 = new JTextField(""), t2 = new JTextField("");
    private JButton ok = new JButton("OK");
    private TextArea txt = new TextArea("""
            Cho số nguyên dương N.
            Hãy tính S = 1 + 2 + ... + N
            """);

    public J01002S() {
        // main frame
        setTitle("J01002 Solution");
        setSize(800, 600);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(txt, BorderLayout.NORTH);
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        // display panel
        p1.add(result);
        //control panel
        p2.setBackground(Color.LIGHT_GRAY);
        p2.add(l1);
        t1.setPreferredSize(new Dimension(100, 50));
        p2.add(t1);
        p2.add(l2);
        t2.setPreferredSize(new Dimension(100, 50));
        p2.add(t2);
        p2.add(ok);
        // ok button
        ok.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            if (!t1.getText().equals("0")){
                try {
                    int t = Integer.parseInt(t1.getText());
                    int n = Integer.parseInt(t2.getText());
                    long s = (long) n * (n + 1) / 2;
                    result.setText("S = 1 + 2 + ... + N = " + s);
                    t--;
                    t1.setText(String.valueOf(t));
                } catch (Exception ext) {
                    JOptionPane.showMessageDialog(null, "Error", "Failure", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}

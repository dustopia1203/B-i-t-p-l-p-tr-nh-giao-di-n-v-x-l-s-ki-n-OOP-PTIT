package B6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class J01005S extends JFrame implements ActionListener {
    private JPanel p1 = new JPanel(), p2 = new JPanel();
    private JLabel l1 = new JLabel("Số bộ test:"), l2 = new JLabel("Số phần cần chia N:"), l3 = new JLabel("Chiều cao H:"), result = new JLabel();
    private JTextField t1 = new JTextField(""), t2 = new JTextField(""), t3 = new JTextField("");
    private JButton ok = new JButton("OK");
    private TextArea txt = new TextArea("""
            Cho một tam giác cân có độ dài đáy bằng 1 và chiều cao bằng H.
            Bạn cần chia tam giác này thành N phần có diện tích bằng nhau và song song với đáy.                                                                    
            """);

    public J01005S() {
        // main frame
        setTitle("J01001 Solution");
        setSize(800, 600);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(txt, BorderLayout.NORTH);
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        // display panel
        p1.add(result);
        // control panel
        p2.setBackground(Color.LIGHT_GRAY);
        p2.add(l1);
        t1.setPreferredSize(new Dimension(100, 50));
        p2.add(t1);
        p2.add(l2);
        t2.setPreferredSize(new Dimension(100, 50));
        p2.add(t2);
        p2.add(l3);
        t3.setPreferredSize(new Dimension(100, 50));
        p2.add(t3);
        p2.add(ok);
        // ok button
        ok.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            if (!t1.getText().equals("0")) {
                try {
                    int t = Integer.parseInt(t1.getText());
                    int n = Integer.parseInt(t2.getText());
                    int h = Integer.parseInt(t3.getText());
                    String res = "";
                    for (int i = 1; i < n; i++)
                        res += String.format("%.6f ", (double) h * Math.sqrt((double) i / n));
                    result.setText("Chiều cao các tam giác sau chia lần lượt là: " + res);
                    t--;
                    t1.setText(String.valueOf(t));
                } catch (Exception ext) {
                    JOptionPane.showMessageDialog(null, "Error", "Failure", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}

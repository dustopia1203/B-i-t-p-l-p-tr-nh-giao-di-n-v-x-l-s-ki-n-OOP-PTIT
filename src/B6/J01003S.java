package B6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class J01003S extends JFrame implements ActionListener {
    private JPanel p1 = new JPanel(), p2 = new JPanel();
    private JLabel l1 = new JLabel("a:"), l2 = new JLabel("b:"), result = new JLabel();
    private JTextField t1 = new JTextField(""), t2 = new JTextField("");
    private JButton ok = new JButton("OK");
    private TextArea txt = new TextArea("""
            Phương trình bậc nhất là phương trình dạng ax + b = 0.
            Viết chương trình nhập vào hệ số a,b là các số thực và thực hiện giải phương trình bậc nhất.
            Nếu phương trình vô nghiệm thì in ra VN
            Nếu phương trình có vô số nghiệm thì in ra VSN
            Nếu phương trình có nghiệm duy nhất thì in ra với định dạng luôn 2 chữ số thập phân.
            """);

    public J01003S() {
        // main frame
        setTitle("J01003 Solution");
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
        p2.add(ok);
        // ok button
        ok.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            try {
                double a = Double.parseDouble(t1.getText());
                double b = Double.parseDouble(t2.getText());
                if (a == 0) {
                    if (b == 0) result.setText("Kết quả: Vô số nghiệm");
                    else result.setText("Kết quả: Vô nghiệm");
                } else result.setText(String.format("Kết quả: %.2f\n", -b / a));
            } catch (Exception ext) {
                JOptionPane.showMessageDialog(null, "Error", "Failure", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

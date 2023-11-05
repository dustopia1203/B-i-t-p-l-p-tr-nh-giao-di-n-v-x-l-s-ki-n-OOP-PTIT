package B6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class J01001S extends JFrame implements ActionListener {
    private JPanel p1 = new JPanel(), p2 = new JPanel();
    private JLabel l1 = new JLabel("Độ dài cạnh 1:"), l2 = new JLabel("Độ dài cạnh 2:"), p = new JLabel(), s = new JLabel();
    private JTextField t1 = new JTextField(""), t2 = new JTextField("");
    private JButton ok = new JButton("OK");
    private TextArea txt = new TextArea("""
            Cho độ dài hai cạnh của hình chữ nhật. Giá trị không quá 104.
            Viết chương trình tính chu vi và diện tích của hình chữ nhật đó.
            Nếu dữ liệu không hợp lệ (chiều dài hoặc chiều rộng ≤ 0 thì in ra số 0)
            """);

    public J01001S() {
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
        p1.setLayout(new GridLayout(2, 1));
        p1.add(p);
        p1.add(s);
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

    public void solution() {
        try {
            int a = Integer.parseInt(t1.getText());
            int b = Integer.parseInt(t2.getText());
            if (a <= 0 || b <= 0) throw new Exception();
            else {
                int p = 2 * (a + b);
                int s = a * b;
                this.p.setText("Chu vi: " + p);
                this.s.setText("Diện tích: " + s);
            }
        } catch (Exception ext) {
            JOptionPane.showMessageDialog(null, "Error", "Failure", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            solution();
            p.repaint();
            s.repaint();
        }
    }
}

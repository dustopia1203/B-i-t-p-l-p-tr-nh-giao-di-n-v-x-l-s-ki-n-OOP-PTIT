package B6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class J01004S extends JFrame implements ActionListener {
    private JPanel p1 = new JPanel(), p2 = new JPanel();
    private JLabel l1 = new JLabel("Số bộ test:"), l2 = new JLabel("Số nguyên:"), result = new JLabel();
    private JTextField t1 = new JTextField(""), t2 = new JTextField("");
    private JButton ok = new JButton("OK");
    private TextArea txt = new TextArea("""
            Viết chương trình kiểm tra một số nguyên dương có phải số nguyên tố hay không.
            Dòng đầu của dữ liệu vào ghi số bộ test.
            Mỗi dòng tiếp theo có một nguyên dương không quá 9 chữ số.
            Kết quả in ra YES nếu đó là số nguyên tố, in ra NO nếu ngược lại.
            """);

    public J01004S() {
        // main frame
        setTitle("J01004 Solution");
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

    public static boolean prime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            if (!t1.getText().equals("0")) {
                try {
                    int t = Integer.parseInt(t1.getText());
                    int n = Integer.parseInt(t2.getText());
                    if (prime(n)) result.setText(n + " là số nguyên tố.");
                    else result.setText(n + " không là số nguyên tố.");
                    t--;
                    t1.setText(String.valueOf(t));
                } catch (Exception ext) {
                    JOptionPane.showMessageDialog(null, "Error", "Failure", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}

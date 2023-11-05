package B7;

import B5.Picture;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class Frame extends JFrame implements ActionListener {
    private JPanel control = new JPanel();
    private JButton data = new JButton("Data"), ok = new JButton("OK");
    private JComboBox groupBy = new JComboBox(new String[]{"(GroupBy)", "Ascending", "Descending"});
    private JComboBox key = new JComboBox(new String[]{"(Key)", "Name", "Date of Birth", "Total point"});
    private JTable table = new JTable();
    private DefaultTableModel tmodel = new DefaultTableModel();
    private ArrayList<Student> a = new ArrayList<>();

    public Frame() {
        // main frame
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(control, BorderLayout.SOUTH);
        //table
        tmodel.addColumn("Name");
        tmodel.addColumn("Date of birth");
        tmodel.addColumn("Total Point");
        table.setModel(tmodel);
        add(new JScrollPane(table), BorderLayout.CENTER);
        // control panel
        control.add(data);
        control.add(key);
        control.add(groupBy);
        control.add(ok);
        // data button
        data.setFocusable(false);
        data.addActionListener(this);
        // confirm button
        ok.setFocusable(false);
        ok.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == data) {
            JFileChooser jfc = new JFileChooser();
            int returnValue = jfc.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                try {
                    String path = jfc.getSelectedFile().getAbsolutePath();
                    Scanner scn = new Scanner(new File(path));
                    a.clear();
                    while (scn.hasNextLine()) {
                        a.add(new Student(scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextLine()));
                    }
                } catch (Exception ext) {
                    ext.printStackTrace();
                }
            }
        } else if (e.getSource() == ok) {
            for (Student i : a) i.setComparator(Objects.requireNonNull(key.getSelectedItem()).toString());
            if (Objects.requireNonNull(groupBy.getSelectedItem()).toString().equals("Ascending")) Collections.sort(a);
            else Collections.sort(a, Collections.reverseOrder());
            int len = a.size();
            Object[][] data = new Object[len][3];
            tmodel.setRowCount(0);
            for (int i = 0; i < len; i++) {
                data[i] = a.get(i).toObject();
                tmodel.addRow(data[i]);
            }
        }
    }
}

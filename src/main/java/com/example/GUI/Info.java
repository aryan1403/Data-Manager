package com.example.GUI;

import com.example.Helpers.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.util.List;
import java.util.ArrayList;

public class Info implements ActionListener, meow {
    JFrame frame = new JFrame();

    JLabel mainpanel = new JLabel();

    JTextField quesArea = new JTextField();

    JButton submit = new JButton();
    JButton choose = new JButton();

    JFileChooser j = new JFileChooser();

    File xfile;

    // ------------------- variables ------------------------

    private final int fwidth = 900;
    private final int fheight = 700;

    private final Color primaryColor = new Color(23, 23, 23);

    private String filename = "";
    private String imagename;

    private List<String> imagelist = new ArrayList<String>();

    Image image;
    ImageIcon icon;

    @Override
    public void start() {
        init();
        quesArea.setBounds(330, 200, 400, 50);
        quesArea.setOpaque(false);
        quesArea.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
        quesArea.setForeground(Color.white);
        quesArea.setFont(new Font("Aerial", Font.PLAIN, 20));
        quesArea.setVisible(true);
        quesArea.addActionListener(this);

        submit.setBounds(620, 550, 150, 50);
        submit.setText("Next  >");
        submit.setFont(new Font("Comic Sans", Font.BOLD + Font.ITALIC, 30));
        submit.setFocusable(false);
        submit.setOpaque(false);
        submit.setContentAreaFilled(false);
        submit.setBorderPainted(false);
        submit.setForeground(Color.white);
        submit.addActionListener(this);

        choose.setBounds(120, 200, 150, 50);
        choose.setText("Choose");
        choose.setFont(new Font("Comic Sans", Font.BOLD + Font.ITALIC, 28));
        choose.setFocusable(false);
        choose.setContentAreaFilled(false);
        choose.setForeground(Color.white);
        choose.setBorder(BorderFactory.createMatteBorder(2, 2, 0, 0, Color.white));
        choose.addActionListener(this);

        mainpanel.setBounds(0, 0, fwidth, fheight);
        mainpanel.setIcon(icon);
        mainpanel.setBackground(primaryColor);
        mainpanel.setLayout(null);
        mainpanel.add(quesArea);
        mainpanel.add(submit);
        mainpanel.add(j);
        mainpanel.add(choose);

        frame.setSize(fwidth, fheight);
        frame.setTitle("Quiz Manager");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);
        frame.setResizable(false);
        frame.add(mainpanel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == choose) {
            j.showSaveDialog(null);
            j.setBounds(250, 150, 50, 50);
            j.setOpaque(false);
            xfile = j.getSelectedFile();
            filename = xfile.getName();
            quesArea.setText(filename);
        }
        if (e.getSource() == submit) {
            frame.dispose();
            new Frame().start();
        }
    }

    @Override
    public int rImage(int n) {
        int result = (int) (Math.random() * n);
        return result;
    }

    @Override
    public void addImageToList() {
        imagelist.add("src/main/java/com/example/res/background2.jpg");
        imagelist.add("src/main/java/com/example/res/background.jpg");
    }

    @Override
    public void init() {
        addImageToList();
        imagename = imagelist.get(rImage(imagelist.size()));
        image = new ImageIcon(imagename).getImage().getScaledInstance(fwidth, fheight, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
    }
}

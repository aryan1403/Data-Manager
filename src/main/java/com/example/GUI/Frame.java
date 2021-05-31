package com.example.GUI;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.example.Helpers.meow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.awt.Color;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame implements ActionListener, meow {
    JFrame frame = new JFrame();
    JPanel dashboard = new JPanel();
    JLabel toplabel = new JLabel();
    JLabel semitop = new JLabel();
    JLabel toppanel = new JLabel();
    JLabel homelabel = new JLabel();
    JLabel homelabel2 = new JLabel();
    JPanel mainpanel = new JPanel();
    JPanel tilepanel = new JPanel();
    JPanel combopanel = new JPanel();

    JLabel homelabel3 = new JLabel();
    JLabel homelabel4 = new JLabel();

    JLabel homelabel5 = new JLabel();
    JLabel homelabel6 = new JLabel();

    JLabel homelabel7 = new JLabel();
    JLabel homelabel8 = new JLabel();

    JPanel tile1 = new JPanel();
    JPanel tile2 = new JPanel();
    JPanel tile3 = new JPanel();
    JPanel tile4 = new JPanel();

    JTextArea area = new JTextArea();
    JTextArea area2 = new JTextArea();

    ImageIcon homeicon = new ImageIcon("src/main/java/com/example/res/home.jpg");
    ImageIcon chaticon = new ImageIcon("src/main/java/com/example/res/data.png");
    ImageIcon bookicon = new ImageIcon("src/main/java/com/example/res/developer.jpg");
    ImageIcon mobileicon = new ImageIcon("src/main/java/com/example/res/settings.png");
    ImageIcon picon = new ImageIcon("src/main/java/com/example/res/pic.jpg");

    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();
    JTextField t4 = new JTextField();
    JTextField t5 = new JTextField();
    JTextField t6 = new JTextField();

    JButton b1 = new JButton("Submit");

    JLabel item1 = new JLabel("Ques 1");
    JLabel item2 = new JLabel("Ques 2");

    JPanel copyright = new JPanel();
    JLabel c = new JLabel("Manager Tool");
    JLabel c1 = new JLabel("© Manager Tool - for my sis ❤️");

    private final int X = 1000;
    private final int Y = 700;

    private final Color primaryColor = new Color(189, 0, 13);// 62, 1, 122
    // private final Color color = new Color(219, 71, 55); // 119, 34, 224

    String[] day = new String[30];
    String[] month = { "January", "Febraury", "March", "April", "May", "June", "July", "August", "September", "October",
            "November", "December" };
    String[] year = { "2021", "2022", "2023" };

    JComboBox<String> dayselector = new JComboBox<String>();
    JComboBox<String> monthselector = new JComboBox<String>(month);
    JComboBox<String> yearselector = new JComboBox<String>(year);

    int x = 0;

    String a = "";
    String b = "";
    String a2 = "";
    String a1 = "";
    String n = "";
    String n2 = "";

    public void Result() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Cats");

        String[][] bookData2 = {
                { "Date",
                        day[dayselector.getSelectedIndex()].trim() + " " + month[monthselector.getSelectedIndex()]
                                + ", " + year[yearselector.getSelectedIndex()] },
                { "Ques1", n }, { "Ques2", n2, }, { "Answers", a1, a2 } };

        // Object[][] bookData = { { Questext, AnswerText, 100 }, };

        int rowCount = 0;
        int columnCount = 0;

        /*
         * for (Object[] aBook : bookData) { Row row = sheet.createRow(rowCount);
         * 
         * for (Object field : aBook) { Cell cell = row.createCell(columnCount); if
         * (field instanceof String) { cell.setCellValue((String) field); } else if
         * (field instanceof Integer) { cell.setCellValue((Integer) field); }
         * columnCount++; }
         * 
         * rowCount++; }
         */

        for (String[] aBook : bookData2) {
            Row row = sheet.createRow(rowCount);

            for (Object field : aBook) {
                Cell cell = row.createCell(columnCount);
                cell.setCellValue((String) field);
                columnCount++;
            }
            rowCount++;
            columnCount = 0;
        }

        try (FileOutputStream outputStream = new FileOutputStream("meow.xlsx")) {
            System.out.println("Successfully Created the file!");
            workbook.write(outputStream);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void createTile(ImageIcon icon, String text, JPanel panel, JLabel ilabel, JLabel tlabel) {
        tlabel.setBounds(50, 200, 100, 50);
        tlabel.setBackground(Color.white);
        tlabel.setForeground(Color.white);
        tlabel.setIconTextGap(10);
        tlabel.setFont(new Font("Comic Sans", Font.BOLD, 14));
        tlabel.setLayout(null);

        ilabel.setBounds(15, 200, 50, 50);
        ilabel.setBackground(Color.white);
        ilabel.setText(text);
        ilabel.setFont(new Font("Comic Sans", Font.PLAIN, 17));
        ilabel.setIcon(icon);
        ilabel.setForeground(Color.black);

        panel.setBounds(5, 125 + x, 190, 45);
        panel.setBackground(Color.white);
        panel.add(ilabel);
        panel.add(tlabel);
        x += 55;
    }

    @Override
    public void start() {

        for (int i = 0; i < day.length; i++) {
            day[i] = (i + 1) + "              ";
            dayselector.addItem(day[i]);
        }

        toplabel.setBounds(20, 15, 150, 50);
        toplabel.setBackground(Color.white);
        toplabel.setText("Manager Tool");
        toplabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        toplabel.setFont(new Font("Aerial", Font.PLAIN, 24));
        toplabel.setForeground(Color.white);

        semitop.setBounds(20, 60, 150, 50);
        semitop.setBackground(Color.white);
        semitop.setText("We ❤️ Quizzes");
        semitop.setFont(new Font("San Serif", Font.PLAIN, 15));
        semitop.setForeground(Color.white);

        createTile(homeicon, "  Home              ", tile1, homelabel, homelabel2);

        createTile(chaticon, "  Database         ", tile2, homelabel3, homelabel4);

        createTile(bookicon, "  Developer        ", tile3, homelabel5, homelabel6);

        createTile(mobileicon, "  Settings           ", tile4, homelabel7, homelabel8);

        toppanel.setBounds(200, 0, 800, 70);
        toppanel.setOpaque(false);
        toppanel.setText("Manager Tool");
        toppanel.setFont(new Font("Comic Sans", Font.BOLD, 30));

        dashboard.setBounds(0, 0, 200, Y);
        dashboard.setBackground(primaryColor);
        dashboard.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 5, primaryColor));
        dashboard.setLayout(null);
        dashboard.add(toplabel);
        dashboard.add(semitop);
        dashboard.add(tile1);
        dashboard.add(tile2);
        dashboard.add(tile3);
        dashboard.add(tile4);

        dayselector.setBounds(0, 0, 70, 30);
        dayselector.setBackground(Color.white);
        dayselector.setForeground(Color.black);
        dayselector.setFont(new Font("Comic Sans", Font.ITALIC + Font.BOLD, 15));

        monthselector.setBounds(100, 0, 70, 30);
        monthselector.setBackground(Color.white);
        monthselector.setForeground(Color.black);
        monthselector.setFont(new Font("Comic Sans", Font.ITALIC + Font.BOLD, 15));

        yearselector.setBounds(200, 0, 100, 30);
        yearselector.setBackground(Color.white);
        yearselector.setForeground(Color.black);
        yearselector.setFont(new Font("Aerial", Font.ITALIC + Font.BOLD, 15));

        combopanel.setBounds(340, 200, 400, 50);
        combopanel.setBackground(Color.white);
        combopanel.add(dayselector);
        combopanel.add(monthselector);
        combopanel.add(yearselector);

        t1.setBounds(400, 120, 400, 50);
        t1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        t1.setFont(new Font("San Serif", Font.PLAIN, 20));
        t1.addActionListener(this);

        b1.setBounds(815, 130, 160, 40);
        b1.setFocusable(false);
        b1.setBackground(new Color(14, 167, 181));
        b1.setFont(new Font("San Serif", Font.PLAIN, 20));
        b1.setForeground(Color.white);
        b1.addActionListener(this);

        item1.setBounds(250, 270, 80, 40);
        item1.setForeground(Color.black);
        item1.setFont(new Font("Comic Sans", Font.BOLD + Font.ITALIC, 18));

        item2.setBounds(600, 270, 80, 40);
        item2.setForeground(Color.black);
        item2.setFont(new Font("Comic Sans", Font.BOLD + Font.ITALIC, 18));

        t3.setBounds(250, 320, 320, 40);
        t3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        t3.setFont(new Font("San Serif", Font.PLAIN, 18));
        t3.addActionListener(this);

        t6.setBounds(600, 320, 320, 40);
        t6.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        t6.setFont(new Font("San Serif", Font.PLAIN, 18));
        t6.addActionListener(this);

        area.setBounds(250, 380, 320, 150);
        area.setFont(new Font("San Serif", Font.PLAIN, 15));
        area.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.black));

        t4.setBounds(250, 555, 320, 30);
        t4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        t4.setFont(new Font("San Serif", Font.PLAIN, 15));

        area2.setBounds(600, 380, 320, 150);
        area2.setFont(new Font("San Serif", Font.PLAIN, 15));
        area2.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.black));

        t5.setBounds(600, 555, 320, 30);
        t5.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        t5.setFont(new Font("San Serif", Font.PLAIN, 15));

        c.setBounds(570, 600, 150, 30);
        c.setForeground(Color.white);
        c.setBackground(new Color(23, 23, 23));
        c.setFont(new Font("San Serif", Font.BOLD, 22));

        c1.setBounds(540, 630, 300, 30);
        c1.setForeground(Color.white);
        c1.setBackground(new Color(23, 23, 23));
        c1.setFont(new Font("Comic Sans", Font.PLAIN, 15));

        copyright.setBounds(200, 600, 800, 100);
        copyright.setBackground(new Color(23, 23, 23));

        mainpanel.setBounds(0, 0, X, Y);
        mainpanel.add(dashboard);
        mainpanel.add(t1);
        mainpanel.add(combopanel);
        mainpanel.add(t3);
        mainpanel.add(t4);
        mainpanel.add(t5);
        mainpanel.add(t6);
        mainpanel.add(b1);
        mainpanel.add(item1);
        mainpanel.add(item2);
        mainpanel.add(area);
        mainpanel.add(area2);
        mainpanel.add(c);
        mainpanel.add(c1);
        mainpanel.add(copyright);
        mainpanel.setBackground(Color.white);
        mainpanel.setLayout(null);

        frame.setSize(X, Y);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(mainpanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            a = t3.getText();
            b = t6.getText();
            a1 = t4.getText();
            a2 = t5.getText();
            n = area.getText();
            n2 = area2.getText();
            Result();
        }
    }

    public static void main(String[] args) {
        new HtmlViewer().start();
    }

    @Override
    public void init() {

    }

    @Override
    public void addImageToList() {

    }

    @Override
    public int rImage(int n) {
        return 0;
    }
}

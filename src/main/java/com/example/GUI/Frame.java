package com.example.GUI;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Font;

public class Frame implements ActionListener {
    JFrame frame = new JFrame();

    JPanel mainpanel = new JPanel();
    JPanel headpanel = new JPanel();
    JPanel combopanel = new JPanel();

    JButton addQues = new JButton();
    JButton ok = new JButton();
    JButton ok2 = new JButton();
    JButton ansBy = new JButton();
    JButton submit = new JButton();

    String[] day = { "Monday", "Tuesday", "Wednesday", "Thrusday", "Friday", "Saturday", "Sunday" };
    String[] month = { "January", "Febraury", "March", "April", "May", "June", "July", "August", "September", "October",
            "November", "December" };
    String[] year = { "2021", "2022", "2023" };

    JComboBox<String> dayselector = new JComboBox<String>(day);
    JComboBox<String> monthselector = new JComboBox<String>(month);
    JComboBox<String> yearselector = new JComboBox<String>(year);

    JTextField quesArea = new JTextField();
    JTextField answeredBy = new JTextField();

    // ------------------- variables ------------------------

    private final int fwidth = 900;
    private final int fheight = 700;

    String Questext;
    String AnswerText;

    List<String> ques = new ArrayList<String>();
    List<String> ans = new ArrayList<String>();

    private final Color primaryColor = new Color(23, 23, 23);

    public Frame() {
        dayselector.setBounds(0, 0, 70, 30);
        dayselector.setBackground(new Color(25, 25, 25));
        dayselector.setForeground(Color.white);
        dayselector.setFont(new Font("Comic Sans", Font.ITALIC + Font.BOLD, 15));

        monthselector.setBounds(90, 0, 70, 30);
        monthselector.setBackground(new Color(25, 25, 25));
        monthselector.setForeground(Color.white);
        monthselector.setFont(new Font("Comic Sans", Font.ITALIC + Font.BOLD, 15));

        yearselector.setBounds(170, 0, 100, 30);
        yearselector.setBackground(new Color(25, 25, 25));
        yearselector.setForeground(Color.white);
        yearselector.setFont(new Font("Aerial", Font.ITALIC + Font.BOLD, 15));

        combopanel.setBounds(200, 5, 500, 50);
        combopanel.setBackground(new Color(25, 25, 25));
        combopanel.add(dayselector);
        combopanel.add(monthselector);
        combopanel.add(yearselector);

        headpanel.setBounds(0, 0, fwidth, 50);
        headpanel.setBackground(new Color(25, 25, 25));
        headpanel.setBorder(BorderFactory.createEtchedBorder(new Color(30, 30, 30), new Color(25, 25, 25)));
        headpanel.add(combopanel);
        headpanel.setLayout(null);

        addQues.setBounds(50, 150, 100, 45);
        addQues.setText("+ Ques");
        addQues.setFont(new Font("Comic Sans", Font.BOLD, 18));
        addQues.setBackground(Color.green);
        addQues.setForeground(Color.white);
        addQues.setFocusable(false);
        addQues.addActionListener(this);

        quesArea.setBounds(300, 150, 400, 200);
        quesArea.setBackground(primaryColor);
        quesArea.setBorder(BorderFactory.createLineBorder(Color.blue));
        quesArea.setForeground(Color.cyan);
        quesArea.setFont(new Font("Aerial", Font.PLAIN, 18));
        quesArea.setVisible(false);
        quesArea.addActionListener(this);

        ok.setBounds(750, 150, 90, 50);
        ok.setText("OK");
        ok.setBackground(Color.red);
        ok.setForeground(Color.white);
        ok.setFocusable(false);
        ok.setVisible(false);
        ok.setFont(new Font("Aerial", Font.BOLD, 20));
        ok.addActionListener(this);

        ansBy.setBounds(50, 400, 200, 45);
        ansBy.setText("+ Answered By");
        ansBy.setFont(new Font("Comic Sans", Font.BOLD, 18));
        ansBy.setBackground(Color.green);
        ansBy.setForeground(Color.white);
        ansBy.setFocusable(false);
        ansBy.addActionListener(this);

        answeredBy.setBounds(300, 400, 400, 70);
        answeredBy.setBackground(primaryColor);
        answeredBy.setForeground(Color.cyan);
        answeredBy.setBorder(BorderFactory.createLineBorder(Color.blue));
        answeredBy.setFont(new Font("Aerial", Font.BOLD, 20));
        answeredBy.setVisible(false);
        answeredBy.addActionListener(this);

        ok2.setBounds(750, 400, 90, 50);
        ok2.setText("OK");
        ok2.setBackground(Color.red);
        ok2.setForeground(Color.white);
        ok2.setFocusable(false);
        ok2.setVisible(false);
        ok2.setFont(new Font("Aerial", Font.BOLD, 20));
        ok2.addActionListener(this);

        submit.setBounds(330, 550, 300, 60);
        submit.setBorderPainted(false);
        submit.setBackground(primaryColor);
        submit.setText("Submit");
        submit.setForeground(Color.white);
        submit.setFont(new Font("Comic Sans", Font.BOLD, 30));
        submit.setFocusable(false);
        submit.setVisible(false);
        submit.addActionListener(this);

        mainpanel.setBounds(0, 0, fwidth, fheight);
        mainpanel.setBackground(primaryColor);
        mainpanel.setLayout(null);
        mainpanel.add(headpanel);
        mainpanel.add(addQues);
        mainpanel.add(quesArea);
        mainpanel.add(ok);
        mainpanel.add(ok2);
        mainpanel.add(ansBy);
        mainpanel.add(answeredBy);
        mainpanel.add(submit);

        frame.setSize(fwidth, fheight);
        frame.setTitle("Quiz Manager");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);
        frame.setResizable(false);
        frame.add(mainpanel);
        // frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addQues) {
            quesArea.setVisible(true);
            ok.setVisible(true);
            Questext = quesArea.getText();
            ques.add(Questext);
        }

        if (e.getSource() == ok) {
            Questext = quesArea.getText();
            ques.add(Questext);
        }

        if (e.getSource() == ansBy) {
            answeredBy.setVisible(true);
            ok2.setVisible(true);
        }

        if (e.getSource() == ok2) {
            submit.setVisible(true);
            AnswerText = answeredBy.getText();
            ans.add(AnswerText);
        }

        if (e.getSource() == submit) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Cats");

            String[][] bookData2 = new String[100][100];

            Object[][] bookData = { { Questext, AnswerText, 100 }, };

            int rowCount = 0;
            int columnCount = 0;

            for (int j = 0; j < ques.size(); j++) {
                bookData2[0][j] = ques.get(j);
            }
            for (int i = 0; i < ans.size(); i++) {
                bookData2[1][i] = ans.get(i);
            }

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
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }
                    columnCount++;
                }
                rowCount++;
            }

            try (FileOutputStream outputStream = new FileOutputStream("meow.xlsx")) {
                System.out.println("Successfully Created the file!");
                workbook.write(outputStream);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }
}
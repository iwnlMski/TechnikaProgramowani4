package com.srcpackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyForm {

    private JPanel panel;
    private JButton groundLevel;
    private JButton secondLevel;
    private JButton thirdLevel;
    private JButton firstLevel;
    private JButton pplCountL1;
    private JButton pplCountL2;
    private JButton pplCountL3;
    private JButton pplCountL0;
    public static JFrame frame = new JFrame("App");
    public static int cr = 0;
    public static boolean running = false;



    public MyForm() {
        pplCountL1.setEnabled(false);
        pplCountL2.setEnabled(false);
        pplCountL3.setEnabled(false);
        pplCountL0.setEnabled(false);

        runGraph(cr, cr);
        groundLevel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!running){
                    runGraph(0, cr);
                    running = true;
                }
            }
        });
        firstLevel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!running){
                    runGraph(1, cr);
                    running = true;
                }
            }
        });
        thirdLevel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!running){
                    runGraph(3, cr);
                    running = true;
                }
            }
        });
        secondLevel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!running){
                    runGraph(2, cr);
                    running = true;
                }
            }
        });
    }

    public static void main(String[] args) {

        frame.setSize(1800, 1000);
        frame.setPreferredSize(new Dimension(1800, 1000));
        frame.setContentPane(new MyForm().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
    }


    public static void runGraph(int level, int c){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JComponent draw = new GraphicsDemo(level, c);
                JPanel panel1 = new JPanel();
                panel1.setLayout(new BorderLayout());
                panel1.setPreferredSize(new Dimension(1000, 1000));
                panel1.add(draw, BorderLayout.CENTER);
                panel1.revalidate();
                panel1.repaint();
                panel1.setVisible(true);
                frame.add(panel1, BorderLayout.CENTER);
                frame.repaint();
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}

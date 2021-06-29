package com.srcpackage;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class GraphicsDemo extends JComponent{
    private int currentLevel;
    Timer timer;

    private Vector<Integer> levels;
    private Vector<Integer> trashcan;

    public GraphicsDemo(int l, int currLev) {
        currentLevel = 700 - currLev*200;
        levels = createPath(l);
        trashcan = new Vector<>();
        trashcan.add(levels.get(0));
        timer = new Timer(1, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                timer.setDelay(1);
                if (levels.isEmpty()) {
                    if(currentLevel < 700){
                        timer.setDelay(5000);
                        levels = createPath(0);
                        trashcan = new Vector<>();
                        trashcan.add(levels.get(0));
                    }else{
                        ((Timer) e.getSource()).stop();
                        MyForm.running = false;
                        MyForm.cr = (currentLevel-700)/(-200);
                    }
                }
                else {
                    trashcan.remove(0);
                    trashcan.add(levels.get(0));
                    levels.remove(0);
                }
                repaint();
            }
        });
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(Color.BLACK);
        g2D.setStroke(new BasicStroke(4));
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Basic Draw
        g2D.drawLine(200, 0, 450, 0);
        g2D.drawLine(450, 0, 450, 900);
        g2D.drawLine(450, 900, 200, 900);
        g2D.drawLine(200, 900, 200, 850);
        g2D.drawLine(200, 0, 200, 100);
        g2D.drawLine(200, 250, 200, 300);
        g2D.drawLine(200, 450, 200, 500);
        g2D.drawLine(200, 650, 200, 700);

        g2D.drawLine(60, 250, 200, 250);
        g2D.drawLine(60, 450, 200, 450);
        g2D.drawLine(60, 650, 200, 650);
        g2D.drawLine(60, 850, 200, 850);

        g2D.setColor(new Color(214, 214, 214));
        g2D.setFont(new Font("Comic Sans", Font.ITALIC, 150));
        g2D.drawString("0", 80, 830);
        g2D.drawString("1", 80, 630);
        g2D.drawString("2", 80, 430);
        g2D.drawString("3", 80, 230);

        //Elevator
        g2D.setColor(Color.GREEN);
        for(int i = 0; i < trashcan.size(); i++){
            g2D.drawRect(204, trashcan.get(i), 240, 150);
            }
        }


    public Vector<Integer> createPath(int destinationLevel){
        Vector<Integer> list = new Vector<>();
        int goTo = 700 - destinationLevel*200;

        if(goTo == currentLevel){
            list.add(goTo);
            return list;
        }

        else if(goTo > currentLevel){
            while(goTo >= currentLevel){
                list.add(currentLevel);
                currentLevel++;
            }
            return list;
        }

        else if(goTo < currentLevel){
            while(goTo <= currentLevel){
                list.add(currentLevel);
                currentLevel--;
            }
            return list;
        }
        return list;
    }
}
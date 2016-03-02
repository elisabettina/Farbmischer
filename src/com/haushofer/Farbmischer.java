package com.haushofer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Farbmischer extends JFrame{


	// write your code here
        //JOptionPane.showMessageDialog(null, "Hallo Welt!");
        //Rot, Grün, Blau --> RGB Farbmodell
        JLabel lRot = new JLabel("Rot", JLabel.CENTER);
        JLabel lGruen = new JLabel("Grün", JLabel.CENTER);
        JLabel lBlau = new JLabel("Blau", JLabel.CENTER);

        JTextField tRot = new JTextField("255");
        JTextField tGruen = new JTextField("0");
        JTextField tBlau = new JTextField("0");

        JButton b1 = new JButton("Ändern");

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        public Farbmischer()
        {
            setTitle("Farbmischer");
            setSize(600, 300);
            setLayout(new GridLayout(1,3));

            lRot.setForeground(Color.red);
            lGruen.setForeground(Color.green);
            lBlau.setForeground(Color.blue);

            tRot.setHorizontalAlignment(JTextField.CENTER);
            tGruen.setHorizontalAlignment(JTextField.CENTER);
            tBlau.setHorizontalAlignment(JTextField.CENTER);

            p1.setBackground(new Color(255,0,0));
            p2.setLayout(new GridLayout(3,2));

            p2.add(lRot);
            p2.add(tRot);
            p2.add(lGruen);
            p2.add(tGruen);
            p2.add(lBlau);
            p2.add(tBlau);
            p3.setLayout(new GridLayout(1,1));
            p3.add(b1);

            add(p1);
            add(p2);
            add(p3);

            b1.addActionListener(new Mischer());

            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);
        }

        private class Mischer implements ActionListener {
            public void actionPerformed(ActionEvent ae) {
                try {
                    int r = Integer.parseInt(tRot.getText());
                    int g = Integer.parseInt(tGruen.getText());
                    int b = Integer.parseInt(tBlau.getText());

                    Color farbe = new Color(r, g, b);
                    p1.setBackground(farbe);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Bitte geben Sie nur Zahlen ein!", "Achtung", 0);
                } catch (IllegalArgumentException iae) {
                    JOptionPane.showMessageDialog(null, "Bitte geben Sie nur Zahlen zwischen 0 und 255 ein!", "Achtung", 2);
                }
            }
        }


        public static void main (String [] args)
        {
            new Farbmischer();
        }


}

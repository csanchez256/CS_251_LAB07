/*
 * Author:Christopher Sanchez;
 * File: LayoutPractice.java
 * CS 251; Lab07
 * This program is a simple demonstration of how 
 * to use Java Swing components to create a graphical
 * applet with buttons, paintComponents, and buttons
 */

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class LayoutPractice extends JPanel {

    static int numClicks;
    private static JTextField messageText = new JTextField();
    static LayoutPractice clickedamount = new LayoutPractice();

    public void setClicks(int value) {
        this.numClicks = value;
    }

    public int getClicks() {
        return this.numClicks;
    }

    /* 
     * This method is part of the Java Swing toolkit. it
     * Paints circles
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        /* (x,y, width, height) */
        g.drawOval(50, 50, 400, 400);
        g.setColor(Color.black);
        g.fillOval(50, 50, 400, 400);

        g.drawOval(75, 75, 350, 350);
        g.setColor(Color.cyan);
        g.fillOval(75, 75, 350, 350);

        g.drawOval(100, 100, 300, 300);
        g.setColor(Color.BLACK);
        g.fillOval(100, 100, 300, 300);

        g.drawOval(125, 125, 250, 250);
        g.setColor(Color.cyan);
        g.fillOval(125, 125, 250, 250);
    }

    /**
     * Creates the window and panel
     */
    private static void createWindow() {

        JFrame frame = new JFrame("Layout Practice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponentsToPane(frame.getContentPane());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setPreferredSize(new Dimension(500, 500));

        JPanel borderedPanel = new LayoutPractice();
        Border border = BorderFactory
                .createTitledBorder("Click Buttons for FUN!");
        borderedPanel.setBorder(border);

        panel.add(borderedPanel);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        /* set the background of the panel */
        frame.getContentPane().setBackground(Color.white);
    }

    /**
     * Adds components to the Pane
     * @param contentPane
     */
    private static void addComponentsToPane(Container contentPane) {
        /* Sets the layout manager for this container. */
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        counterButton("Click Counter", contentPane);
        dialogButton("Click for Dialog", contentPane);
    }

    /**
     * Adds button and sets the alignment
     * @param text
     * @param container
     */
    private static void counterButton(final String text,
            final Container container) {
        JButton button = new JButton(text);
        final JLabel label01 = new JLabel("Number of clicks: "
                + clickedamount.getClicks());
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        container.add(label01);
        container.add(button);

        /*
         * Listens to action events, in this case the clicking of the
         * Counter Button
         */
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numClicks++;
                clickedamount.setClicks(numClicks);
                label01.setText("Number of clicks: "
                        + clickedamount.getClicks());
            }
        });
    }

    private static void dialogButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        container.add(button);
        /*
         * Listens to action events, in this case the clicking of a button
         */
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(messageText, "You clicked "
                        + numClicks + " times");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createWindow();
            }
        });
    }
}
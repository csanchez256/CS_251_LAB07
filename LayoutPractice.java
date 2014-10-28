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

public class LayoutPractice extends JPanel  {

    static int numClicks;
    private static JTextField messageText = new JTextField();
    private static JTextField textDisplayedWhenButtonClicks = new JTextField();
    static LayoutPractice clickedamount = new LayoutPractice();
    
    public LayoutPractice(){
    }
//
//    public LayoutPractice(int numClicks) {
//        this.numClicks = numClicks;
//    }
    
    public void setClicks(int value){
       this.numClicks = value;
       System.out.println("clicks here: "+this.numClicks);
    }
    public int getClicks(){
        System.out.println("look"+this.numClicks);
        return this.numClicks;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
//        /*(x,y, width, height)*/
//        g.drawOval(50, 50, 400, 400);
//        g.setColor(Color.black);
//        g.fillOval(50, 50, 400, 400);
//        
//        g.drawOval(75, 75, 350, 350);
//        g.setColor(Color.cyan);
//        g.fillOval(75, 75, 350, 350);
    }

    /**
     * Creates the window itself 
     */
    private static void createWindow() {

        JFrame frame = new JFrame("Layout Practice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponentsToPane(frame.getContentPane());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setPreferredSize(new Dimension(500,500));

        JPanel borderedPanel = new LayoutPractice();
        Border border = BorderFactory.createTitledBorder("Click Buttons");
        borderedPanel.setBorder(border);

        panel.add(borderedPanel);
        
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        /*set the background of the panel*/
        frame.getContentPane().setBackground(Color.white);
    }

    /**
     * Adds components to the Pane
     * @param contentPane
     */
    private static void addComponentsToPane(Container contentPane) {
        /*Sets the layout manager for this container. */
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        addAButton("Button 1", contentPane);
        addAButton2("Click for Dialog", contentPane);
  
        JLabel label01 = new JLabel("clicks: "+clickedamount.getClicks());
        contentPane.add(label01);
    }

    /**
     * Adds button and sets the alignment
     * @param text
     * @param container
     */
    private static void addAButton(final String text, final Container container) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.RIGHT_ALIGNMENT);
        container.add(button);

        /*Listens to action events, in this case the clicking
         * of a button
         */
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                numClicks++;
            clickedamount.setClicks(numClicks);
            numClicks.setText(clickedamount.getClicks());
            // tester 
       //     repaint();
          //do getter setter method 
              //  textDisplayedWhenButtonClicks.setText("Button Clicked " + numClicks + " times");
            }
        });
    }
    
    private static void addAButton2(String text, Container container) {
        JButton button2 = new JButton(text);
        button2.setAlignmentX(Component.RIGHT_ALIGNMENT);
        container.add(button2);
        /*Listens to action events, in this case the clicking
         * of a button
         */
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                  JOptionPane.showMessageDialog(messageText, "You clicked "+numClicks+" times");
            }
        });
    }

    public static void main(String[] args) {
        //LayoutPractice lObj = new LayoutPractice();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createWindow();
            }
        });
    }
}
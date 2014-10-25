import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class LayoutPractice extends JFrame implements ActionListener{
    
    public LayoutPractice(){
         createWindow();
    }

    public static void main(String[] args){
      LayoutPractice lObj = new LayoutPractice();        
    }
    
   private void createWindow(){
      // button01.addActionListener(this);
       
       JFrame frame = new JFrame("Layout Practice");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       
       JPanel panel01 = new JPanel();
       
       JButton b1 = new JButton("Button"); 
       b1.addActionListener(this);
       panel01.add(b1);
       b1.setPreferredSize(new Dimension(100, 50));
       
     //  panel01.add(new JButton("Button"),BorderLayout.PAGE_START );
       
       getContentPane().add(panel01);
       pack();
       
       frame.setContentPane(panel01);
       
       
       // This is an empty content area in the frame
       JLabel label01 = new JLabel();
       label01.setPreferredSize(new Dimension(500, 500));
       //label01.setLocation(0,100);
       
       frame.getContentPane().add(label01, BorderLayout.CENTER);
       frame.pack();
       frame.setVisible(true);
       
       frame.addWindowListener(new WindowAdapter(){
           public void windowClosing(WindowEvent e){
               System.exit(0);
           }
       });
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        System.out.println("Button Clicked");
    }

}

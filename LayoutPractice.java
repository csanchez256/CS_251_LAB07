import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class LayoutPractice implements ActionListener{
    
    public LayoutPractice(){
         buildGUI();
    }
    
    public static void main(String[] args){
      LayoutPractice lObj = new LayoutPractice();        
    }
    
   private static void buildGUI(){
      // button01.addActionListener(this);
           
       JFrame frame = new JFrame("Layout Practice");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       
       JPanel panel01 = new JPanel(new BorderLayout());
       panel01.add(new JButton("Button"),BorderLayout.PAGE_START );
       frame.setContentPane(panel01);
       
       JButton b1 = new JButton(); 
       
       // This is an empty content area in the frame
       JLabel label01 = new JLabel("Button Clicks");
       label01.setPreferredSize(new Dimension(500, 500));
       
       
       
       
       frame.getContentPane().add(label01, BorderLayout.CENTER);
       frame.pack();
       frame.setVisible(true);
       
       b1.setPreferredSize(new Dimension(50, 50));
       panel01.add(b1);
       
       frame.addWindowListener(new WindowAdapter(){
           public void windowClosing(WindowEvent e){
               System.exit(0);
           }
       });
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
    }

}

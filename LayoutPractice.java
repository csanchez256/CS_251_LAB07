import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class LayoutPractice implements ActionListener{
    
    public LayoutPractice(){
        JButton button01 = new JButton();
        button01.addActionListener(this);
    }
    
    public static void main(String[] args){
        
        JFrame frame = new JFrame("Layout Practice");
        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        
     // This is an empty content area in the frame
        JLabel label01 = new JLabel("Button Clicks");
        label01.setPreferredSize(new Dimension(500, 500));
        frame.getContentPane().add(label01, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
    }

}

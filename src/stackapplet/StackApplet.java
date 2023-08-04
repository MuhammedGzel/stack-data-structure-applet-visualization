
package stackapplet;

import java.applet.Applet;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class StackApplet extends Applet implements ActionListener {
     static int x=350;
     static int y=752;
     Button push=new Button("Push()");
     Button pop=new Button("Pop()");
     Button show=new Button("Show()");
     TextField t=new TextField(10);
     StackClass numbers=new StackClass(20);
    
        
    
    public void init() {
       setSize(780,800);
       setLayout(null);
       add(push);
       push.setBounds(120,40,70,40);
       add(pop);
       pop.setBounds(345,40,70,40);
       add(show);
       show.setBounds(590,40,70,40);
       add(t);
       t.setBounds(342,120,80,25);
       push.addActionListener(this);
       pop.addActionListener(this);
       show.addActionListener(this);
      
       
    }
    public void paint(Graphics g){
        for(int i = 0; i <20; i++){
            int x1=350;
            int y1=750;
            g.drawRect(x1, y1-31*i,60,30);
            if(i<10){
               g.drawString(String.valueOf(i), x1-10, y1-31*i+20);
                    }
            else{
               g.drawString(String.valueOf(i), x1-16, y1-31*i+20);  
                }
                                   }
                                 }

    @Override
    public void actionPerformed(ActionEvent e) {
        
       if(e.getSource()==push){
          Graphics g=getGraphics();
          if(numbers.top==19){
             g.drawString("Stack is full",340,100);
             System.out.println("Stack is full");
                             }
           else{
             g.drawString(t.getText(),x+20,y+18);
           try{
             numbers.push(Integer.parseInt(t.getText()));
             g.setColor(Color.white);
             g.fillRect(340,85,100,30);
             JFrame frame=new JFrame();
             JOptionPane.showMessageDialog(frame,"Push process has been performed"); 
             y=y-31;
              }
           catch(NumberFormatException ee){
             JFrame frame=new JFrame();
             JOptionPane.showMessageDialog(frame,"Please enter a number");
                                          }
              }
                           }
       
       
       if(e.getSource()==pop){
          Graphics g=getGraphics();
          if(numbers.isEmpty()){
             System.out.println("Stack is empty");
             g.drawString("Stack is empty",340,100);
                               }
           else{
             g.setColor(Color.white);
             g.fillRect(340,85,100,30);
             g.fillRect(x+1,y+32,50,18);
             numbers.pop();
             JFrame frame=new JFrame();
             JOptionPane.showMessageDialog(frame,"Pop process has been performed");
             y=y+31;   
               }
                               }
       
       
       if(e.getSource()==show){
          Graphics g=getGraphics();
          if(numbers.isEmpty()){
             g.drawString("Stack is empty",340,100);
             JFrame frame=new JFrame();
             JOptionPane.showMessageDialog(frame,"Stack is empty");
                               }
          else{
             t.setText(String.valueOf(numbers.returnTop()));
              }
                              }
     
    }
}

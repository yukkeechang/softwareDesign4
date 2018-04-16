/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwaredesign4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author yukkeechang
 */
public class textr extends JFrame implements ActionListener, ItemListener{
    /*set font size*/
   static int size = 15;
   JButton inc,dec,col;
   JComboBox<String> comboBox;
   JCheckBox checkBox;
   /*multiline text area from java.awt class*/
   JTextArea textArea;
   /*container objecct from java.awt class*/
   Container container;
   JLabel label;
   Color color = null;
   
   
   
   
   /*Constructor*/
   public textr(){
       /*Get ContentPane for the frame */
       container = getContentPane();
       
       /*text box*/
       textArea = new JTextArea("insert text here", 6,20);
      
       /*Buttons for text and color control*/
       inc = new JButton("Increase Size");
       dec = new JButton("Decrease Size");
       col = new JButton("Color");
      
       /*Checkbox*/
       checkBox = new JCheckBox("Bold");
       
   
       /*combo box and label*/
       comboBox = new JComboBox<String>();
       label = new JLabel();
       
       
       
       /*Get fonts and add to comboBox*/
       GraphicsEnvironment font = GraphicsEnvironment.getLocalGraphicsEnvironment();
       String fonts[] = font.getAvailableFontFamilyNames();
       for(int i=0; i<fonts.length; i++){
           comboBox.addItem(fonts[i]);
       }
       
       /*set layout*/
       container.setLayout(new FlowLayout());
      
       /*Add buttons, comboBox, checkBox, textArea to Container*/
       container.add(dec); 
       container.add(inc);
       container.add(col);
       
       container.add(comboBox);
       container.add(checkBox);
       
       container.add(textArea,BorderLayout.CENTER);
       this.pack();
      
       /*Add action listeners*/
       inc.addActionListener(this);
       dec.addActionListener(this);
       col.addActionListener(this);
       checkBox.addItemListener(this);
       comboBox.addItemListener(this);
   }
   /*Function for button logics*/
    @Override
   public void actionPerformed(ActionEvent event) {
       Font font = new Font(comboBox.getSelectedItem().toString(),Font.PLAIN,textr.size);
       if(event.getActionCommand() == "Increase Size"){
           /*inc font size*/
           size++;
           textArea.setFont(font);
       }else if(event.getActionCommand() == "Decrease Size"){
           /*dec font size*/
           --size;
           textArea.setFont(font);
       }else{
           /*Add choose color */
           Color colors = JColorChooser.showDialog(this, "Choose Color", color);
           if(colors!=null){
               color = colors; 
           }
           repaint();
       }
      
   }
   
  /*Graphics Method*/
   public void paint(Graphics graphic){

       if(checkBox.isSelected()){
           Font font = new Font(comboBox.getSelectedItem().toString(),Font.BOLD+Font.PLAIN,20);
           textArea.setFont(font);
       }else{
           Font font = new Font(comboBox.getSelectedItem().toString(),Font.PLAIN,20);
           textArea.setFont(font);
       }
           textArea.setForeground(color);
   }
   
   
   @Override
   public void itemStateChanged(ItemEvent e) {
       repaint();
   }
    
}

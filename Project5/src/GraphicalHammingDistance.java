import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
public class GraphicalHammingDistance extends JFrame 
{
        
    
    JSlider slider;
    JLabel label;
    JPanel panel = new JPanel(new GridBagLayout());
    
    public GraphicalHammingDistance(){
       setLayout(new GridBagLayout());
       GridBagConstraints rats = new GridBagConstraints();
        
        rats.gridx = 0;
        rats.gridy = 0;
        rats.anchor = GridBagConstraints.LINE_START;
        label = new JLabel("Enter Hamming Dist: ");
        panel.add(label, rats);
        add(panel);

        GridBagConstraints rats2 = new GridBagConstraints();
        rats2.gridx = 0;
        rats2.gridy = 1;
        slider  = new JSlider(1, 4);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        rats.insets = new Insets(0,80,0,0);
        rats.anchor = GridBagConstraints.LINE_START;
        panel.add(slider, rats2);
        add(panel);
        
        rats = new GridBagConstraints();
        rats.gridx = 1;
        rats.gridy = 0;
        
        rats.insets = new Insets(10,-80,10,10);
        JTextField text = new JTextField("                                            ");
        text.setBounds(50, 25, 50, 0);
        
        panel.add(text, rats);
        add(panel);
              
        rats = new GridBagConstraints();
        rats.gridx = 0;
        rats.gridy = 3;
        
        JButton button = new JButton("Show Station");
        
        rats.anchor = GridBagConstraints.LINE_START;
        rats.insets = new Insets(20,0,10,10);
        panel.add(button, rats);
        add(panel);
       
        
        rats = new GridBagConstraints();
        rats.gridx = 0;
        rats.gridy = 5;
        
        rats.insets = new Insets(20, 30, 10, 10);
        JTextArea bigBox = new JTextArea();
        bigBox.setSize(100,100);
        panel.add(bigBox, rats);
        add(panel);
             
        event e = new event();
        slider.addChangeListener(e);
        
        

    }
    public class event implements ChangeListener{
        public void stateChanged (ChangeEvent e){
            int value = slider.getValue(); 
            label.setText("Enter Hamming Dist: " + value);
        }
    }
    
    public static void main (String [] args){ 
        GraphicalHammingDistance test = new GraphicalHammingDistance();
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setSize(500,500);
        test.setVisible(true);
        test.setTitle("Hamming Distance");
         
    }
}

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class GraphicalHammingDistance extends JFrame 
{
        
    ArrayList<String> names = new ArrayList<String>();
    JSlider slider;
    JLabel label;
    JPanel panel = new JPanel(new GridBagLayout());
    public void read(String file) throws IOException, FileNotFoundException
    {
        
        BufferedReader br = null;

        br = new BufferedReader(new FileReader(file));
        String line;
        
        // loop that will run until there is nothing left in the file
        while ((line = br.readLine()) != null)
        {
            // Creating a columns string array that will take in the txt file
            // This array will contain the columns which are separated by a
            // white space
            String[] columns = line.split("\\s+");

            // Getting all the stationIds in the third column and putting them
            // in name
            String name = columns[0];
            // Adding all the stationIds to the arraylist Names
            names.add(name);
        }
        // closes the buffered reader
        br.close();
    }

    public GraphicalHammingDistance() throws FileNotFoundException, IOException{
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
        
        rats.insets = new Insets(10,-83,10,10);
        JTextField text = new JTextField("                                                   ");
        text.setBounds(50, 25, 50, 0); 
        text.setText(String.valueOf(slider.getValue()));
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
        JTextArea bigBox = new JTextArea(20,20);
        //bigBox.setSize(10,10);
        panel.add(bigBox, rats);
        add(panel);
        
        event e = new event();
        slider.addChangeListener(e);
        
        rats = new GridBagConstraints();
        rats.gridx = 0;
        rats.gridy = 8;
        rats.anchor = GridBagConstraints.LINE_START;
        label = new JLabel("Compare with: ");
        panel.add(label, rats);
        add(panel);
        
        
        
        
        rats = new GridBagConstraints();
        rats.gridx = 0;
        rats.gridy = 9;
        
        JButton button2 = new JButton("Calculate HD");
        
        rats.anchor = GridBagConstraints.LINE_START;
        rats.insets = new Insets(20,0,10,10);
        panel.add(button2, rats);
        add(panel);
        
   
   
        Object[] namesss = names.toArray();
        @SuppressWarnings("unchecked")
        JComboBox stations = new JComboBox(namesss);
        

    }
  
    
    
    

    public class event implements ChangeListener{
        public void stateChanged (ChangeEvent e){
            int value = slider.getValue(); 
            label.setText("Enter Hamming Dist: " + value);
        }
    }
    
    public static void main (String [] args) throws FileNotFoundException, IOException{ 
        GraphicalHammingDistance test = new GraphicalHammingDistance();
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setSize(500,500);
        test.setVisible(true);
        test.setTitle("Hamming Distance");
        
        
         
    }
}

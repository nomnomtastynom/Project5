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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class GraphicalHammingDistance extends JFrame implements ChangeListener, ActionListener
{
        
    ArrayList<String> names = new ArrayList<String>();
    JSlider slider;
    JLabel label;
    JPanel panel = new JPanel(new GridBagLayout());
    JTextField text ;
    JComboBox box = new JComboBox();
    JButton button = new JButton("Show Station");
    JTextArea bigBox = new JTextArea(15,15);
    private Object String;
    JButton button2 = new JButton("Calculate HD");
    int[] counts = { 0, 0, 0, 0, 0};
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
    public void actionPerformed(ActionEvent event){
           if(event.getSource() == button){
               bigBox.setText("");
               sort((String) box.getSelectedItem());
           }
           else if(event.getSource() == button2){
               for (int i =0; i<names.size(); i++){
                   counts[i] = 0;
               }
               counts = 
           }
    }
    
    public void sort(String name){
        for (String namess : names){
            if(getDistance(namess, name) == slider.getValue()){
                bigBox.append(namess + "\n");
            }
        }
    }
    public void displayTheNodes(){
        dis0.setText(String.valueOf(counts[0]));
    }

    public GraphicalHammingDistance() throws FileNotFoundException, IOException{
       
        read("C:\\Users\\sarat\\workspace\\Project5\\src\\Mesonet.txt");
        
        setLayout(new GridBagLayout());
       GridBagConstraints rats = new GridBagConstraints();
        
       dropDown();
        rats.gridx = 0;
        rats.gridy = 0;
        rats.insets = new Insets(-30,0,0,0);
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
        rats.insets = new Insets(0,0,0,0);
        rats.anchor = GridBagConstraints.LINE_START;
       
        panel.add(slider, rats2);
        
        add(panel);
        
        rats = new GridBagConstraints();
        rats.gridx = 1;
        rats.gridy = 0;
        
        rats.insets = new Insets(10,-83,10,10);
        text = new JTextField("                                                   ");
        text.setBounds(50, 25, 50, 0); 
        text.setText(String.valueOf(slider.getValue()));
        panel.add(text, rats);
        add(panel);
              
        rats = new GridBagConstraints();
        rats.gridx = 0;
        rats.gridy = 3;
        

        button.addActionListener(this);
        rats.anchor = GridBagConstraints.LINE_START;
        rats.insets = new Insets(20,0,10,10);
        panel.add(button, rats);
        add(panel);
       
        
        rats = new GridBagConstraints();
        rats.gridx = 0;
        rats.gridy = 5;
        
        rats.insets = new Insets(20, 30, 10, 10);
        
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
        

        button2.addActionListener(this);
        rats.anchor = GridBagConstraints.LINE_START;
        rats.insets = new Insets(20,0,10,10);
        panel.add(button2, rats);
        add(panel);
        
   
        rats = new GridBagConstraints();
        rats.gridx = 1;
        rats.gridy = 8;
        panel.add(box, rats);
       
        @SuppressWarnings("unchecked")
        
        //drop down box
        
        JLabel d0 = new JLabel("Distance 0");
        JTextField dist0 = new JTextField("                              ");
        

        JLabel d1 = new JLabel("Distance 1");
        JTextField dist1 = new JTextField("                              ");
        

        JLabel d2 = new JLabel("Distance 2");
        JTextField dist2 = new JTextField("                              ");
        

        JLabel d3 = new JLabel("Distance 3");
        JTextField dist3 = new JTextField("                              ");
        

        JLabel d4 = new JLabel("Distance 4");
        JTextField dist4 = new JTextField("                              ");
        
        rats.gridx = 0;
        rats.gridy = 10;
        rats.insets = new Insets(0,0,0,0);
        rats.anchor = GridBagConstraints.LINE_START;
        panel.add(d0, rats);
        
        rats.gridx = 0;
        rats.gridy = 12;
        rats.anchor = GridBagConstraints.LINE_START;
        panel.add(d1, rats);
        
        rats.gridx = 0;
        rats.gridy = 14;
        rats.anchor = GridBagConstraints.LINE_START;
        panel.add(d2, rats);
        
        rats.gridx = 0;
        rats.gridy = 16;
        rats.anchor = GridBagConstraints.LINE_START;
        panel.add(d3, rats);
        
        rats.gridx = 0;
        rats.gridy = 18;
        rats.anchor = GridBagConstraints.LINE_START;
        panel.add(d4, rats);
        
        rats.gridx = 1;
        rats.gridy = 10;
        rats.insets = new Insets(0,-80,0,0);
        panel.add(dist0, rats);
        
        rats.gridx = 1;
        rats.gridy = 12;
        rats.insets = new Insets(0,-80,0,0);
        panel.add(dist1, rats);
        

        rats.gridx = 1;
        rats.gridy = 14;
        rats.insets = new Insets(0,-80,0,0);
        panel.add(dist2, rats);
        

        rats.gridx = 1;
        rats.gridy = 16;
        rats.insets = new Insets(0,-80,0,0);
        panel.add(dist3, rats);
        

        rats.gridx = 1;
        rats.gridy = 18;
        rats.insets = new Insets(0,-80,0,0);
        panel.add(dist4, rats);
        
        
        rats = new GridBagConstraints();
        rats.gridx = 0;
        rats.gridy = 20;
        
        JButton button3 = new JButton("Add Station");
        
        rats.anchor = GridBagConstraints.LINE_START;
        rats.insets = new Insets(20,0,0,0);
        panel.add(button3, rats);
        add(panel);
        
        JTextField button3Text = new JTextField("                              "); 
        button3.addActionListener(this);
        rats.gridx = 1;
        rats.gridy = 20;
        rats.anchor = GridBagConstraints.LINE_START;
        rats.insets = new Insets(0,-80,0,0);
        panel.add(button3Text, rats);
    }
  
    public void stateChanged(ChangeEvent event) {
        int sliderVal;            // Slider value (int)
        String strSliderVal;      // Slider value (string)

        // Get source of event (2 sliders in GUI)
        JSlider sourceEvent = (JSlider) event.getSource();

        if (sourceEvent == slider) {
           sliderVal = slider.getValue();      // Get slider value
           strSliderVal = Integer.toString(sliderVal); // Conver to int
           text.setText(strSliderVal); 
           // Update display
        }
      

     }

    public void dropDown(){

     for( String thing : names)
     box.addItem(thing);
     
     }
    
    public int getDistance(String one, String two)
    {
        int hd = 0;
        for (int i = 0; i < 4; i++)
        {
            if (one.charAt(i) != two.charAt(i))
            {
                hd = hd + 1;
            }
        }
        return hd;
    }

    public void CountDistances(String name)
    {
        // initializing two int arrays
        // These two arrays will be used to count the nodes for
        // WEST and BESS
      
        //
        // Count all the instances of a particular distance between name
        // and all the other names stored in "otherNames".
        //
        // Creating a for loop that will loop through the STids and count the
        // hamming distance between the name1 and the rest
        for (int i = 0; i < names.size(); i++)
        {
            int distance = getDistance(name, names.get(i));
            counts[distance]++;
        }
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
        test.setSize(800,800);
        test.setVisible(true);
        test.setTitle("Hamming Distance");
        
        
         
    }
}

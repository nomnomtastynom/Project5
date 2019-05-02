import javax.swing.DefaultComboBoxModel;
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
    JTextField text;
    JComboBox box = new JComboBox();
    JButton button = new JButton("Show Station");
    JTextArea bigBox = new JTextArea(15, 15);
    private Object String;
    JButton button2 = new JButton("Calculate HD");
    int[] counts = { 0, 0, 0, 0, 0 };
    JTextField dist0;
    JTextField dist1;
    JTextField dist2;
    JTextField dist3;
    JTextField dist4;
    JButton button3 = new JButton("Add Station");
    JTextField button3Text = new JTextField("                              ");

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
    
    //An enhanced for loop that adds the station names into the big box
    public void sort(String name)
    {
        for (String namess : names)
        {
            if (getDistance(namess, name) == slider.getValue())
            {
                bigBox.append(namess + "\n");
            }
        }
    }
    
    //Method that used to set the text of the distance parameters
    public void displayTheNodes()
    {
        dist0.setText(((java.lang.String) String).valueOf(counts[0]));
        dist1.setText(((java.lang.String) String).valueOf(counts[1]));
        dist2.setText(((java.lang.String) String).valueOf(counts[2]));
        dist3.setText(((java.lang.String) String).valueOf(counts[3]));
        dist4.setText(((java.lang.String) String).valueOf(counts[4]));

    }
    //The main constructor that houses most of the code for this project
    public GraphicalHammingDistance() throws FileNotFoundException, IOException
    {
        //First read in the mesonet file 
        read("C:\\Users\\sarat\\workspace\\Project5\\src\\Mesonet.txt");
        
        //Setting the layout as a gridbaglayout
        setLayout(new GridBagLayout());
        GridBagConstraints rats = new GridBagConstraints();
        
        //calling the dropDown method 
        dropDown();
        //setting the Enter Hamming Dist text to the top left or 0,0 on the grid
        rats.gridx = 0;
        rats.gridy = 0;
        //have to move it upward 
        rats.insets = new Insets(-30, 0, 0, 0);
        //this sets it to the very left 
        rats.anchor = GridBagConstraints.LINE_START;
        label = new JLabel("Enter Hamming Dist: ");
        
        //adds the panel and then adds it to the jpanel itself
        panel.add(label, rats);
        add(panel);
        
        //adding in the slider by similar prcoess as above
        GridBagConstraints rats2 = new GridBagConstraints();
        rats2.gridx = 0;
        rats2.gridy = 1;
        //adding the slider
        slider = new JSlider(1, 4);
        //adding the slider to the change listener
        //this change listener will be used to connect the slider number to the number that appears to the text
        slider.addChangeListener(this);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        rats.insets = new Insets(0, 0, 0, 0);
        rats.anchor = GridBagConstraints.LINE_START;
        
        //adding the slider to the panel
        panel.add(slider, rats2);
        add(panel);

        //adding the text space next to the "Enter Hamming Dist:" by same process as above
        rats = new GridBagConstraints();
        rats.gridx = 1;
        rats.gridy = 0;
        //Had to mess around with the placing so it could fit properly
        rats.insets = new Insets(10, -83, 10, 10);
        text = new JTextField("                                                   ");
        //This sets the text of the value that is in the slider
        text.setText(((java.lang.String) String).valueOf(slider.getValue()));
        //time to add it in
        panel.add(text, rats);
        add(panel);

        //This is setting the stage for the first button to appear
        rats = new GridBagConstraints();
        rats.gridx = 0;
        rats.gridy = 3;
        //this gives the button an actual action after being pressed
        button.addActionListener(this);
        //This sets it to the very left
        rats.anchor = GridBagConstraints.LINE_START;
        rats.insets = new Insets(20, 0, 10, 10);
        //adds to the panel
        panel.add(button, rats);
        add(panel);
        
        //This is used for the creation of the large box area 
        rats = new GridBagConstraints();
        rats.gridx = 0;
        rats.gridy = 5;
        //Creates the spaces around it
        rats.insets = new Insets(20, 30, 10, 10);
        //Adds it to the panel
        panel.add(bigBox, rats);
        add(panel);
        //I will be honest, I used a bit of youtube's help
        //Also used to give the slider actual use and change the number when slided
        event e = new event();
        slider.addChangeListener(e);
        
        //Creates the location for the Compare with that appears on the image
        rats = new GridBagConstraints();
        rats.gridx = 0;
        rats.gridy = 8;
        rats.anchor = GridBagConstraints.LINE_START;
        label = new JLabel("Compare with: ");
        //Adds to the panel
        panel.add(label, rats);
        add(panel);
        
        //Creates the location for the next button
        rats = new GridBagConstraints();
        rats.gridx = 0;
        rats.gridy = 9;
        //Giving the button a use when pressing
        //Setting to the very left
        button2.addActionListener(this);
        rats.anchor = GridBagConstraints.LINE_START;
        //The spacing
        rats.insets = new Insets(20, 0, 10, 10);
        //adds it to the panel
        panel.add(button2, rats);
        add(panel);
        
        //Creating the location for the drop down menu of the Stations
        rats = new GridBagConstraints();
        rats.gridx = 1;
        rats.gridy = 8;
        panel.add(box, rats);

        @SuppressWarnings("unchecked")

        // drop down box
        
        
        //Creating the different distances in words 
        //Then creating the text fields next to each distance
        JLabel d0 = new JLabel("Distance 0");
        dist0 = new JTextField("                              ");
        dist0.setEditable(false);

        JLabel d1 = new JLabel("Distance 1");
        dist1 = new JTextField("                              ");
        dist1.setEditable(false);

        JLabel d2 = new JLabel("Distance 2");
        dist2 = new JTextField("                              ");
        dist2.setEditable(false);

        JLabel d3 = new JLabel("Distance 3");
        dist3 = new JTextField("                              ");
        dist3.setEditable(false);

        JLabel d4 = new JLabel("Distance 4");
        dist4 = new JTextField("                              ");
        dist4.setEditable(false);

        //Creating the location for each corresponding distance 0
        rats.gridx = 0;
        rats.gridy = 10;
        rats.insets = new Insets(0, 0, 0, 0);
        rats.anchor = GridBagConstraints.LINE_START;
        //adding to the panel
        panel.add(d0, rats);

        //Creating the location for each corresponding distance 1

        rats.gridx = 0;
        rats.gridy = 12;
        rats.anchor = GridBagConstraints.LINE_START;
        //adding the panel
        panel.add(d1, rats);

        //Creating the location for each corresponding distance 2

        rats.gridx = 0;
        rats.gridy = 14;
        rats.anchor = GridBagConstraints.LINE_START;
        //adding to the panel
        panel.add(d2, rats);

        //Creating the location for each corresponding distance 3

        rats.gridx = 0;
        rats.gridy = 16;
        rats.anchor = GridBagConstraints.LINE_START;
        //adding to the panel
        panel.add(d3, rats);
        //Creating the location for each corresponding distance 4

        rats.gridx = 0;
        rats.gridy = 18;
        rats.anchor = GridBagConstraints.LINE_START;
        //adding to the panel
        panel.add(d4, rats);
        
        //Creating the location for each corresponding distance text 0
        
        rats.gridx = 1;
        rats.gridy = 10;
        rats.insets = new Insets(0, -80, 0, 0);
        panel.add(dist0, rats);
        
        //Creating the location for each corresponding distance text 1

        rats.gridx = 1;
        rats.gridy = 12;
        rats.insets = new Insets(0, -80, 0, 0);
        panel.add(dist1, rats);

        //Creating the location for each corresponding distance text 2

        rats.gridx = 1;
        rats.gridy = 14;
        rats.insets = new Insets(0, -80, 0, 0);
        panel.add(dist2, rats);

        //Creating the location for each corresponding distance text 3

        rats.gridx = 1;
        rats.gridy = 16;
        rats.insets = new Insets(0, -80, 0, 0);
        panel.add(dist3, rats);

        //Creating the location for each corresponding distance text 4

        rats.gridx = 1;
        rats.gridy = 18;
        rats.insets = new Insets(0, -80, 0, 0);
        panel.add(dist4, rats);

        //Creating the location for the third button and adding it the same way as the rest 
        //This is following the same process as the code that was used above
        rats = new GridBagConstraints();
        rats.gridx = 0;
        rats.gridy = 19;

        rats.anchor = GridBagConstraints.LINE_START;
        rats.insets = new Insets(20, 0, 0, 0);
        panel.add(button3, rats);
        add(panel);
        
        //Creating the location for the third button text addition and adding it the same way as the rest 
        //This is following the same process as the code that was used above
        //adding the button text to the panel
        button3.addActionListener(this);
        rats.gridx = 1;
        rats.gridy = 19;
        rats.anchor = GridBagConstraints.LINE_START;
        rats.insets = new Insets(0, -80, 0, 0);
        panel.add(button3Text, rats);
        
        rats.gridx = 4;
        rats.gridy = 2;
        JTextField creative = new JTextField("Roses are Red");
        creative.setBackground(Color.RED);
        rats.insets = new Insets(0, 0, 0, 0);
        panel.add(creative, rats);
        
        rats.gridx = 4;
        rats.gridy = 3;
        JTextField creative2 = new JTextField("Violets are Blue");
        creative2.setBackground(Color.BLUE);
        rats.insets = new Insets(0, 0, 0, 0);
        panel.add(creative2, rats);
        
        rats.gridx = 4;
        rats.gridy = 4;
        JTextField creative3 = new JTextField("My Brain is Dead");
        creative3.setBackground(Color.PINK);
        rats.insets = new Insets(0, 0, 0, 0);
        panel.add(creative3, rats);
        
        
        rats.gridx = 4;
        rats.gridy = 5;
        JTextField creative4 = new JTextField("And I Feel Like POO");
        Color brown = new Color(153, 102, 0);
        creative4.setBackground(brown);
        rats.insets = new Insets(0, 0, 0, 0);
        panel.add(creative4, rats);
        
        
        rats.gridx = 5;
        rats.gridy = 2;
        JTextField creative5 = new JTextField("I feel like an Ant");

        creative5.setBackground(Color.GREEN);
        rats.insets = new Insets(0, 0, 0, 0);
        panel.add(creative5, rats);
        
        
        rats.gridx = 5;
        rats.gridy = 3;
        JTextField creative6 = new JTextField("Somtimes not wearing a pant");
       
        creative6.setBackground(Color.CYAN);
        rats.insets = new Insets(0, 0, 0, 0);
        panel.add(creative6, rats);
        
        
        rats.gridx = 5;
        rats.gridy = 4;
        JTextField creative7 = new JTextField("And sometimes i even can't");
        
        creative7.setBackground(brown);
        rats.insets = new Insets(0, 0, 0, 0);
        panel.add(creative7, rats);
        
        
        rats.gridx = 5;
        rats.gridy = 5;
        JTextField creative8 = new JTextField("Feel like a plant");
  
        creative8.setBackground(Color.GREEN);
        rats.insets = new Insets(0, 0, 0, 0);
        panel.add(creative8, rats);
        
        rats.gridx = 6;
        rats.gridy = 3;
        JTextField creative9 = new JTextField("Just unwatered and unnourished");

        creative9.setBackground(Color.GRAY);
        rats.insets = new Insets(0, 0, 0, 0);
        panel.add(creative9, rats);
        
        
        rats.gridx = 6;
        rats.gridy = 4;
        JTextField creative10 = new JTextField("I just cant seem to flourish");
       
        creative10.setBackground(Color.CYAN);
        rats.insets = new Insets(0, 0, 0, 0);
        panel.add(creative10, rats);
        
        
        rats.gridx = 6;
        rats.gridy = 5;
        JTextField creative11 = new JTextField("But I know everywhere I go");
        
        creative11.setBackground(Color.YELLOW);
        rats.insets = new Insets(0, 0, 0, 0);
        panel.add(creative11, rats);
        
        
        rats.gridx = 6;
        rats.gridy = 6;
        JTextField creative12 = new JTextField("I will leave a trail that motivates anyone to follow! LETS GOOOOOOOOOO");
  
        creative12.setBackground(Color.MAGENTA);
        rats.insets = new Insets(0, 0, 0, 0);
        panel.add(creative12, rats);
        
        
    }
    
    //show the value of the slider on the text
    public void stateChanged(ChangeEvent event)
    {
        int sliderVal; // Slider value (int)
        String strSliderVal; // Slider value (string)

        // Get source of event (2 sliders in GUI)
        JSlider sourceEvent = (JSlider) event.getSource();

        if (sourceEvent == slider)
        {
            sliderVal = slider.getValue(); // Get slider value
            strSliderVal = Integer.toString(sliderVal); // Conver to int
            text.setText(strSliderVal);
            // Update display
        }

    }
    //show the value of the slider on the text
    public void stateChange(ChangeEvent b)
    {
        text.setText(((java.lang.String) String).valueOf(slider.getValue()));
    }

    //Adds all the names of the mesonext.txt to the drop down menu
    public void dropDown()
    {

        for (String thing : names)
            box.addItem(thing);

    }
    
    //Method that gets the hamming distance between the two strings
    //This is very important
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
    
    //This is used for finding the nodes between the strings of the stations and the string of the main 
    //
    public int[] CountDistances(String name)
    {
        // initializing two int arrays
        // These two arrays will be used to count the nodes for
        // WEST and BESS
        int d0 = 0;
        int d1 = 0;
        int d2 = 0;
        int d3 = 0;
        int d4 = 0;
        //
        // Count all the instances of a particular distance between name
        // and all the other names stored in "otherNames".
        //
        // Creating a for loop that will loop through the STids and count the
        // hamming distance between the name1 and the rest
        for (int i = 0; i < names.size(); i++)
        {
            //Creates all the nodes 
            //This is used by calling the getDistance method 
            
            int distance = getDistance(name, names.get(i));
            //increments the d0 variable   
            if (distance == 0)
            {
                ++d0;
            }
            //Increments the d1 variable
            else if (distance == 1)
            {
                ++d1;
            }
            //Increments the d2 variable
            else if (distance == 2)
            {
                ++d2;
            }
            //Increments the d3 variable
            else if (distance == 3)
            {
                ++d3;

            }
            //Increments the d4 variable
            else if (distance == 4)
            {
                ++d4;
            }
        }
        counts[0] = d0;
        counts[1] = d1;
        counts[2] = d2;
        counts[3] = d3;
        counts[4] = d4;
        return counts;
    }
    //This is creating all the actions for the buttons when pressed
    public void actionPerformed(ActionEvent event) 
    {
        //Setting the conditions and events for the first button
        if (event.getSource() == button)
        {
            //Setting the box area as an empty string 
            bigBox.setText("");
            sort((String) box.getSelectedItem());
        }
        //Sets the conditions for the second button
        else if (event.getSource() == button2)
        {
            //This will display all the nodes and assign all the nodes
            counts = CountDistances((String) box.getSelectedItem());
            displayTheNodes();
        }
        //This is setting conditions for the third button
        else if (event.getSource() == button3)
        {
            //Create a string that will house the third button
            String input = button3Text.getText();
            //An if statement that I copied from the internet
            if (((DefaultComboBoxModel) box.getModel()).getIndexOf(input) == -1)
            {
                box.addItem(input);
            }

        }
    }
    
    //Class and method that is used for the slider to actually work
    public class event implements ChangeListener
    {
        //The method
        public void stateChanged(ChangeEvent e)
        {
            int value = slider.getValue();

        }
    }
    
    //The main method that sets the size of the frame
    //Sets the title
    //And adds the exit on close portion
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        GraphicalHammingDistance test = new GraphicalHammingDistance();
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setSize(1000, 1000);

        test.setVisible(true);
        test.setTitle("Hamming Distance");

    }
}

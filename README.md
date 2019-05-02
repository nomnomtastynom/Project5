# Project5
-There is one huge class that my project uses and that is the GraphicalHammingDistance class as well as other smaller classes. This huge
class also 
-This class has several methods and we will discuss the various methods in detail.
-First the various variables are initialized and these are global variables that will be used by most of the code.
-The list goes as: names (which is an arraylist of string), slider (a jslider), label, panel, text, button, bigBox, button2, button3, 
counts, dist1, dist2, dist3, dist4, and the button3 text.
-I will address the variables as I elaborate more on my code as well as other variables that are used in the methods themselves.

Public void read:
-This is a class I implemented from my past coding projects that is used to read in the text file and to add all the various string
stations into an array list.

Public void sort:
-This method is a enhanced for loop and is quite short. It is used for the comparison and adds all the names in the big text box that shows the similar hamming distance dependant on the slider value.

Public void displayTheNodes:
-This method is short and simple and it is focused on setting the text regarding the different nodes. All this method is used for is to 
set the value based on counts, a variable that is used for adding the node values in. Sets all the distances based on the value of the
counts.

Public GraphicalHammingDistance constructor:
-first call the read method which reads in the location of the mesonet txt file
-next we setting the layout to be a specific layout called GridBagLayout which is the best layout I thought to use. I tried flowlayout
but it was not getting me what I wanted.
-I called the dropDown method. This method creates the dropdown menu which is based on an enhanced loop
-To set the layout for the different buttons and text on the image that appears, I used the gridx and gridy methods which sets the specific location on the grid. This is used for every single thing that appears on the image when run. I did this by testing various number and understanding the x and y components.
-First added the text of Enter hamming dist: to the top left 
-I also used anchor so that I can actually get the same areas as the example was given. I used LINE_START for the left hand most side
-I then added this text to the panel by using the panel.add method and then adding it to the jframe by using the add method
-Create the slider that will appear under the text and the location is given by a gridx and gridy that appears. 
-I looked at the oracle docs for the slider and set the ticks by 1 and to increment by 1
-Added to the panel and the fram
-Trying to set the location for the text field that will show the slider value
-Similar process as setting it as above;
-The buttons are added in a very similar manner and this is by finding the location, setting it, and giving the button the ability 
to actually work when pressed.
-The process stated directly above is used for the three buttons that appear on the image
-I need to add the compare text as well as the text that is used for the distance of 1,2,3,4 that will represent the node distances
of the comparing stations.
-The process is the same as adding for the other texts fields as stated above. Only difference is the location of them.
-We need a huge box that will show all the stations that have the same hamming distance as the station that is picked in the drop down menu and this box is set by a textArea method that is implicitely defined.
-reading through this, we see the method of insets being called and this method is to add spacing between this and componenets surrounding it and the values put will put space in the order of top, left, bottom, right. Negative numbers will move in the opposite direction

Public  void stateChanged:
-This method is a method I pulled from the zybooks and it used to display the slider value into the text field so we can see the number in real time and have a connection with the code. This is doen by creating a sourceEvent and this event when equivalent to the slider value will get the value, convert that value to a integer to read and then put that integer in the text location that is abover it. 

Public void stateChange:
-This is similar to the top method as in it is used to set the text but it is used to set the text to the first textbox by using the valueOf method

Public void dropDown:
-This method is focused on bringing the drop down menu that appears on the middle of the image. This drop down menu is an enhanced for loop that adds all the stationIDS that are in names and this is added to the JComboBox. This is the box that can store and create the drop down menu.

Public int getDistance:
-This method is used to find the hamming distance between two strings. It takes in the two strings, compares the specific characters of 
each and then this hamming distance is stored in a variable.

Public int[] CountDistances:
-This method is copied from the project 1 but is modified to fit this project. It takes in only one string parameter and creates 5 different integers. These integers will be used for the node values. A for loop is used to find the distances between the string that is passed in and the rest of the stationIDS. Then depending on the value that is gotten, it is added to the corresponding variable. These corresponding variables are then assigned to the counts array method that is set at the beginning. 

Public void actionPerformed:
-This method is focused on giving the three buttons real properties when clicked and real feedback. The first button will be used to the show the various stations similar hamming distances to the one being compared.
-The second portion is focused on calculating the specific hamming distances from the station that is used from the drop down menu. It calls the displayTheNodes to assign the values as discussed earlier.
-The third portion is used to add a new station into the program. The new station must be able to be used in the same way as the other stations. The code overall for these three are mostly understandable.

Public class event implements ChangeListener:
-I learned the code from youtube and this is used so that the slider will actually work properly in the code. It calls the stateChanged method and an integer value is set to equal the slider value.

Public static void main:
-This is the method where the jframe is given the parameters. When it will be closed, what the sizing will be, as well whether it is visible or not and even a title. It also calls the constructor so that the code will actually run.

I have to say, this project was really hard. It was long and tedious, but I guess that is how real life projects. I cant say I was glad doing this but at the same time, I have to say I learned a lot. This I beleive too me about 12 hours to do and that is crazy. I realized how much I didnt know as well and oh boy am I glad to be done with it now!


![Capture 3](https://user-images.githubusercontent.com/25664890/57073888-04106680-6ca8-11e9-81ca-fcf050b9c87e.PNG)

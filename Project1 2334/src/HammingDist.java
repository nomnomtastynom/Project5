import java.io.BufferedReader;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HammingDist
{
    // This is the constructor that will print out the required output

    public HammingDist(String stationOne, String stationTwo) throws IOException
    {
        // Created a buffered reader. Also read in the Mesonet.txt file
        BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
        // Created an arraylist of strings to store the string Stids
        ArrayList<String> names = new ArrayList<String>();

        // The three readLines are for skipping the first three rows
        br.readLine();
        br.readLine();
        br.readLine();
        // Creating a while loop that will loop as long as String Line does not
        // go to the end
        // of the file

        String line;
        while ((line = br.readLine()) != null)
        {
            // Creating a columns string array that will take in the txt file
            // This array will contain the columns which are separated by a
            // white space
            String[] columns = line.split(" ");
            // Getting all the stationIds in the second column and putting them
            // in name
            String name = columns[1];
            // Adding all the stationIds to the arraylist Names
            names.add(name);
        }
        // This is the first part of the output.
        // It called the getDistance method to calculate the hamming distance
        // between the two
        System.out.println("The Hamming Distance of WEST and BESS: " + getDistance(stationOne, stationTwo) + ".");
        // This calls the CountDistances method to finish the rest of the output
        CountDistances(stationOne, stationTwo, names);
        br.close();

    }

    // This is a getDistance method that will be used to check the hamming
    // distance
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

    // Creating a new method to get the nodes necessary for the output
    public void CountDistances(String name, String name2, List<String> otherNames)
    {
        // initializing two int arrays
        // These two arrays will be used to count the nodes for
        // WEST and BESS
        int[] counts = { 0, 0, 0, 0, 0 };
        int[] counts2 = { 0, 0, 0, 0, 0 };
        //
        // Count all the instances of a particular distance between name
        // and all the other names stored in "otherNames".
        //
        // Creating a for loop that will loop through the STids and count the
        // hamming distance between the name1 and the rest
        for (int i = 0; i < otherNames.size(); i++)
        {
            int distance = getDistance(name, otherNames.get(i));
            counts[distance]++;
        }

        // setting all the different counts to the node integers n1 to n4
        // These are assigned to the array placements in counts
        int n1 = counts[1];
        int n2 = counts[2];
        int n3 = counts[3];
        int n4 = counts[4];
        // setting the size to 119 rather than the size being 120
        int size = otherNames.size() - 1;
        // This is the specific println for the node portion of the output
        // This is specific for the first word: WEST
        System.out.println("Out of " + size + ", for " + name + ", number of nodes are: " + n1 + ", " + n2 + ", " + n3
                + ", " + n4 + " and");
        // Creating a for loop that will loop through the STids and count the
        // hamming distance between the name2 and the rest.
        for (int i = 0; i < otherNames.size(); i++)
        {
            int distance = getDistance(name2, otherNames.get(i));
            counts2[distance]++;
        }
        // setting all the different counts to the node integers n1 to n4
        // These are assigned to the array placements in counts
        n1 = counts2[1];
        n2 = counts2[2];
        n3 = counts2[3];
        n4 = counts2[4];
        // This is the last part of the output
        // This is the specific println needed for: BESS
        System.out.println(
                "for " + name2 + ", number of nodes are: " + n1 + ", " + n2 + ", " + n3 + ", " + n4 + " respectively.");

    }

}

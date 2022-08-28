package main.java;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.IOException; // Import the IOException class to handle errors
import java.io.FileWriter; // Import the FileWriter class
import java.util.*;

public class Coordinates {

    public static void main(final String[] args) {

        int PointsToSuggest_X_from_pisteet = 0;
        int PointsToSuggest_Y_from_pisteet = 0;
        int PointsInPolygon_X_from_Polygoni = 0;
        int PointsInPolygon_Y_from_Polygoni = 0;
        int NumOfPolygoniCoordinates = 0;
        int NumOfPisteetCoordinates = 0;
        List<String> fileOutputFromPolygoni = new ArrayList<String>();
        List<String> fileOutputFromPisteet = new ArrayList<String>();

        // Read coordinates from polygoni.txt

        try {
            File myPolygoniFile = new File("src/polygoni.txt");
            Scanner myPolygoniFileReader = new Scanner(myPolygoniFile);
            while (myPolygoniFileReader.hasNextLine()) {
                String polygoniData = myPolygoniFileReader.nextLine();

                // SPLIT POINTS from data in polygoni.txt

                String polygoniPoints[] = polygoniData.split("\\:");
                NumOfPolygoniCoordinates = polygoniPoints.length;
                for (int k = 0; k < NumOfPolygoniCoordinates; k++) {
                    // One point
                    String one_point[] = polygoniPoints[k].split("\\,");
                    // If coordinate length is different than 2, skip error
                    if (one_point.length != 2) {
                        System.out.println(
                                "Wrong length in Polygoni.txt points. Must be atleast 2 values for each coordinate.");
                        continue;
                    }

                    // Value control, coordinate can't be over 20 or under 0

                    if (Integer.parseInt(one_point[0]) > 20 ) {
                        System.out.println("polygoni X value is over 20");
                    
                    } else if (Integer.parseInt(one_point[0]) < 0 ) {
                        System.out.println("polygoni X value is under 0");
                    }
                    if (Integer.parseInt(one_point[1]) > 20 ) {
                        System.out.println("polygoni Y value is over 20");
                    } else if (Integer.parseInt(one_point[1]) < 0 ) {
                        System.out.println("polygoni Y value is under 0");
                    }
                    PointsInPolygon_X_from_Polygoni = Integer.parseInt(one_point[0]);
                    PointsInPolygon_Y_from_Polygoni = Integer.parseInt(one_point[1]);

                    // Create hashmaps for checking boolean values from each stored coordinate in Polygoni

                    HashMap<Integer, Boolean> mapX_from_PolygoniCoordinates = new HashMap<>();
                    HashMap<Integer, Boolean> mapY_from_PolygoniCoordinates = new HashMap<>();

                    
                    mapX_from_PolygoniCoordinates.put(PointsInPolygon_X_from_Polygoni, true);
                    mapY_from_PolygoniCoordinates.put(PointsInPolygon_Y_from_Polygoni, true);
                    fileOutputFromPolygoni.add("Polygoni X=" + mapX_from_PolygoniCoordinates + ", Y="
                    + mapY_from_PolygoniCoordinates + ",");

                }
            }

            myPolygoniFileReader.close();
            // error handling with file
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred, File not found.");
            e.printStackTrace();
        }

        // Read coordinates from pisteet.txt

        try {
            File myPisteetFile = new File("src/pisteet.txt");
            Scanner myPisteetFileReader = new Scanner(myPisteetFile);
            while (myPisteetFileReader.hasNextLine()) {
                String myPisteetFileData = myPisteetFileReader.nextLine();

                // Split points to get value how many coordinate there is
                String PisteetCoordinates[] = myPisteetFileData.split("\\:");

                NumOfPisteetCoordinates = PisteetCoordinates.length;

                for (int k = 0; k < NumOfPisteetCoordinates; k++) {

                    // Separate x and y for coordination
                    String one_point[] = PisteetCoordinates[k].split("\\,");
                    // If coordinate length is different than 2, skip error
                    if (one_point.length != 2) {
                        System.out.println(
                                "Wrong length in Pisteet.txt points. Must be atleast 2 values for each coordinate.");
                        continue;
                    }
                    if (Integer.parseInt(one_point[0]) > 20 ) {
                        System.out.println("Pisteet X value is over 20");
                    
                    } else if (Integer.parseInt(one_point[0]) < 0 ) {
                        System.out.println("Pisteet X value is under 0");
                    }
                    if (Integer.parseInt(one_point[1]) > 20 ) {
                        System.out.println("Pisteet Y value is over 20");
                    } else if (Integer.parseInt(one_point[1]) < 0 ) {
                        System.out.println("Pisteet Y value is under 0");
                    }
                    PointsToSuggest_X_from_pisteet = Integer.parseInt(one_point[0]);
                    PointsToSuggest_Y_from_pisteet = Integer.parseInt(one_point[1]);
                    

                    // Create hashmaps for storing booleans from each coordinate in Pisteet

                    HashMap<Integer, Boolean> mapX_from_PointsToSuggest_pisteet = new HashMap<>();
                    HashMap<Integer, Boolean> mapY_from_PointsToSuggest_pisteet = new HashMap<>();

                   
                    mapX_from_PointsToSuggest_pisteet.put(PointsToSuggest_X_from_pisteet, true);
                    mapY_from_PointsToSuggest_pisteet.put(PointsToSuggest_Y_from_pisteet, true);
                    fileOutputFromPisteet.add("Pisteet X=" + mapX_from_PointsToSuggest_pisteet + ", Y="
                            + mapY_from_PointsToSuggest_pisteet + ",");
                          

                }
            }
           

            myPisteetFileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred, File not found.");
            e.printStackTrace();
        }
        // Check if selvitys.txt exist
        try {
            File mySelvitysFile = new File("./selvitys.txt");
            if (mySelvitysFile.createNewFile()) {
                System.out.println("File created: " + mySelvitysFile.getName());
            } else {
                System.out.println("selvitys.txt already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // Write info on selvitys.txt from helper variables, with values how many coordinates there is currently
       
        try {
            FileWriter myWriter = new FileWriter("./selvitys.txt");
            myWriter.write("Number of Polygoni Coordinates:" + Integer.toString(NumOfPolygoniCoordinates)
                    + System.lineSeparator());
            for (String str : fileOutputFromPolygoni) {
                myWriter.write(str + System.lineSeparator());
            }
            myWriter.write("Number of Pisteet Coordinates:" + Integer.toString(NumOfPisteetCoordinates)
                    + System.lineSeparator());

            for (String str : fileOutputFromPisteet) {
                myWriter.write(str + System.lineSeparator());
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        
    }
   
    
    
}

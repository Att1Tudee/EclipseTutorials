package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CoordinateCreator {
    public static void main (String[] args) {

        // most of the code here for reading from a file I borrowed from
        // http://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/

        BufferedReader br = null;
        int length, width;

        try {

            String currentLine;

            // open the file and start reading it
            br = new BufferedReader(new FileReader("src/main/resources/filename.txt"));
            currentLine = br.readLine();

            // only need to do anything if there is something in the file
            if (currentLine != null) {

                // using a do-while loop instead of a while loop so that
                // we can check if there is another line and print out a
                // blank line before the next rectangle
                do {

                    // split the line into two strings, length and width
                    String[] dimensions = currentLine.split(" ");

                    // parse the strings into integers
                    // if they are not proper numbers, set them to 0
                    try {
                        length = Integer.parseInt(dimensions[0]);
                        width = Integer.parseInt(dimensions[1]);
                    } catch (NumberFormatException e) {
                        length = 0;
                        width = 0;
                    }

                    // print out the rectangle
                    printRectangle(length, width);

                    // read the next line and print out a 
                    // blank line if there was something to read
                    currentLine = br.readLine();
                    if (currentLine != null) {
                        System.out.println();
                    }
                } while (currentLine != null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            // you should always close a file when you're done with it
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printRectangle(int length, int width) {

        // make sure we're trying to print a rectangle with real dimensions
        if (length <= 0 || width <= 0) {
            return;
        }

        // print `length` lines
        for (int l = 0; l < length; l++) {

            // print `width` #'s in each line
            for (int w = 0; w < width; w++) {

                // using print() because the #'s need to all be on one line
                System.out.print("#");
            }

            // print out a newline when we're done printing  #'s
            System.out.println();
        }
    }
}
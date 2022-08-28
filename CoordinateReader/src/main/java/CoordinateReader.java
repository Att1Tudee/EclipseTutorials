package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CoordinateReader {
	private String coordinateFile;

	public CoordinateReader(String coordinateFile) {
		this.coordinateFile = coordinateFile;
	}
		
		 BufferedReader br = null;
	        int length, width;

	        try {

	            String currentLine;

	            // open the file and start reading it
	            br = new BufferedReader(new FileReader();
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
}

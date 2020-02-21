import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class CSVReader {

    //Create 2d array of strings
    private List<List<String>> lines = new ArrayList<>();
    private String filePath;

   public CSVReader(String filePath){
       this.filePath = filePath;
       File file = new File(this.filePath);

       Scanner input;

       try {
           input = new Scanner(file);

           //While there is more data to read:
           while (input.hasNext()) {
               //String line = next line in file
               String line = input.next();
               //Split line up by commas and add to array of type string called content
               String[] content = line.split(",");
               //Add content of line to 2d array lines
               lines.add(Arrays.asList(content));
           }
            //Close file when fully read from it
           input.close();
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }

   }

   //Get the data read from the csv file in form of 2d array
   public List<List<String>> getLines(){
       return this.lines;

   }

}


//https://stackoverflow.com/questions/40074840/reading-a-csv-file-into-a-array

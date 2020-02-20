import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class CSVReader {

    private List<List<String>> lines = new ArrayList<>();
    private String filePath;

   public CSVReader(String filePath){
       this.filePath = filePath;
       File file = new File(this.filePath);

       Scanner input;

       try {
           input = new Scanner(file);

           while (input.hasNext()) {
               String line = input.next();
               String[] content = line.split(",");
               lines.add(Arrays.asList(content));
           }

           input.close();
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }

   }

   public List<List<String>> getLines(){
       return this.lines;

   }

}


//https://stackoverflow.com/questions/40074840/reading-a-csv-file-into-a-array

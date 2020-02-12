import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class CSVReader {

    private String filePath;

   public CSVReader(String filePath){
       this.filePath = filePath;
       File file = new File(this.filePath);

       List<List<String>> lines = new ArrayList<>();
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
       System.out.println(lines);

   }

    public static void main(String[] args) {


    }

}


//https://stackoverflow.com/questions/40074840/reading-a-csv-file-into-a-array

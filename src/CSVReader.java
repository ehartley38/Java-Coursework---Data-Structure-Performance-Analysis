import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class CSVReader {

    private String filePath;

    /*public CSVReader(String filePath) {
        this.filePath = filePath;
    }*/

   /* public List<String[]> readCSV() throws IOException {
        int count = 0;
        List<String[]> content = new ArrayList<>();
        List<String[]> content2 = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                content.add(line.split(","));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Broke");
        }
        for (int i = 0; i < content.size(); i++) {
            System.out.println(content.get(i).collect(Collectors.joining()));
        }
        return content2;

    }*/

   public CSVReader(){
       System.out.println("test");
       File file = new File("test_data.csv");

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




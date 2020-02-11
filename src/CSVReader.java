import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {

    private String filePath;
    private ArrayList<String> csvValues;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner  = new Scanner(new File("test_data.csv"));

        scanner.useDelimiter(",");
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }
        scanner.close();



    }




}

import java.util.Arrays;
import java.util.Scanner;

public class Input {

   private String csvFile, directoryType;


    public Input(String csvFile, String directoryType){

        this.csvFile = csvFile;

        if (directoryType.toLowerCase().equals("array")) {
            ArrayDirectory ad = new ArrayDirectory(csvFile);
            System.out.println(Arrays.toString(ad.getMembers()));
        } else if (directoryType.toLowerCase().equals("arraylist")) {
            ArrayListDirectory ald = new ArrayListDirectory(csvFile);
            System.out.println(ald.getMembers());
        } else if (directoryType.toLowerCase().equals("hashmap")) {
            HashMapDirectory hmd = new HashMapDirectory(csvFile);
            System.out.println(hmd.getInitials());
            System.out.println(hmd.getExtension());

        } else {
            System.out.println("Incorrect directory type selected");
        }


    }

    public String getCsvFile() {
        return csvFile;
    }

    public String getDirectoryType() {
        return directoryType;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



    }

}

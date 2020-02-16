import java.util.Arrays;
import java.util.Scanner;

public class Input {

   private String csvFile, directoryType;
   private Scanner scanner;
   private ArrayDirectory ad;
   private ArrayListDirectory ald;
   private HashMapDirectory hmd;

    public Input(String csvFile, String typeOfDirectory){

        this.csvFile = csvFile;

        if (typeOfDirectory.toLowerCase().equals("array")) {
            ad = new ArrayDirectory(csvFile);
            directoryType = "array";
        } else if (typeOfDirectory.toLowerCase().equals("arraylist")) {
            ald = new ArrayListDirectory(csvFile);
            directoryType = "arrayList";
        } else if (typeOfDirectory.toLowerCase().equals("hashmap")) {
            hmd = new HashMapDirectory(csvFile);
            directoryType = "hashmap";
        } else {
            System.out.println("Incorrect directory type selected");
            System.exit(0);
        }
        scanner = new Scanner(System.in);
        getMemberDetails();




    }

    private void getMemberDetails(){
        System.out.println("Enter the staff members surname: ");
        String surname = scanner.nextLine();
        System.out.println("Enter the staff members initials: ");
        String initials = scanner.nextLine();
        System.out.println("Enter the staff members extension number: ");
        String extension = scanner.nextLine();
        while (!checkExtensionFormat(extension)) {
            System.out.println("Extension number has to begin with a 0 and be 5 digits in length. Please try again: ");
            extension = scanner.nextLine();
        }


        if (directoryType.equals("array")) {
            ad.insertEntry(new Entry(surname, initials, extension));
        } else if (directoryType.equals("arrayList")) {
            ald.insertEntry(new Entry(surname, initials, extension));
        } else if (directoryType.equals("hashmap")) {
            hmd.insertEntry(new Entry(surname, initials, extension));
        }


    }

    private boolean checkExtensionFormat(String extension) {
        return extension.substring(0, 1).matches("0") && extension.length() == 5;
    }


    public String getCsvFile() {
        return csvFile;
    }

    public String getDirectoryType() {
        return directoryType;
    }



}

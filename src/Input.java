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

        switch (typeOfDirectory.toLowerCase()) {
            case "array":
                ad = new ArrayDirectory(csvFile);
                directoryType = "array";
                break;
            case "arraylist":
                ald = new ArrayListDirectory(csvFile);
                directoryType = "arrayList";
                break;
            case "hashmap":
                hmd = new HashMapDirectory(csvFile);
                directoryType = "hashmap";
                break;
            default:
                System.out.println("Incorrect directory type selected");
                System.exit(0);
        }
        scanner = new Scanner(System.in);
        while (true) {
            getMemberDetails();
            System.out.println(Arrays.toString(ad.getMembers()));
        }





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


        switch (directoryType) {
            case "array":
                ad.insertEntry(new Entry(surname, initials, extension));
                break;
            case "arrayList":
                ald.insertEntry(new Entry(surname, initials, extension));
                break;
            case "hashmap":
                hmd.insertEntry(new Entry(surname, initials, extension));
                break;
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

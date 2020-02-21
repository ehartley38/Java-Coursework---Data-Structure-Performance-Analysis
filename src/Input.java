import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    private String csvFile, directoryType;
    private Scanner scanner;
    private StopWatch stopwatch;
    private ArrayDirectory ad;
    private ArrayListDirectory ald;
    private HashMapDirectory hmd;
    private Output out;

    public Input(String csvFile, String typeOfDirectory) throws IOException {

        this.csvFile = csvFile;
        out = new Output("AnalysisResults.txt", false, "array");

        //Check the directory type chosen and create objects of directories accordingly
        switch (typeOfDirectory.toLowerCase()) {
            case "array":
                ad = new ArrayDirectory(csvFile);
                directoryType = "array";
                break;
            case "arraylist":
                ald = new ArrayListDirectory(csvFile);
                directoryType = "arraylist";
                break;
            case "hashmap":
                hmd = new HashMapDirectory(csvFile);
                directoryType = "hashmap";
                break;
            default:
                System.out.println("Incorrect directory type selected");
                System.exit(0);
        }

        stopwatch = new StopWatch();
        scanner = new Scanner(System.in);
        //Continuously loop through menu
        while (true) {
            System.out.println("Menu\nInsert New Entry - 1\nDelete Entry Using Name - 2\nDelete Entry Using Extension - 3" +
                    "\nUpdate Extension Using Name - 4\nLookup Extension - 5\nPrint Directory - 6\nSave to CSV - 7\nExit - 8");
            String choice = scanner.nextLine();
            //Check desicion of user input
            getDecision(choice);
        }


    }

    //Menu process for inputting a new staff member
    private void insertStaffMember() {
        System.out.println("Enter the staff members surname: ");
        String surname = scanner.nextLine();
        System.out.println("Enter the staff members initials: ");
        String initials = scanner.nextLine();
        System.out.println("Enter the staff members extension number: ");
        String extension = scanner.nextLine();
        //Check if extension input complies with extension format rules
        if (checkExtensionFormat(extension)) {
            System.out.println("Entry submitted");
        }
        //Keep asking user to input extension until it is of correct format
        while (!checkExtensionFormat(extension)) {
            System.out.println("Extension number has to begin with a 0 and be 5 digits in length. Please try again: ");
            extension = scanner.nextLine();
            if (checkExtensionFormat(extension)) {
                System.out.println("Entry submitted");
            }
        }

        //Depending on directory type chosen at start, add staff member to relevant directory
        switch (directoryType) {
            case "array":
                ad.insertEntry(new Entry(surname, initials, extension));
                break;
            case "arraylist":
                ald.insertEntry(new Entry(surname, initials, extension));
                break;
            case "hashmap":
                hmd.insertEntry(new Entry(surname, initials, extension));
                break;
        }


    }

    //Return true if extension starts with a 0 and is length 5
    private boolean checkExtensionFormat(String extension) {
        return extension.substring(0, 1).matches("0") && extension.length() == 5;
    }

    //Run relevant methods depending on what user chose in menu
    private void getDecision(String choice) throws FileNotFoundException, UnsupportedEncodingException {

        switch (choice) {
            case "1":
                insertStaffMember();
                break;
            case "2":
                deleteStaffMemberUsingName();
                break;
            case "3":
                deleteStaffMemberUsingExtension();
                break;
            case "4":
                updateExtensionUsingName();
                break;
            case "5":
                lookupExtensionUsingName();
                break;
            case "6":
                printDirectory();
                break;
            case "7":
                if (directoryType.equals("array")) {
                    ad.outputToCSV();
                    break;
                } else if (directoryType.equals("arraylist")){
                    ald.outputToCSV();
                    break;
                } else {
                    hmd.outputToCSV();
                    break;
                }
            case "8":
                System.exit(0);
        }
    }

    //Delete staff member using name menu process
    private void deleteStaffMemberUsingName() {
        System.out.println("Enter the surname of the staff member you wish to delete: ");
        String surname = scanner.nextLine();

        switch (directoryType) {
            case "array":
                ad.deleteEntryUsingName(surname);
                break;
            case "arraylist":
                ald.deleteEntryUsingName(surname);
                break;
            case "hashmap":
                hmd.deleteEntryUsingName(surname);
                break;
        }
        System.out.println("Deleted");

    }

    //Delete staff member using extension menu process
    private void deleteStaffMemberUsingExtension() {
        System.out.println("Enter the extension of the staff member you wish to delete: ");
        String extension = scanner.nextLine();

        switch (directoryType) {
            case "array":
                ad.deleteEntryUsingExtension(extension);
                break;
            case "arraylist":
                ald.deleteEntryUsingExtension(extension);
                break;
            case "hashmap":
                hmd.deleteEntryUsingExtension(extension);
                break;
        }
        System.out.println("Deleted");

    }

    //Update extension using surname menu process
    private void updateExtensionUsingName() {
        System.out.println("Enter the surname of the staff member whose extension you wish to update: ");
        String surname = scanner.nextLine();
        String extension;
        assert false;
        System.out.println("Enter the new extension: ");
        extension = scanner.nextLine();
        //Keep asking for user to input correct extension format until they do
        while (!checkExtensionFormat(extension)) {
            System.out.print("Extension is of wrong format. Please try again");
            extension = scanner.nextLine();
        }

        switch (directoryType) {
            case "array":
                ad.updateExtensionUsingName(surname, extension);
                break;
            case "arraylist":
                ald.updateExtensionUsingName(surname, extension);
                break;
            case "hashmap":
                hmd.updateExtensionUsingName(surname, extension);
                break;
        }
        System.out.println("Updated");
    }

    //Lookup member extensions using their surname
    private void lookupExtensionUsingName() {
        System.out.println("Enter a surname to see their extension number: ");
        String surname = scanner.nextLine();

        switch (directoryType) {
            case "array":
                System.out.println(ad.lookupExtension(surname));
                break;
            case "arraylist":
                System.out.println(ald.lookupExtension(surname));
                break;
            case "hashmap":
                System.out.println(hmd.lookupExtension(surname));
                break;
        }

    }

    //Print the directory to command line in neat ascii table format
    private void printDirectory() {

        switch (directoryType) {
            case "array":
                out.printDirectoryASCII((ArrayList<Entry>) ad.toArrayList());
                break;
            case "arraylist":
                out.printDirectoryASCII((ArrayList<Entry>) ald.toArrayList());
                break;
            case "hashmap":
                out.printDirectoryASCII((ArrayList<Entry>) hmd.toArrayList());
                break;
        }
    }

    public String getCsvFile() {
        return csvFile;
    }

    public String getDirectoryType() {
        return directoryType;
    }


}

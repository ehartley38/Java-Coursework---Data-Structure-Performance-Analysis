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
        while (true) {
            System.out.println("Menu\nInsert New Entry - 1\nDelete Entry Using Name - 2\nDelete Entry Using Extension - 3" +
                    "\nUpdate Extension Using Name - 4\nLookup Extension - 5\nPrint Directory - 6\nSave to CSV - 7\nExit - 8");
            String choice = scanner.nextLine();
            getDecision(choice);
        }


    }

    private void insertStaffMember() {
        System.out.println("Enter the staff members surname: ");
        String surname = scanner.nextLine();
        System.out.println("Enter the staff members initials: ");
        String initials = scanner.nextLine();
        System.out.println("Enter the staff members extension number: ");
        String extension = scanner.nextLine();
        if (checkExtensionFormat(extension)) {
            System.out.println("Entry submitted");
        }
        while (!checkExtensionFormat(extension)) {
            System.out.println("Extension number has to begin with a 0 and be 5 digits in length. Please try again: ");
            extension = scanner.nextLine();
            if (checkExtensionFormat(extension)) {
                System.out.println("Entry submitted");
            }
        }


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

    private boolean checkExtensionFormat(String extension) {
        return extension.substring(0, 1).matches("0") && extension.length() == 5;
    }

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

    private void updateExtensionUsingName() {
        System.out.println("Enter the surname of the staff member whose extension you wish to update: ");
        String surname = scanner.nextLine();
        String extension;
        assert false;
        System.out.println("Enter the new extension: ");
        extension = scanner.nextLine();
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

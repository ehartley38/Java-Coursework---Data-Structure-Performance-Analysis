import java.util.Scanner;

public class Input {

    private String csvFile, directoryType;
    private Scanner scanner;
    private StopWatch stopwatch;
    private ArrayDirectory ad;
    private ArrayListDirectory ald;
    private HashMapDirectory hmd;

    public Input(String csvFile, String typeOfDirectory) {

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

        stopwatch = new StopWatch();
        scanner = new Scanner(System.in);
        Boolean run = true;
        while (run) {
            System.out.println("Menu\nInsert New Entry - 1\nPrint Directory - 2\nExit - 3");
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

    private void getDecision(String choice) {

        switch (choice) {
            case "1":
                insertStaffMember();
                break;
            case "2":
                System.out.println("Print array directory");
                break;
            case "3":
                System.exit(0);
        }
    }



    public String getCsvFile() {
        return csvFile;
    }

    public String getDirectoryType() {
        return directoryType;
    }


}

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Output {

    PrintWriter writer;
    String fileName, directoryType;
    PerformanceTesting pt;


    public Output(String fileName, boolean runAnalysis, String directoryType) throws IOException {

        this.fileName = fileName;
        this.directoryType = directoryType;
        //If runAnalysis set to true, then  write performance file.
        if (runAnalysis) {
            performanceAnalysisFile();
        }

    }

    //Write performance analysis file
    private void performanceAnalysisFile() throws IOException {
        pt = new PerformanceTesting();

        writer = new PrintWriter(fileName, StandardCharsets.UTF_8);
        //Write content of performance analysis file
        writer.println("---PERFORMANCE RESULTS---\n");
        printDataInsertionResults();
        printDataLookupResults();
        printDataDeletionByNameResults();
        printDataDeletionByExtensionResults();
        writer.close();

    }
    //print data insertion results using all the test objects created in performance analysis class
    private void printDataInsertionResults() {
        writer.println("DATA INSERTION\n");
        writer.println("Array ");
        writer.println("Best case " + pt.arrayTests.get(0).bestCase + "\n" + "Worst case " + pt.arrayTests.get(0).worstCase
                + "\n" + "Average " + pt.arrayTests.get(0).averageTime);

        writer.println("\nArrayList ");
        writer.println("Best case " + pt.arrayListTests.get(0).bestCase + "\n" + "Worst case " + pt.arrayListTests.get(0).worstCase
                + "\n" + "Average " + pt.arrayListTests.get(0).averageTime);

        writer.println("\nHashMap ");
        writer.println("Best case " + pt.hashMapTests.get(0).bestCase + "\n" + "Worst case " + pt.hashMapTests.get(0).worstCase
                + "\n" + "Average " + pt.hashMapTests.get(0).averageTime);

    }

    //print data lookup results using all the test objects created in performance analysis class
    private void printDataLookupResults() {
        writer.println("\nDATA LOOKUP\n");
        writer.println("Array ");
        writer.println("Best case " + pt.arrayTests.get(1).bestCase + "\n" + "Worst case " + pt.arrayTests.get(1).worstCase
                + "\n" + "Average " + pt.arrayTests.get(1).averageTime);

        writer.println("\nArrayList ");
        writer.println("Best case " + pt.arrayListTests.get(1).bestCase + "\n" + "Worst case " + pt.arrayListTests.get(1).worstCase
                + "\n" + "Average " + pt.arrayListTests.get(1).averageTime);

        writer.println("\nHashMap ");
        writer.println("Best case " + pt.hashMapTests.get(1).bestCase + "\n" + "Worst case " + pt.hashMapTests.get(1).worstCase
                + "\n" + "Average " + pt.hashMapTests.get(1).averageTime);
    }

    //print data deletion results using all the test objects created in performance analysis class
    private void printDataDeletionByNameResults() {
        writer.println("\nDATA DELETION BY NAME\n");
        writer.println("Array ");
        writer.println("Best case " + pt.arrayTests.get(2).bestCase + "\n" + "Worst case " + pt.arrayTests.get(2).worstCase
                + "\n" + "Average " + pt.arrayTests.get(2).averageTime);

        writer.println("\nArrayList ");
        writer.println("Best case " + pt.arrayListTests.get(2).bestCase + "\n" + "Worst case " + pt.arrayListTests.get(2).worstCase
                + "\n" + "Average " + pt.arrayListTests.get(2).averageTime);

        writer.println("\nHashMap ");
        writer.println("Best case " + pt.hashMapTests.get(2).bestCase + "\n" + "Worst case " + pt.hashMapTests.get(2).worstCase
                + "\n" + "Average " + pt.hashMapTests.get(2).averageTime);
    }

    //print data deletion results using all the test objects created in performance analysis class
    private void printDataDeletionByExtensionResults() {
        writer.println("\nDATA DELETION BY EXTENSION\n");
        writer.println("Array ");
        writer.println("Best case " + pt.arrayTests.get(3).bestCase + "\n" + "Worst case " + pt.arrayTests.get(3).worstCase
                + "\n" + "Average " + pt.arrayTests.get(3).averageTime);

        writer.println("\nArrayList ");
        writer.println("Best case " + pt.arrayListTests.get(3).bestCase + "\n" + "Worst case " + pt.arrayListTests.get(3).worstCase
                + "\n" + "Average " + pt.arrayListTests.get(3).averageTime);

        writer.println("\nHashMap ");
        writer.println("Best case " + pt.hashMapTests.get(3).bestCase + "\n" + "Worst case " + pt.hashMapTests.get(3).worstCase
                + "\n" + "Average " + pt.hashMapTests.get(3).averageTime);
    }

    //Print directory out in neat ascii table format
    public void printDirectoryASCII(ArrayList<Entry> members) {
        System.out.println("+--------------------+--------------------+--------------------+");
        System.out.println("|       Surname      |       Initials     |      Extension     |");
        System.out.println("+--------------------+--------------------+--------------------+");

        //For every member in members array list class, populate table with their information
        for (Entry member : members) {
            System.out.println("|" + asciiPaddedData(member.getSurname()) + "|" + asciiPaddedData(member.getInitials()) + "|" +
                    asciiPaddedData(member.getExtension()) + "|");
        }
        System.out.println("+--------------------+--------------------+--------------------+");



    }

    //Pad the strings in the table with tailing spaces to make table line up
     public String asciiPaddedData(String test) {
        return String.format("%-20s", test);
    }




}

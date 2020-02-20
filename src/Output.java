import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Output {

    PrintWriter writer;
    String fileName, directoryType;
    PerformanceTesting pt;


    public Output(String fileName, boolean runAnalysis, String directoryType) throws IOException {

        this.fileName = fileName;
        this.directoryType = directoryType;

        if (runAnalysis) {
            performanceAnalysisFile();
        }

    }


    private void performanceAnalysisFile() throws IOException {
        pt = new PerformanceTesting();

        writer = new PrintWriter(fileName, StandardCharsets.UTF_8);

        writer.println("---PERFORMANCE RESULTS---\n");
        printDataInsertionResults();
        printDataLookupResults();
        printDataDeletionByNameResults();
        printDataDeletionByExtensionResults();
        writer.close();

    }

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


    public void printDirectoryASCII(ArrayList<Entry> members) {
        System.out.println("+--------------------+--------------------+--------------------+");
        System.out.println("|       Surname      |       Initials     |      Extension     |");
        System.out.println("+--------------------+--------------------+--------------------+");

        for (Entry member : members) {
            System.out.println("|" + asciiPaddedData(member.getSurname()) + "|" + asciiPaddedData(member.getInitials()) + "|" +
                    asciiPaddedData(member.getExtension()) + "|");
        }
        System.out.println("+--------------------+--------------------+--------------------+");



    }

     public String asciiPaddedData(String test) {
        return String.format("%-20s", test);
    }




}

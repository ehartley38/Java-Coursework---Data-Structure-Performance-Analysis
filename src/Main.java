import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        Output out = new Output("AnalysisTests.txt");
       // ArrayDirectory ad = new ArrayDirectory("test_data.csv");
        ArrayListDirectory ald = new ArrayListDirectory("test_data.csv");

        out.printDirectoryASCII((ArrayList<Entry>) ald.toArrayList());


        /*
        String directoryType = null;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose you're directory type:\narray - 1\narrayList - 2\nhashMap - 3");
        String directoryChoice = scanner.nextLine();
        switch (directoryChoice) {
            case "1":
                directoryType = "array";
                break;
            case "2":
                directoryType = "arraylist";
                break;
            case "3":
                directoryType = "hashmap";
                break;
            default:
                System.exit(0);
        }

        Input input = new Input("test_data.csv", directoryType);*/



/*      TEST THE PERFORMANCE OF EACH TEST
        System.out.println(insertionTest.bestCase);
        System.out.println(insertionTest.worstCase);
        System.out.println(insertionTest.averageTime);

        System.out.println(lookupTest.bestCase);
        System.out.println(lookupTest.worstCase);
        System.out.println(lookupTest.averageTime);

        System.out.println(dataDeletionWithNameTest.bestCase);
        System.out.println(dataDeletionWithNameTest.worstCase);
        System.out.println(dataDeletionWithNameTest.averageTime);

        System.out.println(dataDeletionWithExtension.bestCase);
        System.out.println(dataDeletionWithExtension.worstCase);
        System.out.println(dataDeletionWithExtension.averageTime);*/


        /* TEST the ArrayDirectory Class
        ArrayDirectory ad = new ArrayDirectory();
        ad.insertEntry(new Entry("Hartley", "E.H", "12345"));
        System.out.println(Arrays.toString(ad.getMembers()));
        ad.deleteEntryUsingName("Amner");
        ad.deleteEntryUsingExtension("12345");
        System.out.println(Arrays.toString(ad.getMembers()));
        ad.updateExtensionUsingName("Westgarth", "99999");
        System.out.println(Arrays.toString(ad.getMembers()));
        System.out.println(ad.lookupExtension("Westgarth"));
        System.out.println(ad.toArrayList());*/

        /* TEST the ArrayListDirectory Class
        ArrayListDirectory ald = new ArrayListDirectory();
        System.out.println(ald.getMembers());
        ald.insertEntry(new Entry("Hartley", "E.H", "12345"));
        System.out.println(ald.getMembers());
        ald.deleteEntryUsingName("Hartley");
        System.out.println(ald.getMembers());
        ald.deleteEntryUsingExtension("54903");
        System.out.println(ald.getMembers());
        ald.updateExtensionUsingName("Westgarth", "99999");
        System.out.println(ald.getMembers());
        System.out.println(ald.lookupExtension("Westgarth"));*/
        /*
        HashMapDirectory hmd = new HashMapDirectory();
        hmd.insertEntry(new Entry("Hartley", "E.H", "12345"));
        hmd.insertEntry(new Entry("Drinkwater", "E.W", "11111"));
        hmd.insertEntry(new Entry("Garfield", "E.W", "99999"));
        System.out.println(hmd.getExtension());
        System.out.println(hmd.getInitials());
        hmd.deleteEntryUsingName("Hartley");
        System.out.println(hmd.getExtension());
        System.out.println(hmd.getInitials());
        hmd.deleteEntryUsingExtension("11111");
        System.out.println(hmd.getExtension());
        System.out.println(hmd.getInitials());
        hmd.updateExtensionUsingName("Garfield", "99991");
        System.out.println(hmd.getExtension());
        System.out.println(hmd.getInitials());
        System.out.println(hmd.lookupExtension("Garfield"));*/



    }


}

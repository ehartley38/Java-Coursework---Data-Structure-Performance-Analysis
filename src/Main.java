import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayDirectory ad = new ArrayDirectory();
        ad.insertEntry(new Entry("Hartley", "E.H", 12345));
        ad.insertEntry(new Entry("test", "E.H", 12345));
        System.out.println(Arrays.toString(ad.getMembers()));
        ad.deleteEntryUsingName("Westgarth");
        System.out.println(Arrays.toString(ad.getMembers()));
    }

}

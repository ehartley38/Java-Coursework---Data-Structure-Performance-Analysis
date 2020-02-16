import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Input input = new Input("test_data.csv", "array");









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

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class ArrayDirectory implements Directory {


    private static Object CSVReader;
    private Entry[] members;

    public ArrayDirectory(){
        
    }

    public static void main(String[] args) throws IOException {

        CSVReader cr = new CSVReader("test_data.csv");
        Entry[] members = new Entry[cr.getLines().size()];

        for (int i=0; i<cr.getLines().size(); i++){
            members[i] = new Entry(cr.getLines().get(i).get(0), cr.getLines().get(i).get(1),
                    Integer.parseInt(cr.getLines().get(i).get(2)));
        }

        System.out.println(Arrays.toString(members));

    }


    @Override
    public void insertEntry(Entry entry) {
        Entry[] tempMembers;
        tempMembers = Arrays.copyOf(members, members.length + 1);
        tempMembers[tempMembers.length-1] = entry;
        members = tempMembers;

    }

    @Override
    public void deleteEntryUsingName(String surname) {

    }

    @Override
    public void deleteEntryUsingExtension(String number) {

    }

    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {

    }

    @Override
    public String lookupExtension(String surname) {
        return null;
    }

    @Override
    public List<Entry> toArrayList() {
        return null;
    }


}

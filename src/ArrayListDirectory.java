import java.util.ArrayList;
import java.util.List;

public class ArrayListDirectory implements Directory {

    private ArrayList<Entry> members;

    public ArrayListDirectory(){
        members = new ArrayList<Entry>();
        CSVReader cr = new CSVReader("test_data.csv");

        for (int i=0; i<cr.getLines().size(); i++){
            members.add(new Entry(cr.getLines().get(i).get(0), cr.getLines().get(i).get(1),
                    cr.getLines().get(i).get(2)));
        }

    }

    @Override
    public void insertEntry(Entry entry) {
        

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

    public ArrayList<Entry> getMembers(){
        return members;
    }

}

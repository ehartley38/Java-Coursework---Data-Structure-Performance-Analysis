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
        members.add(entry);

    }

    @Override
    public void deleteEntryUsingName(String surname) {
        for (int i=0; i<members.size(); i++) {
            if (members.get(i).getSurname().equals(surname)) {
                members.remove(i);
                break;
            }
        }


    }

    @Override
    public void deleteEntryUsingExtension(String number) {
        for (int i=0; i<members.size(); i++){
            if (members.get(i).getExtension().equals(number)){
                members.remove(i);
                break;
            }
        }

    }

    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {
        for (int i=0; i<members.size(); i++) {
            if (members.get(i).getSurname().equals(surname)) {
                members.get(i).setExtension(newNumber);
            }
        }

    }

    @Override
    public String lookupExtension(String surname) {
        for (int i=0; i<members.size(); i++) {
            if (members.get(i).getSurname().equals(surname)) {
                return members.get(i).getExtension();
            }
        }
        return null;
    }

    @Override
    public List<Entry> toArrayList() {
        return members;
    }

    public ArrayList<Entry> getMembers(){
        return members;
    }

}

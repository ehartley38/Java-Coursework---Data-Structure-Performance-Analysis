import java.util.HashMap;
import java.util.List;

public class HashMapDirectory implements Directory{

    private HashMap<String, String> extension;
    private HashMap<String, String> initials;

    public HashMapDirectory() {
        CSVReader cr = new CSVReader("test_data.csv");
        extension = new HashMap<String, String>();
        initials = new HashMap<String, String>();

        for (int i=0; i<cr.getLines().size(); i++) {
            extension.put(cr.getLines().get(i).get(0), cr.getLines().get(i).get(1));
            initials.put(cr.getLines().get(i).get(0), cr.getLines().get(i).get(2));
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

    public HashMap<String, String> getExtension() {
        return extension;
    }

    public HashMap<String, String> getInitials() {
        return initials;
    }

    public void printHashMap(HashMap<String, String> hashmap) {
        for (String i : hashmap.keySet()) {
            System.out.println("Key: " + i + " Value: " + hashmap.get(i));
        }
    }
}

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapDirectory implements Directory{

    private HashMap<String, String> extension;
    private HashMap<String, String> initials;

    public HashMapDirectory(String csvFile) {
        CSVReader cr = new CSVReader(csvFile);
        //Create 2 new hashmaps, one for extension and one for initials. Both have surname as key
        extension = new HashMap<String, String>();
        initials = new HashMap<String, String>();

        //For every line in csv file, add extension and initials to relevant hash maps, with surname as key
        for (int i=0; i<cr.getLines().size(); i++) {
            extension.put(cr.getLines().get(i).get(0), cr.getLines().get(i).get(2));
            initials.put(cr.getLines().get(i).get(0), cr.getLines().get(i).get(1));
        }
    }

    //Insert Entry to hashmaps
    @Override
    public void insertEntry(Entry entry) {
        extension.put(entry.getSurname(), entry.getExtension());
        initials.put(entry.getSurname(), entry.getInitials());

    }

    //Delete entry using surname
    @Override
    public void deleteEntryUsingName(String surname) {
        extension.remove(surname);
        initials.remove(surname);
    }

    //Delete entry using extension
    @Override
    public void deleteEntryUsingExtension(String number) {
        String key = null;
        //For every key in extension
        for (String i : extension.keySet()) {
            //If the extension associated with the key equals the extension we want to delete
            if (extension.get(i).equals(number)) {
                //Then remove using that key
                key = i;
                break;
            }
        }
        extension.remove(key);
        initials.remove(key);
    }

    //Update extension using surname
    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {
        extension.put(surname, newNumber);

    }

    //Lookup extension using surname
    @Override
    public String lookupExtension(String surname) {
        return extension.get(surname);
    }

    //Convert hashmaps to array list
    @Override
    public List<Entry> toArrayList() {
        ArrayList<Entry> members = new ArrayList<>();
        //For every key, add new entry object to members using info provided by the key
        for (String i : extension.keySet()) {
            members.add(new Entry(i, initials.get(i), extension.get(i)));
        }
        return members;
    }

    //Get extension hash map
    public HashMap<String, String> getExtension() {
        return extension;
    }

    //Get initials hash map
    public HashMap<String, String> getInitials() {
        return initials;
    }

    //Output hashmaps to csv file
    public void outputToCSV() throws FileNotFoundException, UnsupportedEncodingException {
        //For every object in hashmaps, print surname, initials and extension, separated by commmas
        PrintWriter writer = new PrintWriter("test_data.csv", "UTF-8");

        for (int i=0; i<toArrayList().size(); i++) {
            writer.println(toArrayList().get(i).getSurname() + "," + toArrayList().get(i).getInitials() + "," +
                    toArrayList().get(i).getExtension());
        }
        writer.close();
    }
}

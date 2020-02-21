import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ArrayListDirectory implements Directory {

    private ArrayList<Entry> members;

    public ArrayListDirectory(String csvFile){
        //Create new array list members
        members = new ArrayList<Entry>();
        //Read data from csv file
        CSVReader cr = new CSVReader(csvFile);

        for (int i=0; i<cr.getLines().size(); i++){
            members.add(new Entry(cr.getLines().get(i).get(0), cr.getLines().get(i).get(1),
                    cr.getLines().get(i).get(2)));
        }

    }

    //Insert member into array list
    @Override
    public void insertEntry(Entry entry) {
        members.add(entry);

    }

    //Delete entry from array list using surname
    @Override
    public void deleteEntryUsingName(String surname) {
        for (int i=0; i<members.size(); i++) {
            if (members.get(i).getSurname().equals(surname)) {
                members.remove(i);
                break;
            }
        }


    }

    //Delete entry from array list using extension
    @Override
    public void deleteEntryUsingExtension(String number) {
        for (int i=0; i<members.size(); i++){
            if (members.get(i).getExtension().equals(number)){
                members.remove(i);
                break;
            }
        }

    }

    //Update the extension of a member using their surname
    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {
        for (int i=0; i<members.size(); i++) {
            if (members.get(i).getSurname().equals(surname)) {
                members.get(i).setExtension(newNumber);
            }
        }

    }

    //Lookup the extension of a member using their surname
    @Override
    public String lookupExtension(String surname) {
        for (int i=0; i<members.size(); i++) {
            if (members.get(i).getSurname().equals(surname)) {
                return members.get(i).getExtension();
            }
        }
        return null;
    }

    //Return members array list
    @Override
    public List<Entry> toArrayList() {
        return members;
    }

    //Get members array list
    public ArrayList<Entry> getMembers(){
        return members;
    }

    //Output array list to csv file
    public void outputToCSV() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("test_data.csv", "UTF-8");

        //For every object in array list, print surname, initials and extension, separated by commmas
        for (int i=0; i<toArrayList().size(); i++) {
            writer.println(toArrayList().get(i).getSurname() + "," + toArrayList().get(i).getInitials() + "," +
                    toArrayList().get(i).getExtension());
        }
        writer.close();
    }

}

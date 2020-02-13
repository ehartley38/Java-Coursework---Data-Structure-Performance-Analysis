import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class ArrayDirectory implements Directory {


    private static Object CSVReader;
    private Entry[] members;

    public ArrayDirectory(){
        CSVReader cr = new CSVReader("test_data.csv");
        members = new Entry[cr.getLines().size()];

        for (int i=0; i<cr.getLines().size(); i++){
            members[i] = new Entry(cr.getLines().get(i).get(0), cr.getLines().get(i).get(1),
                    Integer.parseInt(cr.getLines().get(i).get(2)));
        }

    }



    @Override
    public void insertEntry(Entry entry) {

        int size = members.length;
        Entry[] tempMembers = new Entry[size+1];

        for (int i=0; i<size; i++){
            tempMembers[i] = members[i];
        }

        tempMembers[size] = entry;
        members = tempMembers;
    }

    @Override
    public void deleteEntryUsingName(String surname) {

        for (int i=0; i<members.length; i++) {
            if (members[i].surname.equals(surname)){
                int size = members.length;
                List<Entry> membersList = new LinkedList<Entry>(Arrays.asList(members));
                membersList.remove(i);
                members = membersList.toArray(new Entry[size-1]);
                break;
            }
        }

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

    public Entry[] getMembers(){

        return members;
    }

}

//https://www.geeksforgeeks.org/how-to-add-an-element-to-an-array-in-java/
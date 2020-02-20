import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ArrayDirectory implements Directory {


    private static Object CSVReader;
    private Entry[] members;

    public ArrayDirectory(String csvFile){
        CSVReader cr = new CSVReader(csvFile);
        members = new Entry[cr.getLines().size()];

        for (int i=0; i<cr.getLines().size(); i++){
            members[i] = new Entry(cr.getLines().get(i).get(0), cr.getLines().get(i).get(1),
                    cr.getLines().get(i).get(2));
        }

    }


    @Override
    public void insertEntry(Entry entry) {

        int size = members.length;
        Entry[] tempMembers = new Entry[size+1];

        System.arraycopy(members, 0, tempMembers, 0, size);

        tempMembers[size] = entry;
        members = tempMembers;
    }

    @Override
    public void deleteEntryUsingName(String surname) {
        Entry[] tempMembers = new Entry[members.length-1];
        int count = 0;
            for (Entry member : members) {
                if (!member.getSurname().equals(surname)) {
                    tempMembers[count] = member;
                    count += 1;

                }
            }
            members = tempMembers;
        }




    @Override
    public void deleteEntryUsingExtension(String number) {

        Entry[] tempMembers = new Entry[members.length-1];
        int count = 0;
        for (Entry member : members) {
            if (!member.getExtension().equals(number)) {
                tempMembers[count] = member;
                count += 1;
            }
        }
        members = tempMembers;

    }

    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {
        for (Entry member : members) {
            if (member.getSurname().equals(surname)) {
                member.setExtension(newNumber);
            }
        }

    }

    @Override
    public String lookupExtension(String surname) {
        for (Entry member : members) {
            if (member.getSurname().equals(surname)) {
                return member.getExtension();
            }
        }

        return null;
    }

    @Override
    public List<Entry> toArrayList() {
        return new ArrayList<>(Arrays.asList(members));


    }

    public Entry[] getMembers(){

        return members;
    }

    public void setMembers(Entry[] memberList) {
        members = memberList;
    }



}

//https://www.geeksforgeeks.org/how-to-add-an-element-to-an-array-in-java/
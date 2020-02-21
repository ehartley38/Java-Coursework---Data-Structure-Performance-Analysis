import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ArrayDirectory implements Directory {


    private static Object CSVReader;
    private Entry[] members;

    public ArrayDirectory(String csvFile){
        //Read data from csv file
        CSVReader cr = new CSVReader(csvFile);
        //Then create members array at the same size as the number of lines
        members = new Entry[cr.getLines().size()];

        //For every line in csv, create a new Entry object containing the info in the line
        for (int i=0; i<cr.getLines().size(); i++){
            members[i] = new Entry(cr.getLines().get(i).get(0), cr.getLines().get(i).get(1),
                    cr.getLines().get(i).get(2));
        }

    }


    //Insert a new entry into the array
    @Override
    public void insertEntry(Entry entry) {

        int size = members.length;
        //Create a temp array of one more length than original
        Entry[] tempMembers = new Entry[size+1];
        //copy the original array over to the temp array
        System.arraycopy(members, 0, tempMembers, 0, size);
        //Set the object at the final index of the temp array to be the new entry
        tempMembers[size] = entry;
        //Set members to temp members
        members = tempMembers;
    }

    //Delete member using surname
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



    //Delete member using extension number
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

    //Update extension using surname
    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {
        for (Entry member : members) {
            if (member.getSurname().equals(surname)) {
                member.setExtension(newNumber);
            }
        }

    }

    //Lookup extension using surname
    @Override
    public String lookupExtension(String surname) {
        for (Entry member : members) {
            if (member.getSurname().equals(surname)) {
                return member.getExtension();
            }
        }

        return null;
    }

    //Convert array to array list
    @Override
    public List<Entry> toArrayList() {
        return new ArrayList<>(Arrays.asList(members));


    }

    //Get members array
    public Entry[] getMembers(){

        return members;
    }

    //Set members
    public void setMembers(Entry[] memberList) {
        members = memberList;
    }

    //Output array to csv file in output class
    public void outputToCSV() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("test_data.csv", "UTF-8");

        //For every object in array, print surname, initials and extension, separated by commmas
        for (int i=0; i<toArrayList().size(); i++) {
            writer.println(toArrayList().get(i).getSurname() + "," + toArrayList().get(i).getInitials() + "," +
                    toArrayList().get(i).getExtension());
        }
        writer.close();
    }



}

//https://www.geeksforgeeks.org/how-to-add-an-element-to-an-array-in-java/
import java.io.IOException;


public class ArrayDirectory implements Directory {


    private static Object CSVReader;
    private StaffMember[] members;

    public static void main(String[] args) throws IOException {

        CSVReader cr = new CSVReader("test_data.csv");
        StaffMember[] members = new StaffMember[cr.getLines().size()];

        for (int i=0; i<cr.getLines().size(); i++){
            members[i] = new StaffMember(cr.getLines().get(i).get(0), cr.getLines().get(i).get(1),
                    Integer.parseInt(cr.getLines().get(i).get(2)));
        }
        
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


}

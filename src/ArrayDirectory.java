import java.io.IOException;


public class ArrayDirectory implements Directory {


    private static Object CSVReader;

    public static void main(String[] args) throws IOException {
       CSVReader csvReader = new CSVReader();




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

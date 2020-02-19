import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Output {

    Test arrayInsertionTest, arrayLookupTest, arrayDeletionTestName, arrayDeletionTestExtension;
    Test listInsertionTest, listLookupTest, listDeletionTestName, listDeleTionTestExtension;
    Test hashInsertionTest, hashLookupTest, hashDeletionTestName, hashDeleTionTestExtension;

    public Output(String fileName) throws FileNotFoundException, UnsupportedEncodingException {

        PerformanceTesting pt = new PerformanceTesting();
        PrintWriter writer = new PrintWriter(fileName, "UTF-8");

        writer.println(pt.arrayTests.get(0).bestCase);
        writer.println(pt.arrayTests.get(0).averageTime);

        writer.close();



    }






}

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class PerformanceTesting {

    Test arrayInsertionTest, arrayLookupTest, arrayDeletionTestName, arrayDeletionTestExtension;
    Test listInsertionTest, listLookupTest, listDeletionTestName, listDeleTionTestExtension;
    Test hashInsertionTest, hashLookupTest, hashDeletionTestName, hashDeleTionTestExtension;

    ArrayList<Test> arrayTests = new ArrayList<Test>();
    ArrayList<Test> arrayListTests = new ArrayList<Test>();
    ArrayList<Test> hashMapTests = new ArrayList<Test>();



    public PerformanceTesting() throws FileNotFoundException {




        arrayInsertionTest = new Test("array","dataInsertion");
        arrayLookupTest = new Test("array", "datalookup");
        arrayDeletionTestName = new Test("array", "dataDeletionWithName");
        arrayDeletionTestExtension = new Test("array", "dataDeletionWithExtension");
        Collections.addAll(arrayTests, arrayInsertionTest, arrayLookupTest, arrayDeletionTestName, arrayDeletionTestExtension);

        //Initialise arrayList tests
        listInsertionTest = new Test("arraylist","dataInsertion");
        listLookupTest = new Test("arraylist", "datalookup");
        listDeletionTestName = new Test("arraylist", "dataDeletionWithName");
        listDeleTionTestExtension = new Test("arraylist", "dataDeletionWithExtension");
        Collections.addAll(arrayListTests,listInsertionTest, listLookupTest, listDeletionTestName, listDeleTionTestExtension);

        //Initialise hashMap tests
        hashInsertionTest = new Test("hashmap","dataInsertion");
        hashLookupTest = new Test("hashmap", "datalookup");
        hashDeletionTestName = new Test("hashmap", "dataDeletionWithName");
        hashDeleTionTestExtension = new Test("hashmap", "dataDeletionWithExtension");
        Collections.addAll(hashMapTests, hashInsertionTest, hashLookupTest, hashDeletionTestName, hashDeleTionTestExtension);


    }








}

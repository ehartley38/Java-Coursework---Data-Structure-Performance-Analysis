public class Test {

    private String directoryType, testType;
    private int testCycles = 10000;
    StopWatch stopwatch;
    long averageTime = 0, bestCase = 999999, worstCase = 0, totalTime = 0;

    public Test (String directoryType, String testType) {
        this.directoryType = directoryType;
        this.testType = testType;
        stopwatch = new StopWatch();

        checkTestType();
    }

    public void checkTestType() {
        switch (testType) {
            case "dataInsertion":
                dataInsertionTest(directoryType);
                break;
            case "dataLookup":

                break;
            case "dataDeletionWithName":

                break;
            case "dataDeletionWithExtension":

                break;
        }
    }

    public void getWorstCaseScenario(){



    }

    public void getAverageCaseScenario() {

    }

    public void getBestCaseScenario() {

    }

    public void dataInsertionTest(String directoryType) {

        switch (directoryType) {
            case "array":
                ArrayDirectory ad = new ArrayDirectory("test_data.csv");

                for (int i=0; i<=testCycles; i++) {
                    stopwatch.start();
                    ad.insertEntry(new Entry("Hartley", "E.H", "01234"));
                    stopwatch.stop();
                    updateTimes();
                }
                averageTime = totalTime / testCycles;


            case "arraylist":
                ArrayListDirectory ald = new ArrayListDirectory("test_data.csv");

                for (int i=0; i<=testCycles; i++) {
                    stopwatch.start();
                    ald.insertEntry(new Entry("Hartley", "E.H", "01234"));
                    stopwatch.stop();
                    updateTimes();
                }
                averageTime = totalTime / testCycles;

            case "hashmap":
                HashMapDirectory hmd = new HashMapDirectory("test_data.csv");

                for (int i=0; i<=testCycles; i++) {
                    stopwatch.start();
                    hmd.insertEntry(new Entry("Hartley", "E.H", "01234"));
                    stopwatch.stop();
                    updateTimes();
                }
                averageTime = totalTime / testCycles;
        }



    }



    public void dataLookupTest() {

    }

    public void dataDeletionWithNameTest() {

    }

    public void dataDeletionWithExtensionTest() {

    }



    public long getBestCase() {
        return bestCase;
    }



    public void updateTimes() {
        totalTime += stopwatch.getElapsedTime();
        if (stopwatch.getElapsedTime() < bestCase) {
            bestCase = stopwatch.getElapsedTime();
        }
        if (stopwatch.getElapsedTime() > worstCase) {
            worstCase = stopwatch.getElapsedTime();
        }
        stopwatch.reset();
    }
}

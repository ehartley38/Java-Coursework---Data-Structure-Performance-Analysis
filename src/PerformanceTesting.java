public class PerformanceTesting {

    ArrayDirectory ad;
    ArrayListDirectory ald;
    HashMapDirectory hmd;
    StopWatch stopwatch;
    private int testCycles = 10000;


    public PerformanceTesting(String directoryType) {
        ad = new ArrayDirectory("test_data.csv");
        ald = new ArrayListDirectory("test_data.csv");
        hmd = new HashMapDirectory("test_data.csv");
        stopwatch = new StopWatch();
        arrayTest();

    }


    public int arrayTest() {
        int totalTime = 0;
        for (int i=0; i<=testCycles; i++) {
            stopwatch.start();
            ad.insertEntry(new Entry("Hartley", "E.H", "01234"));
            stopwatch.stop();
            totalTime += stopwatch.getElapsedTime();
            stopwatch.reset();
        }
        return totalTime / testCycles;


    }

    public void arrayListTest() {

    }

    public void hashMapTest() {

    }

}

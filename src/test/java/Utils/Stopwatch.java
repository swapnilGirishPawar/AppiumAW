package Utils;


public class Stopwatch {
    private long startTime;
    private long stopTime;
    private boolean running;

    public void start() {
        if (!running) {
            startTime = System.currentTimeMillis();
            running = true;
            System.out.println("Stopwatch started.");
        } else {
            System.out.println("Stopwatch is already running.");
        }
    }

    public void stop() {
        if (running) {
            stopTime = System.currentTimeMillis();
            running = false;
            System.out.println("Stopwatch stopped.");
        } else {
            System.out.println("Stopwatch is not running.");
        }
    }

    public long getElapsedTime() {
        if (running) {
            return (System.currentTimeMillis() - startTime) / 1000; // Convert to seconds
        } else {
            return (stopTime - startTime) / 1000; // Convert to seconds
        }
    }

    public static void printElapsedTime(Stopwatch stopwatch){
        long elapsedTime = stopwatch.getElapsedTime();
        System.out.println("Elapsed Time: " + elapsedTime + " seconds");
    }

    public static void stopAndResetStopwatch(Stopwatch stopwatch){
        stopwatch.stop();
        printElapsedTime(stopwatch);
        stopwatch.reset();
    }

    public void reset() {
        startTime = 0;
        stopTime = 0;
        running = false;
        System.out.println("Stopwatch reset.");
    }



//    public static void main(String[] args) {
//        Stopwatch stopwatch = new Stopwatch();
//
//        // Start the stopwatch
//        stopwatch.start();
//
//        // Perform some task (e.g., sleep for 2 seconds)
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // Stop the stopwatch
//        stopwatch.stop();
//
//        // Get the elapsed time and display it
//        printElapsedTime(stopwatch);
//
//        // Reset the stopwatch
//        stopwatch.reset();
//    }
}


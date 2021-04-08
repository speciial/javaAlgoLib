package io.github.speciial.util;

public class TimeLogger {

    private final long startTime;

    public TimeLogger(String name) {
        System.out.println("Timing for " + name + ": ");
        this.startTime = System.currentTimeMillis();
    }

    public void stopTiming() {
        long currentTime = System.currentTimeMillis();
        long delta = currentTime - startTime;

        System.out.println("Time taken: " + delta + "ms");
    }

}

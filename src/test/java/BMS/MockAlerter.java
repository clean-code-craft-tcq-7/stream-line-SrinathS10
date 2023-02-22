package BMS;

public class MockAlerter {
    public static int invocationCount;

    public static void displayReadings(String readings) {
        invocationCount++;
    }
}

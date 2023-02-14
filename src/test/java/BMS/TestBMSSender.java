package BMS;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBMSSender {
    static BatteryProperty temperature;
    static BatteryProperty soc;

    @BeforeAll
    static void setup() {
        temperature = new Temperature();
        soc = new SOC();
    }

    @Test
    @DisplayName("Testing display format of temperature readings")
    void testTemperatureDisplayFormat() {
        String result = temperature.generatePropertyReadingsInCSVFormat();

        String[] lines = result.split("\n");
        assertEquals(50, lines.length);

        // checking first line
        assertTrue(lines[0].startsWith("TEMPERATURE,"));
        float readingValue = Float.parseFloat(lines[0].substring(lines[0].indexOf(",")+1));
        assertTrue(readingValue <= 45 && readingValue >= 0);
    }

    @Test
    @DisplayName("Testing display format of SOC readings")
    void testSOCDisplayFormat() {
        String result = soc.generatePropertyReadingsInCSVFormat();

        String[] lines = result.split("\n");
        assertEquals(50, lines.length);

        // checking first line
        assertTrue(lines[0].startsWith("SOC,"));
        float readingValue = Float.parseFloat(lines[0].substring(lines[0].indexOf(",")+1));
        assertTrue(readingValue <= 80 && readingValue >= 20);
    }

    @Test
    @DisplayName("Test BMS Sender for checking method call")
    void testBMSSenderInvocation() {
        BMSSender.showBatterySensorReadings(temperature, MockAlerter::displayReadings);
        BMSSender.showBatterySensorReadings(soc, MockAlerter::displayReadings);
        assertEquals(2, MockAlerter.invocationCount);
    }
}

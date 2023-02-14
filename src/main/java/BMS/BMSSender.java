package BMS;

public class BMSSender {
    static BatteryProperty temperature = new Temperature();
    static BatteryProperty soc = new SOC();

    public static void showBatterySensorReadings(BatteryProperty property, Alerter alerter) {
        alerter.displayReadings(property.generatePropertyReadingsInCSVFormat());
    }

    public static void printBatterySensorReadings() {
        showBatterySensorReadings(temperature, System.out::print);
        showBatterySensorReadings(soc,  System.out::print);
    }
}

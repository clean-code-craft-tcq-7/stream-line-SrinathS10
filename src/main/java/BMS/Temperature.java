package BMS;

public class Temperature extends BatteryProperty{
    public Temperature() {
        this.setPropertyName("TEMPERATURE");
        this.setMaxValue(45f);
        this.setMinValue(0f);
    }
}

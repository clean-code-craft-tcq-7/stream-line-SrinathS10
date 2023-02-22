package BMS;

public class SOC extends BatteryProperty{
    public SOC() {
        this.setPropertyName("SOC");
        this.setMaxValue(80f);
        this.setMinValue(20f);
    }
}

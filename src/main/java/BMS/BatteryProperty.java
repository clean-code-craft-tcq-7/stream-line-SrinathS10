package BMS;

public class BatteryProperty {
    String propertyName;
    float maxValue;
    float minValue;
    int readingCount = 50;

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public void setMaxValue(float maxValue) {
        this.maxValue = maxValue;
    }

    public void setMinValue(float minValue) {
        this.minValue = minValue;
    }

    public String generateSingleReadingValue() {
        return String.format("%.2f", (Math.random() * (maxValue-minValue) + minValue));
    }

    public String generatePropertyReadingsInCSVFormat() {
        StringBuilder readingsString = new StringBuilder();
        for (int reading = 0; reading<readingCount; reading++) {
            readingsString.append(propertyName).append(",").append(generateSingleReadingValue()).append("\n");
        }
        return readingsString.toString();
    }
}

package designPatterns.behavioral;

public class ForecastDisplay implements Observer {
    private float currentPressure = 1013.1f;
    private float lastPressure;

    public ForecastDisplay(Subject weatherStation) {
        weatherStation.registerObserver(this);
    }

    // Update the forecast when notified
    @Override
    public void update(float temperature, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;
        display();
    }

    // Display the weather forecast
    public void display() {
        System.out.print("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same.");
        } else if (currentPressure < lastPressure) {
            System.out.println("Watch out for cooler, rainy weather.");
        }
    }
}

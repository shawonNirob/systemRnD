package designPatterns.behavioral;

public class CurrentConditionsDisplay implements Observer {
    private float temperature;
    private float humidity;

    // Constructor
    public CurrentConditionsDisplay(Subject weatherStation) {
        weatherStation.registerObserver(this);
    }

    // Update the display when notified
    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    // Display the current conditions
    public void display() {
        System.out.println("Current conditions: " + temperature + "°C and "
                + humidity + "% humidity");
    }
}

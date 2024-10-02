package designPatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    // Attach an observer
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    // Detach an observer
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    // Notify all observers of state change
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    // Update the weather data and notify observers
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }
}

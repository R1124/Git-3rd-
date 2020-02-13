package _00_mohayemin.ridesharing;

public class SedanRide {
    private int numberOfPassengers;
    private int distanceInKm;
    private int timeInMinutes;

    SedanRide(int numberOfPassengers, int distanceInKm, int timeInMinutes) {
        this.numberOfPassengers = numberOfPassengers;
        this.distanceInKm = distanceInKm;
        this.timeInMinutes = timeInMinutes;
    }

    boolean canTakeTrip() {
        return numberOfPassengers <= 4 && distanceInKm <= 25;
    }

    int calculateFare() {
        return (50 + distanceInKm * 30 + timeInMinutes * 2);
    }

    String getRideRequestMessage(){
        return "== Comfortable Sedan Ride ==";
    }
}

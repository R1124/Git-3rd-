package _00_mohayemin.ridesharing;

public class SevenSeaterRide {
    private int numberOfPassengers;
    private int distanceInKm;

    SevenSeaterRide(int numberOfPassengers, int distanceInKm) {
        this.numberOfPassengers = numberOfPassengers;
        this.distanceInKm = distanceInKm;
    }

    boolean canTakeTrip() {
        return numberOfPassengers <= 7 && distanceInKm >= 10;
    }

    int calculateFare() {
        if (distanceInKm < 10)
            return 300;
        else
            return distanceInKm * 30;
    }

    String getRideRequestMessage(){
        return "== Ride with Friends and Family in Seven-Seater ==";
    }
}

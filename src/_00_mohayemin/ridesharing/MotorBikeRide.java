package _00_mohayemin.ridesharing;

public class MotorBikeRide {
    private int numberOfPassengers;
    private int distanceInKm;

    MotorBikeRide(int numberOfPassengers, int distanceInKm) {
        this.numberOfPassengers = numberOfPassengers;
        this.distanceInKm = distanceInKm;
    }

    boolean canTakeTrip(){
        return numberOfPassengers <= 1 && distanceInKm <= 10;
    }

    int calculateFare(){
        return Math.max(25, distanceInKm * 20);
    }

    String getRideRequestMessage(){
        return "== Ride Swift in Bike ==";
    }
}

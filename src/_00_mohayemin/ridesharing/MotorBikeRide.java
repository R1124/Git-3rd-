package _00_mohayemin.ridesharing;

public class MotorBikeRide implements Ride {
    private int numberOfPassengers;
    private int distanceInKm;

    MotorBikeRide(int numberOfPassengers, int distanceInKm) {
        this.numberOfPassengers = numberOfPassengers;
        this.distanceInKm = distanceInKm;
    }

    public boolean canTakeTrip(){
        return numberOfPassengers <= 1 && distanceInKm <= 10;
    }

    public int calculateFare(){
        return Math.max(25, distanceInKm * 20);
    }

    public String getRideRequestMessage(){
        return "== Ride Swift in Bike ==";
    }
}


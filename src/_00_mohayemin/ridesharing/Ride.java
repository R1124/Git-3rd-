package _00_mohayemin.ridesharing;

public interface Ride{
    boolean canTakeTrip();
    int calculateFare();
    String getRideRequestMessage();
}

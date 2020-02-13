package _00_mohayemin.ridesharing;

public class Trip {
    private String rideType;
    private int distanceInKm;
    private int timeInMinutes;
    private int numberOfPassengers;
    Ride ride;

    public Trip(String rideType,
                int distanceInKm,
                int timeInMinutes,
                int numberOfPassengers) {
        this.rideType = rideType;
        this.distanceInKm = distanceInKm;
        this.timeInMinutes = timeInMinutes;
        this.numberOfPassengers = numberOfPassengers;
        ride = getRide();
    }

    public void requestTrip() {
        System.out.println(ride.getRideRequestMessage());

        if (canTakeTrip()) {
            System.out.println(distanceInKm + " KM");
            System.out.println(timeInMinutes + " Minutes");
            System.out.println(perHeadFare() + " Taka Per Person");
        } else {
            System.out.println("Invalid Trip Request");
        }
    }

    public int perHeadFare() {
        int fare = ride.calculateFare();
        fare /= numberOfPassengers;
        return fare - (fare % 5);
    }

    public boolean canTakeTrip() {
        if (numberOfPassengers < 1)
            return false;

        return ride.canTakeTrip();
    }

    private Ride getRide() {
        Ride ride;
        if (rideType == "MOTOR_BIKE") {
            ride = new MotorBikeRide(numberOfPassengers, distanceInKm);
        } else if (rideType == "SEVEN_SEATER") {
            ride = new SevenSeaterRide(numberOfPassengers, distanceInKm);
        } else {
            ride = new SedanRide(numberOfPassengers, distanceInKm, timeInMinutes);
        }
        return ride;
    }
}


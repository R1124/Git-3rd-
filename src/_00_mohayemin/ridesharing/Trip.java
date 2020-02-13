package _00_mohayemin.ridesharing;

public class Trip {
    private String rideType;
    private int distanceInKm;
    private int timeInMinutes;
    private int numberOfPassengers;

    public Trip(String rideType,
                int distanceInKm,
                int timeInMinutes,
                int numberOfPassengers) {
        this.rideType = rideType;
        this.distanceInKm = distanceInKm;
        this.timeInMinutes = timeInMinutes;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void requestTrip() {
        Ride ride;
        if (rideType == "MOTOR_BIKE") {
            ride = new MotorBikeRide(numberOfPassengers, distanceInKm);
        } else if (rideType == "SEVEN_SEATER") {
            ride = new SevenSeaterRide(numberOfPassengers, distanceInKm);
        } else {
            ride = new SedanRide(numberOfPassengers, distanceInKm, timeInMinutes);
        }

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
        int fare = -1;
        switch (rideType) {
            case "SEDAN":
                fare = new SedanRide(numberOfPassengers, distanceInKm, timeInMinutes).calculateFare();
                break;
            case "MOTOR_BIKE":
                fare = new MotorBikeRide(numberOfPassengers, distanceInKm).calculateFare();
                break;
            default:
                fare = new SevenSeaterRide(numberOfPassengers, distanceInKm).calculateFare();
                break;
        }

        fare /= numberOfPassengers;
        return fare - (fare % 5);
    }

    public boolean canTakeTrip() {
        if (numberOfPassengers < 1)
            return false;

        switch (rideType) {
            case "SEDAN":
                return new SedanRide(numberOfPassengers, distanceInKm, timeInMinutes).canTakeTrip();
            case "SEVEN_SEATER":
                return new SevenSeaterRide(numberOfPassengers, distanceInKm).canTakeTrip();
            default:
                return new MotorBikeRide(numberOfPassengers, distanceInKm).canTakeTrip();
        }
    }
}


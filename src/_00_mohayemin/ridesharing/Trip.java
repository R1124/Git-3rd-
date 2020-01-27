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
        if (rideType == "MOTOR_BIKE") {
            System.out.println(new MotorBikeRide(numberOfPassengers, distanceInKm).getRideRequestMessage());
        } else if (rideType == "SEVEN_SEATER") {
            System.out.println(new SevenSeaterRide(numberOfPassengers, distanceInKm).getRideRequestMessage());
        } else {
            System.out.println(new SedanRide(numberOfPassengers, distanceInKm, timeInMinutes).getRideRequestMessage());
        }

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

class SedanRide {
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

class SevenSeaterRide {
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

class MotorBikeRide {
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
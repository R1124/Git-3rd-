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
            System.out.println("== Ride Swift in Bike ==");
        } else if (rideType == "SEVEN_SEATER") {
            System.out.println("== Ride with Friends and Family in Seven-Seater ==");
        } else {
            System.out.println("== Comfortable Sedan Ride ==");
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
                fare = (50 + distanceInKm * 30 + timeInMinutes * 2) / numberOfPassengers;
                break;
            case "MOTOR_BIKE":
                fare = Math.max(25, distanceInKm * 20) / numberOfPassengers;
                break;
            default:
                if (distanceInKm < 10)
                    fare = 300 / numberOfPassengers;
                else
                    fare = (distanceInKm * 30) / numberOfPassengers;

                break;
        }

        return fare - (fare % 5);
    }

    public boolean canTakeTrip() {
        if (numberOfPassengers < 1)
            return false;

        switch (rideType) {
            case "SEDAN":
                return numberOfPassengers <= 4 && distanceInKm <= 25;
            case "SEVEN_SEATER":
                return numberOfPassengers <= 7 && distanceInKm >= 10;
            default:
                return numberOfPassengers <= 1 && distanceInKm <= 10;
        }
    }
}


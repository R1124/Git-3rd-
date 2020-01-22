package _00_mohayemin.ridesharing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TripTest {
    @Test
    public void Sedan() {
        double actual = new Trip("SEDAN", 10, 10, 3).perHeadFare();
        Assertions.assertEquals(120, actual);
    }

    @Test
    public void MotorBike_LessThan25() {
        double actual = new Trip("MOTOR_BIKE", 1, 2, 1).perHeadFare();
        Assertions.assertEquals(25, actual);
    }

    @Test
    public void MotorBike_MoreThan25() {
        double actual = new Trip("MOTOR_BIKE", 5, 15, 1).perHeadFare();
        Assertions.assertEquals(100, actual);
    }


    @Test
    public void SevenSeater_LessThan10KM() {
        double actual = new Trip("SEVEN_SEATER", 1, 2, 7).perHeadFare();
        Assertions.assertEquals(40, actual);
    }

    @Test
    public void SevenSeater_MoreThan2KM() {
        double actual = new Trip("SEVEN_SEATER", 100, 200, 6).perHeadFare();
        Assertions.assertEquals(500, actual);
    }
}

# Theory class 5

- **Class Date: 23 January 2020**  

## Shameless Green
Most of you produced the shameless green solution in the lab. Some of you thought shameless green was not good and they wrote some more efficient code. The efficiency is in terms of being non-duplicate, however, it caused a terrible loss in terms of readability. 

Although most of you produced shameless green, some had tiny issues. We identified the following issues - 

1. Some had 5 verse variants, one being `null`.
2. The default case should be 3+, but some had default case 0 or 2.
3. Order of the cases should be 0, 1, 2, others. This makes the differences in the strings gradual. This is a bit _good-for-eye_, _giving-mental-satisfaction_, etc.

## Voluntary assignment
For those who want to learn more can consider this assignment. Use “1 dozen” in place of “12”.  
What test cases should be added to this? Notice that two test cases must be added - one for 12 and another for 13.  
You may show the assignment outside class hours.

## OO Design Principles
Principles about anything is important because

1. Principles keep everyone/everything in order
2. Principles are well established and proven
3. Following the principles gives consistency

The OO principles have the following properties - 

1. Principles usually support each other
2. Understanding of one principle usually helps to understand another one
3. Principles also play well with design patterns. Design patterns are something we will learn in-depth in a separate course in the 5th Semester.

Among many design principles, 5 are given very high priority. These principles are together called the SOLID [^1] principles. These 5 are - 

* S - Single Responsibility Principle (SRP)
* O - Open/Closed Principle (OCP)
* L - Liskov Substitution Principle (LSP)
* I - Interface Segregation Principle (ISP)
* D - Dependency Inversion Principle (DIP)

## Open/Closed Principle
**Further Reading:** 

1. The OCP chapter in PPP book
2. Robert Martin’s 1996 article titled “The Open-Closed Principle”.

**Code Example**
```java
public class Trip {
    private String rideType;
    private int dist;
    private int minutes;
    private int noPass;

    public Trip(String rideType,
                int dist,
                int minutes,
                int noPass) {
        this.rideType = rideType;
        this.dist = dist;
        this.minutes = minutes;
        this.noPass = noPass;
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
            System.out.println(dist + " KM");
            System.out.println(minutes + " Minutes");
            System.out.println(perHeadFare() + " Taka Per Person");
        } else {
            System.out.println("Invalid Trip Request");
        }
    }

    public int perHeadFare() {
        int fare = -1;
        switch (rideType) {
            case "SEDAN":
                fare = (50 + dist * 30 + minutes * 2) / noPass;
                break;
            case "MOTOR_BIKE":
                fare = Math.max(25, dist * 20) / noPass;
                break;
            default:
                if (dist < 10)
                    fare = 300 / noPass;
                else
                    fare = (dist * 30) / noPass;

                break;
        }

        return fare - (fare % 5);
    }

    public boolean canTakeTrip() {
        if (noPass < 1)
            return false;

        switch (rideType) {
            case "SEDAN":
                return noPass <= 4 && dist <= 25;
            case "SEVEN_SEATER":
                return noPass <= 7 && dist >= 10;
            default:
                return noPass <= 1 && dist <= 10;
        }
    }
}
```

The code can also be found here:

* [Production Code](https://bitbucket.org/iut-dhaka/ooc-ii-swe-18/raw/e27f8c32412c39c633413c278f1ecb41635f8420/src/_00_mohayemin/ridesharing/Trip.java)
* [Test Code](https://bitbucket.org/iut-dhaka/ooc-ii-swe-18/raw/e27f8c32412c39c633413c278f1ecb41635f8420/src/_00_mohayemin/ridesharing/TripTest.java)

Answer the following questions about the Trip Class - 

1. Is there anything wrong with the code? Answers could be -  
    1. Some instance variable names (`dist`, `minutes` etc) are unclear.
    2. Some constants do not have names.
    3. In PerHeadFare method, dividing by the number of passengers has been done several times. It could be done just once at the end.
    4. It's not clear what has been done by subtracting `fare%5` from the fare.
    5. The conditional statements (switch/if) are structurally duplicate.
    6. The default condition the conditionals are different in different methods.
2. How likely is that more switch cases of a similar structure already exists (in other parts of the code that is not shown here) or may come later? - Trust me, it's many maybe hundreds.
3. What changes must be done if we want to drop support for a type of vehicle? - Well, update all switches.
4. What changes must be done if we want to add support for a new type of vehicle? - Same, update all switches.

**Introducing OCP**
> _“Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification”_ - Bertrand Meyer (1988) in _Object-Oriented Software Construction_ [^2]

---
[^1]: The SOLID principles are promoted by Uncle Bob, however, the acronym was introduced later by Michael Feathers.  
[^2]: Bertrand Meyer is generally credited for having originated the term open/closed principle.
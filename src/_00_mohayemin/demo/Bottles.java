package _00_mohayemin.demo;

public class Bottles {
    String verse(int n) {
        String verse = "";
        if (n == 0)
            verse += "No more";
        else
            verse += n;

        verse += " bottle";
        if (n != 1)
            verse += "s";

        verse += " of milk on the wall, ";

        if (n == 0)
            verse += "no more";
        else
            verse += n;

        verse += " bottle";
        if (n != 1)
            verse += "s";

        verse += " of milk.\n";

        if (n > 0) {
            verse += "Take ";
            if (n > 1)
                verse += "one ";
            else
                verse += "it ";

            verse += "down and pass it around, ";
        } else {
            verse += "Go to the store and buy some more, ";
        }

        if (n - 1 < 0) {
            verse += 99;
        } else {
            if (n - 1 == 0)
                verse += "no more";
            else
                verse += (n - 1);
        }

        verse += " bottle";

        if (n - 1 != 1)
            verse += "s";

        verse += " of milk on the wall.";

        return verse;
    }
}

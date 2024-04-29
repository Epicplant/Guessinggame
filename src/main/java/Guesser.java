import java.math.BigInteger;

public class Guesser {
    /**
     * This method must return the number Chooser c has chosen. c can guess() any
     * number and tell you whether the number is "correct", "higher", or "lower".
     *
     * @param c The "chooser" that has chosen a number you must guess.
     * @return The number that the "chooser" has chosen
     */
    public static BigInteger findNumber(Chooser c) {
        // Tip: If you're not sure how to work with BigInteger numbers, we encourage
        // you to look up its Javadoc online.


        BigInteger higherBound= new BigInteger("10");
        String test = c.guess(higherBound);

        while (test == "higher") {
            higherBound = higherBound.multiply(new BigInteger("10"));
            test = c.guess(higherBound);
        }

        BigInteger lowerBound = new BigInteger("0");
        // while low and high haven't met yet, there are still more indices to search
        while (lowerBound.compareTo(higherBound) != 0) {
            // compute middle index and value

            BigInteger mid = (lowerBound.add(higherBound.subtract(lowerBound).divide(new BigInteger("2"))));

            if (c.guess(mid) == "higher") {
                lowerBound = mid.add(new BigInteger("1"));
            } else if (c.guess(new BigInteger("" + mid)) == "lower") {
                higherBound = mid.subtract(new BigInteger("1"));
            } else {
                return mid;
            }
        }

        return higherBound;
    }

}
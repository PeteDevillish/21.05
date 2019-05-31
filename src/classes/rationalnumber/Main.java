package classes.rationalnumber;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        RationalNumber half = new RationalNumber(1, 2);
        System.out.println(half.toString());
        System.out.println(half);
//       6
        System.out.println(RationalNumber.greatestCommonDivisor(38, 28));
        System.out.println(RationalNumber.greatestCommonDivisor(19, 17));
//       7
        System.out.println(new RationalNumber(10, 5).reduce());
//       8
        System.out.println(half.add(new RationalNumber(3,4)));
//        9
        System.out.println(half.compareTo(0));
        System.out.println(half.compareTo(1));
        System.out.println(new RationalNumber(1, 1).compareTo(1));
//        10
        System.out.println(Arrays.toString(RationalNumber.decomposeToPrimeFactors(12)));
        System.out.println(Arrays.toString(RationalNumber.decomposeToPrimeFactors(17)));
    }
}

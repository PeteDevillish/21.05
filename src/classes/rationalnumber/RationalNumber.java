package classes.rationalnumber;

public class RationalNumber {
    private int numerator, denominator;

    public RationalNumber(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public String toString() {
        return numerator + "/" +
                denominator;
    }

    public RationalNumber getOpposite() {
        return new RationalNumber(-numerator, denominator);
    }

    public RationalNumber getInverse() {
        return new RationalNumber(denominator, numerator);
    }

    public RationalNumber multiply(RationalNumber param) {
        return new RationalNumber(param.numerator * numerator, param.denominator * denominator);
    }

    public RationalNumber divide(RationalNumber param) {
        return new RationalNumber(numerator * param.denominator, denominator * param.numerator);
    }

    public RationalNumber add(int input) {
        return new RationalNumber(numerator + input * denominator, denominator);
    }

    //   6
    public static int greatestCommonDivisor(int input1, int input2) {

        int rest = input1 % input2;
        if (rest == 0) {
            return input2;
        }
        while (rest != 0) {
            int result = 1;
            rest = input1 % input2;
            input1 = input2;
            input2 = rest;
        }
        return input1;
    }

    //7. Napisz metodę reduce, która zwróci skrócony ułamek korzystając z metody z zadania 6.
    public RationalNumber reduce() {
        int divider = greatestCommonDivisor(numerator, denominator);
        return new RationalNumber(numerator / divider, denominator / divider);
    }
//8. Napisz metodę add, która przyjmie za parametr liczbę wymierną.

    public RationalNumber add(RationalNumber input) {
        RationalNumber result = new RationalNumber(input.numerator * denominator + input.denominator * numerator, denominator * input.denominator);
        return result.reduce();
    }

    //9. Napisz metodę compareTo, która zwróci wartość typu int, a które przyjmie jako argument liczbę wymierną.
// Metoda zwróci 1, gdy obiekt, na którym wywołano metodę reprezentuje liczbę większą od argumentu, 0 gdy wartości są równe oraz -1, gdzy argument jest większy.
    public int compareTo(int input) {
        if (numerator > input * denominator) return 1;
        else if (numerator == input * denominator) return 0;
        else return -1;
    }

    //10. Napisz metodę statyczną decomposeToPrimeFactors, która przyjmie jako parametr wartość typu int,
// a która zwróci tablicę czynników pierwszych argumentu (łącznie z 1, dla wartości większych od zera, łącznie z -1 dla wartości od zera mniejszych).
    public static int[] decomposeToPrimeFactors(int input) {
        int[] primeFactors = new int[1];
        if (input >= 0) {
            primeFactors[0] = 1;
        } else {
            primeFactors[0] = -1;
            input = -input;
        }
        int inputSqrt = (int)Math.sqrt(input);
        for (int i = 2; i <= inputSqrt; i++) {
            if (input % i == 0){
                primeFactors = add(primeFactors, i);
                input /= i;
                i--;
            }
        }
        if (input != 1){
            primeFactors = add(primeFactors, input);
        }

        return primeFactors;
    }

    public static int[] add(int[] input, int el){
        int[] box = new int [input.length + 1];
        for (int j = 0; j < input.length; j++) {
            box[j] = input[j];
        }
        box[input.length] = el;
        return box;
    }
}

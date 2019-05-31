package lock;

import classes.rationalnumber.RationalNumber;

import java.util.Random;
import java.util.Scanner;

//10. Stwórz typ Lock, reprezentujący zamek na kod (z trzema przekładniami - np. zamek do walizki/roweru).
// Będziemy mogli tworzyć obiekt typu Lock przekazując jako parametr konstruktora trzy cyfry - kod otwierający zamek.
// Domyślnie obiekt będzie tworzony z prawidłowym ustawieniem przekładni.
// Obiekt typu Lock będzie oferował trzy metody zmieniający ustawienie każdej z przekładni o jedną pozycję w prawo.
// Będzie również oferował metodę sprawdzającą, czy zamek jest otwarty, czy nie, oraz metodę wypisującą na ekranie aktualnie ustawioną kombinację zamka.
// Dodatkowo będzie miał zdefiniowaną metodę shuffle - "mieszającą" aktualnie ustawiony kod.
//11. Zmodyfikuj klasę Lock tak, aby liczba przekładni mogła być dowolna.
//12. Zapytajmy użytkownika liczbę przekładni zamka oraz o kombinację otwierającą zamek.
// Następnie, dopóki utworzony zamek będzie zamknięty, pytamy użytkownika o to, którą przekładnię przełożyć.
public class Lock {
    private Gear[] gears;

    public Lock() {
        Scanner sc = new Scanner(System.in);
        gears = new Gear[sc.nextInt()];
        for (int i = 0; i < gears.length; i++) {
            System.out.println("Podaj cyfrę do przekładni nr: " + (i+1));
            gears[i] = new Gear(sc.nextInt());
        }
    }

    public Lock(int gear1, int gear2, int gear3) {
        gears[0] = new Gear(gear1 % 10);
        gears[1] = new Gear(gear2 % 10);
        gears[2] = new Gear(gear3 % 10);
    }

    public Boolean isOpen() {
        for (Gear g : gears) {
            if (!g.isOpenPosition()) return false;
        }
        return true;
    }

    private void changePositionOfGear(Gear gear, int rotation) {
        gear.setActualPosition(rotation);
    }

    public void actualPosition() {
        for (Gear g : gears){
            System.out.print(g.getActualPosition() + " | ");
        }
        System.out.println();
    }

    public void shuffle(){
        for (Gear g : gears){
            g.setActualPosition(new Random().nextInt(10));
        }
    }

    public void tryToOpen(){
        int counter = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Podaj kolejne cyfry kombinacji, pamietaj o spacji");
            for (int i = 0; i < gears.length; i++) {
                gears[i].setActualPosition(sc.nextInt());
            }
            if (isOpen()) System.out.println("Gratulacje, otworzyłeś zamek");
            else System.out.println("Spróbuj jeszcze raz");
            counter++;
        }while (isOpen());

    }
}

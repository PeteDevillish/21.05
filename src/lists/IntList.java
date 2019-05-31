package lists;

import java.util.Arrays;

public class IntList {
    private int[] elements;

    public IntList() {
        elements = new int[0];
    }

    //    Jeszcze raz
//4. Zmodyfikuj konstruktor przyjmujący za parametr tablicę intów w taki sposób, aby polu elements była przypisana kopia parametru.
    public IntList(int[] elements) {
        int[] box = elements;
        this.elements = box;
    }

    public int[] getElements() {
        return elements;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < elements.length; i++) {
            result += elements[i];
            if (i != elements.length - 1) {
                result += ", ";
            }
        }
        return result += "]";
    }
    public int get(int index){
        return elements[index];
    }
    //1. Dodaj do klasy IntList metodę add, która posłuży do dodawania elementu.
    public void add(int elToAdd) {
        int[] biggerArray = new int[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            biggerArray[i] = elements[i];
        }
        biggerArray[elements.length] = elToAdd;
        elements = biggerArray;
    }

    //2. Dodaj do klasy IntList metodę remove, która posłuży do usuwania elementu dla zadanego indeksu.
    public void remove(int index) {
        int[] result = new int[elements.length - 1];
        int j = 0;
        for (int i = 0; i < elements.length - 1; i++) {
            if (index == i) j++;
            result[i] = elements[i + j];
        }

        elements = result;
    }

    //3. Dodaj do klasy metodę removeByValue, która przyjmie za parametr wartość elementu, a która usunie wszystkie wystąpienia zadanej wartości z listy.
    public void removeByValue(int value) {
        int len = elements.length;
        for (int el : elements) {
            if (el == value) len--;
        }
        int[] result = new int[len];
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (elements[i + j] == value) j++;
            result[i] = elements[i + j];
        }

        elements = result;
    }


    //5. Dodaj do klasy metodę copy, która zwróci kopię listy.
    public IntList copy() {
        return new IntList(elements);
    }

    //6. Dodaj metodę insertAt, która przyjmie za parametry wartość elementu oraz indeks. Metoda ma wstawić element na wskazane miejsce (nie usuwając istniejących wartości).
    public void insertAt(int element, int index) {
        if (index == elements.length) {
            add(element);
        } else {
            int[] newElementsArray = new int[elements.length + 1];
            newElementsArray[index] = element;
            int j = 0;
            for (int i = 0; i < elements.length; i++) {
                if (i == index) j++;
                newElementsArray[i + j] = elements[i];
            }
            elements = newElementsArray;
        }

    }

    //7. Dodaj metodę addAll, która przyjmie za parametr obiekt typu IntList, a która doda wszystkie elementy przekazanej listy.
    public static int addAll(IntList list) {
        int counter = 0;
        for (int el : list.elements) {
            counter += el;
        }
        return counter;
    }

    //8. Dodaj metodę contains, która zwróci odpowiedź na pytanie, czy lista zawiera przekazany argument.
    public boolean contains(int arg) {
        for (int el : elements) {
            if (el == arg) {
                return true;
            }
        }
        return false;
    }

    //9. Dodaj metodę intersect, która przyjmie jako argument listę intów, a która zwróci listę intów
// - część wspólną obu list(tej, której metodę wywołano, oraz tej, którą przekazano jako argument).
    public IntList intersect(IntList list) {
        IntList box = new IntList();
        IntList copy = copy();
        int len1 = copy.elements.length;
        int len2 = list.elements.length;
        for (int i = 0; i < len1; i++) {
            for (int i1 = 0; i1 < len2; i1++) {
                if (copy.elements[i] == list.elements[i1]) {
                    box.add(copy.elements[i]);
                    copy.remove(i);
                    list.remove(i1);
                    len1--;
                    len2--;
                    i--;
                    i1--;
                    break;
                }
            }
        }
        return box;
    }


    //10. Dodaj metodę distinct, która zwróci listę zawierającą wszystkie elementy tej listy, której metodę wywołano, bez powtórzeń.
    public IntList distinct() {
        int len = elements.length;
        IntList distinctList = copy();
//        IntList copy = copy();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (distinctList.elements[i] == distinctList.elements[j]) {
                    distinctList.remove(j);
                    len--;
                    j--;
                }
            }
        }
        return distinctList;
    }

}

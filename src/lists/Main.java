package lists;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        IntList list = new IntList();
        IntList list2 = new IntList(new int[]{3, 7, 5, 10, 18});
        System.out.println(list);
        System.out.println(list2);
//        1
        System.out.println("Ex. no 1.");
        list.add(-3);
        System.out.println(list);
//        2
        System.out.println("Ex. no 2.");
        list2.remove(1);
        System.out.println(list2);
//        3
        System.out.println("Ex. no 3.");
        list2.removeByValue(10);
        System.out.println(list2);
//        5
        System.out.println("Ex. no 5.");
        IntList copy = list2.copy();
        copy.remove(2);
        System.out.println(copy);
        System.out.println(list2);
//        6
        System.out.println("Ex. no 6.");
        list2.insertAt(3, 3);
        System.out.println(list2);
//        7
        System.out.println("Ex. no 7.");
        System.out.println(IntList.addAll(list2));
//        8
        System.out.println("Ex. no 8.");
        System.out.println(list2.contains(3));
        System.out.println(list2.contains(-10));
//        9
        System.out.println("Ex. no 9.");
        System.out.println(list2);
        System.out.println(copy);
        System.out.println(list2.intersect(copy));
//        10
        System.out.println("Ex. no 10.");
        System.out.println(list2.distinct());
    }
}

package Eksamen;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Oppgave1 {

    /**
     *    Oppgave 1. Finn ut hva som blir printet
     *
     *    Svar: 1, 5, 5
     *
     *    x = 1 fordi at foo(int a) bare endrer på den lokale variabelen a. Når vi sender inn en primitiv type til en metode,
     *    sender vi bare inn en kopi av verdien, ikke en peker. Derfor skjer endringen kun lokalt.
     *
     *    I metodene bar() og baz() sender vi derimot inn pekere til objekter. Både arrays[] og ArrayLists er objekter. Når vi
     *    sender inn pekere, er det samme objekt vi jobber med inni metoden. Derfor blir y[0] = 5 og z.get(0) = 5
     *
     */

    public static void main(String[] args){
        int x = 1;
        int[] y = {1,2,3};
        List<Integer> z = new ArrayList<Integer>(Arrays.asList(1,2,3));
        foo(x);
        bar(y);
        baz(z);

        System.out.printf("%d, %d, %d\n", x, y[0], z.get(0));
    }


    private static void foo(int a) {
        a = 5;
    }

    private static void bar(int[] a) {
        a[0] = 5;
    }


    private static void baz(List<Integer> z) {
        z.set(0, 5);
    }



}

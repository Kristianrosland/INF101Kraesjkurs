import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Oppgave1 {

    public static void main(String[] args){
        int x = 1;
        int[] y = {1,2,3};
        List<Integer> z = new ArrayList<Integer>(Arrays.asList(1,2,3));
        foo(x);
        bar(y);
        baz(z);
        System.out.printf("%d, %d, %d\n", x, y[0], z.get(0));
        //baz(new ArrayList<Integer>(z));
        //System.out.printf("%d, %d, %d\n", x, y[0], z.get(0));

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

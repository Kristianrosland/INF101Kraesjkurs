package Eksamen;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Oppgave3BogC {

    public void addGetProperty(IVector vec1, IVector vec2, int index) {
        double a = vec1.get(index);
        double b = vec2.get(index);

        assertEquals(a+b, vec1.add(vec2).get(index), 0.0001);
    }

    /**
     *   Immutable betyr at innholdet i objektet ikke skal kunne endres etter opprettelse.
     *   Grunnen til at Vector ikke er immutable er at vi kan gjøre som i eksempelet under.
     */
    @Test
    public void testIfVectorIsImmutable() {
        double [] array = {1.0, 2.0, 3.0};

        IVector v = new Vector(array);

        // Nå skal det ikke være mulig å endre på arrayen i vector,
        // men siden vi har en referanse til den kan vi gjøre det.
        array[0] = 5.0;

        assertEquals(1.0, v.get(0), 0.001);


        // Løsningen på problemet er å heller lagre en kopi av arrayen som kommer inn i konstruktøren i Vector.
        // Se Vector.java
    }

}

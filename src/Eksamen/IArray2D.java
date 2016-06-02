package Eksamen;
/**
 * Grensesnitt for en 2D-tabell
 */
public interface IArray2D<E> {

    /**
     * @param pos En posisjon
     * @return Elementet på pos, eller null
     */
    E getPosition(Position pos);

    /**
     *  Sette inn et element
     * @param pos Posisjon
     * @param e Element
     */
    void setPosition(Position pos, E e);

    /**
     * @param pos Posisjon
     * @return true hvis posisjonen er gyldig
     */
    boolean isValid(Position pos);

    /**
     * @return Kopi av tabellen
     */
    IArray2D<E> copy();

    int getHeight();
    int getWidth();
}

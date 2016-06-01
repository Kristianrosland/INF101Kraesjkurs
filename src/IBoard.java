/**
 * Brett til ordspillet
 */
public interface IBoard {

    /**
     * @return Bredden til brettet
     */
    int getWidth();

    /**
     * @return Høyden til brettet
     */
    int getHeight();

    /**
     * @param pos Posisjonen til en av bokstavene i ordet
     * @param dir Retningen til ordet
     * @return Ordet i retning dir og som har en bokstav i posisjonen pos
     */
    String getWord(Position pos, Direction dir);

    /**
     * @param pos Startposisjon for bokstavene som skal legges inn
     * @param dir Retningen
     * @param letters Bokstavene som skal legges til, med '.' i eventuelle plasseringer som allerede er fylt på brettet
     */
    void putWord(Position pos, Direction dir, String letters);
}

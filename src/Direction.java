/**
 * Retning, horisontal eller vertikal
 */
public enum Direction {
    HORIZONTAL,
    VERTICAL;

    /**
     * @return Motsatt retning
     */
    public Direction rotate() {
        if (this == HORIZONTAL) return VERTICAL;
        else return HORIZONTAL;
    }

}

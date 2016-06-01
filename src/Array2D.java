/**
 * Generisk 2D-tabell
 */
public class Array2D<E> implements IArray2D<E>{

    private E [][] elements;

    public Array2D(int height, int width) {
        elements = (E[][]) new Object[height][width];
    }

    public E getPosition(Position pos) {
        return elements[pos.getX()][pos.getY()];
    }

    public void setPosition(Position pos, E e) {
        elements[pos.getX()][pos.getY()] = e;
    }

    public boolean isValid(Position pos) {
        boolean validX = pos.getX() >= 0 && pos.getX() < elements[0].length;
        boolean validY = pos.getY() >= 0 && pos.getY() < elements.length;

        return validX && validY;
    }

    public IArray2D<E> copy() {
        IArray2D<E> copy = new Array2D(elements.length, elements[0].length);
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[0].length; j++) {
                copy.setPosition(new Position(i, j), elements[i][j]);
            }
        }
        return copy;
    }

    public int getHeight() {
        return elements.length;
    }

    public int getWidth() {
        return elements[0].length;
    }
}

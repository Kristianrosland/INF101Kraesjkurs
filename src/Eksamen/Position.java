package Eksamen;
/**
 * Koordinater
 */
public class Position {

    private final int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return X-koordinatet
     */
    public int getX() {
        return x;
    }

    /**
     * @return Y-koordinatet
     */
    public int getY() {
        return y;
    }

    /**
     * @param dir Horisontal eller vertikal retning
     * @return Ny posisjon
     */
    public Position stepForward(Direction dir) {
        if (dir == Direction.HORIZONTAL) {
            return new Position(x+1, y);
        } else {
            return new Position(x, y+1);
        }
    }
    
    public Position stepBackwards(Direction dir){
    	if(dir == Direction.HORIZONTAL){
    		return new Position(x-1, y);
    	}else {
    		return new Position(x, y-1);
    	}
    }
}

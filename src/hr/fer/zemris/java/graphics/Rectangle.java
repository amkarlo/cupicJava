package hr.fer.zemris.java.graphics;

/**
 * Created by akarlovic on 2.2.2017..
 */
public class Rectangle extends GeometricShape {
    private int sizeTwo;

    public Rectangle(int x, int y, int sizeOne, int sizeTwo){
        super(x, y, sizeOne);
        this.sizeTwo = sizeTwo;
    }

    public int getSizeTwo() {
        return sizeTwo;
    }

    public void setSizeTwo(int sizeTwo) {
        this.sizeTwo = sizeTwo;
    }

    @Override
    public boolean containsPoint(int x, int y) {
        if (x < getX() || x > (getX() + getSizeOne()-1) || y < getY() || y > (getY() + getSizeTwo()-1) )
            return false;
        return true;
    }
}

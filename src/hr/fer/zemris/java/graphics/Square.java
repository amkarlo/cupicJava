package hr.fer.zemris.java.graphics;

/**
 * Created by akarlovic on 2.2.2017..
 */
public class Square extends GeometricShape {

    public Square(int x, int y, int sizeOne){
        super(x,y,sizeOne);
    }

    @Override
    public boolean containsPoint(int x, int y) {
        if (x < getX() || x > (getX() + getSizeOne()-1) || y < getY() || y > (getY() + getSizeOne()-1) )
            return false;
        return true;
    }
}

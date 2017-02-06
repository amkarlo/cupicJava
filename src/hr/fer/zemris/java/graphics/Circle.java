package hr.fer.zemris.java.graphics;

/**
 * Created by akarlovic on 3.2.2017..
 */
public class Circle extends GeometricShape {

    public Circle(int x, int y, int sizeOne){
        super(x,y,sizeOne);
    }

    @Override
    public boolean containsPoint(int x, int y) {
        if (Math.sqrt(Math.pow(getX()-x,2) +
                Math.pow(getY()-y,2)) > getSizeOne())
            return false;
        return true;
    }
}

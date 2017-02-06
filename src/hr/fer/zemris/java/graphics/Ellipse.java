package hr.fer.zemris.java.graphics;

/**
 * Created by akarlovic on 2.2.2017..
 */
public class Ellipse extends GeometricShape {
    private int sizeTwo;

    public Ellipse(int x, int y, int sizeOne, int sizeTwo){
        super(x,y,sizeOne);
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
        if (((Math.pow(getX()-x,2)/Math.pow(getSizeOne(),2)) +
                (Math.pow(getY()-y,2)/Math.pow(getSizeTwo(),2))) > 1)
            return false;
        return true;
    }
}

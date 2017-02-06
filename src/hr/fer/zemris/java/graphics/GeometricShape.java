package hr.fer.zemris.java.graphics;

import hr.fer.zemris.java.graphics.raster.BWRaster;

/**
 * Created by akarlovic on 2.2.2017..
 */
public abstract class GeometricShape {
    private int x;
    private int y;
    private int sizeOne;

    public GeometricShape(){ }

    public GeometricShape(int x, int y, int sizeOne){
        this.x = x;
        this.y = y;
        this.sizeOne = sizeOne;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSizeOne() {
        return sizeOne;
    }

    public void setSizeOne(int sizeOne) {
        this.sizeOne = sizeOne;
    }

    public void draw(BWRaster r){
        for (int i = 0; i < r.getHeight(); ++i){
            for(int j = 0; j < r.getWidth(); ++j){
                if (containsPoint(i,j)){
                    r.turnOn(i,j);
                }
            }
        }
    }
    public abstract boolean containsPoint(int x, int y);
}

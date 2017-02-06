package hr.fer.zemris.java.graphics.raster;

/**
 * Created by akarlovic on 2.2.2017..
 */
public interface BWRaster {
    public int getWidth();
    public int getHeight();
    public void clear();
    public void turnOn(int x, int y);
    public void turnOff(int x, int y);
    public boolean isFlipModeDisabled();
    public void enableFlipMode();
    public void disableFlipMode();
    public boolean isTurnedOn(int x, int y);
}

package hr.fer.zemris.java.graphics.raster;

import hr.fer.zemris.java.graphics.raster.BWRaster;

import java.util.Arrays;

/**
 * Created by akarlovic on 2.2.2017..
 */
public class BWRasterMem implements BWRaster {
    private int width;
    private int height;
    private boolean disabled;
    private boolean[][] pixels;

    public BWRasterMem(int width, int height){
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException("Width and height need to be > 0.");
        this.width = width;
        this.height = height;
        this.disabled = true;
        pixels = new boolean[height][width];
        for (int i = 0; i < height; ++i) {
            Arrays.fill(pixels[i], false);
        }
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void clear() {
        for (int i = 0; i < height; ++i) {
            Arrays.fill(pixels[i], false);
        }
    }

    private void isAllowed(int x, int y){
        if (x < 0 || x >= height || y < 0 || y >= width )
            throw new IllegalArgumentException("Raster coordinates are not in the allowed limits: " +
                    Integer.toString(x) + ',' + Integer.toString(y));
    }

    private void changePixel(int x, int y){
        if (pixels[x][y])
            pixels[x][y] = false;
        else
            pixels[x][y] = true;
    }

    @Override
    public void turnOn(int x, int y) {
        isAllowed(x,y);
        if (disabled)
            pixels[x][y] = true;
        else
            changePixel(x,y);
    }

    @Override
    public void turnOff(int x, int y) {
        isAllowed(x,y);
        if (disabled)
            pixels[x][y] = false;
        else
            changePixel(x,y);
    }
    @Override
    public boolean isFlipModeDisabled(){
        return disabled;
    }

    @Override
    public void enableFlipMode() {
        disabled = false;
    }

    @Override
    public void disableFlipMode() {
        disabled = true;
    }

    @Override
    public boolean isTurnedOn(int x, int y) {
        isAllowed(x,y);
        return pixels[x][y];
    }
}

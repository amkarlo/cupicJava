package hr.fer.zemris.java.graphics.views;

import hr.fer.zemris.java.graphics.raster.BWRaster;

/**
 * Created by akarlovic on 3.2.2017..
 */
public class StringRasterView implements RasterView{
    private char pixelOn;
    private char pixelOff;
    private String result;

    StringRasterView(char pixelOn, char pixelOff){
        this.pixelOn = pixelOn;
        this.pixelOff = pixelOff;
        this.result = "";
    }

    StringRasterView(){
        this('*', '.');
    }

    public String getResult() {
        return result;
    }

    @Override
    public Object produce(BWRaster raster) {
        for (int i = 0; i < raster.getHeight(); ++i){
            for(int j = 0; j < raster.getWidth(); ++j) {
                if (raster.isTurnedOn(i,j))
                    result += pixelOn;
                else
                    result += pixelOff;
            }
            result += '\n';
        }
        return null;
    }
}

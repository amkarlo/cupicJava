package hr.fer.zemris.java.graphics.views;

import hr.fer.zemris.java.graphics.raster.BWRaster;

/**
 * Created by akarlovic on 3.2.2017..
 */
public interface RasterView {
    Object produce(BWRaster raster);
}

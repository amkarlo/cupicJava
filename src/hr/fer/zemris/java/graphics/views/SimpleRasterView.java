package hr.fer.zemris.java.graphics.views;

import hr.fer.zemris.java.graphics.*;
import hr.fer.zemris.java.graphics.raster.*;
import hr.fer.zemris.java.graphics.views.StringRasterView;
import hr.fer.zemris.java.tecaj.hw3.prob1.SymbolSubLexer;

/**
 * Created by akarlovic on 3.2.2017..
 */
public class SimpleRasterView implements RasterView {
    private char pixelOn;
    private char pixelOff;

    public SimpleRasterView(char pixelOn, char pixelOff){
        this.pixelOn = pixelOn;
        this.pixelOff = pixelOff;
    }

    public SimpleRasterView(){
        this('*', '.');
    }

    @Override
    public Object produce(BWRaster raster) {
        for (int i = 0; i < raster.getHeight(); i++){
            for(int j = 0; j < raster.getWidth(); j++) {
                if (raster.isTurnedOn(i,j))
                    System.out.print(pixelOn);
                else
                    System.out.print(pixelOff);
            }
            System.out.println();
        }
        return null;
    }

    public static void main(String[] args){
        Rectangle rect1 = new Rectangle(0, 0, 4, 4);
        Rectangle rect2 = new Rectangle(1, 1, 2, 2);
        Circle circle = new Circle(3, 3, 2);
        Ellipse ellipse = new Ellipse(3, 3, 3, 4);
        BWRaster raster = new BWRasterMem(6, 5);
        BWRaster raster1 = new BWRasterMem(10, 10);
        raster.enableFlipMode();
        raster1.enableFlipMode();
        rect1.draw(raster);
        rect2.draw(raster);
        circle.draw(raster1);
        ellipse.draw(raster1);
        RasterView view = new SimpleRasterView();
        view.produce(raster);
        view.produce(raster);
        System.out.println();
        RasterView view2 = new SimpleRasterView('X','_');
        StringRasterView view3 = new StringRasterView();
        view2.produce(raster);
        view3.produce(raster1);
        System.out.println(view3.getResult());
    }

}

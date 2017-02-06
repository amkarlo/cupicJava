package hr.fer.zemris.java.graphics;

import hr.fer.zemris.java.graphics.raster.BWRaster;
import hr.fer.zemris.java.graphics.raster.BWRasterMem;
import hr.fer.zemris.java.graphics.views.RasterView;
import hr.fer.zemris.java.graphics.views.SimpleRasterView;
import hr.fer.zemris.java.tecaj.hw1.Main;
import org.w3c.dom.css.Rect;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by akarlovic on 3.2.2017..
 */
public class Demo {
    private static int[] params = {1,1,1,1};

    private static Map<String, Class<?>> shapeMap = new HashMap<String, Class<?>>() {
        {
            put("FLIP", null);
            put("RECTANGLE", Rectangle.class);
            put("SQUARE", Square.class);
            put("ELLIPSE", Ellipse.class);
            put("CIRCLE", Circle.class);
        }
    };

    public static GeometricShape instantiate(String[] input) throws Exception{
        Class<?> clazz = shapeMap.get(input[0]);
        if (clazz == null)
            return null;

        Object[] params = new Object[input.length-1];
        Class<?>[] paramTypes = new Class<?>[input.length-1];
        for(int i = 1; i < input.length; ++i) {
            params[i-1] = Integer.parseInt(input[i]);
            paramTypes[i-1] = int.class;
        }
        Constructor<?> explicitConstructor = clazz.getConstructor(paramTypes);
        return (GeometricShape)explicitConstructor.newInstance((Object[])params);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new BufferedInputStream(System.in))    );
        BWRaster raster;
        int width = Integer.parseInt(args[0]);
        int height;

        if (args[1] != null){
            height = Integer.parseInt(args[1]);
        }
        else
            height = width;
        System.out.println(Integer.toString(width) + ',' +  Integer.toString(height));
        raster = new BWRasterMem(width, height);

        int number = Main.ucitaj("number of shapes to draw");
        GeometricShape[] shapes = new GeometricShape[number];

        int counter = 0;
        while(counter < number){
            String input = reader.readLine();
            String[] inputArray = input.split("\\s");
            try {
                shapes[counter++] = instantiate(inputArray);
            }catch (Exception e){
                System.out.print(e.getMessage());
            }
        }
        counter = 0;
        while(counter < number){
            if (shapes[counter] != null)
                shapes[counter].draw(raster);
            else {
                if (raster.isFlipModeDisabled())
                    raster.enableFlipMode();
                else
                    raster.disableFlipMode();
            }
            ++counter;
        }
        RasterView view = new SimpleRasterView();
        view.produce(raster);

    }
}

import java.awt.*;  
import java.awt.image.*;  

public class OFImage extends BufferedImage {  

    public OFImage(BufferedImage image) {  
        super(image.getColorModel(), image.copyData(null), image.isAlphaPremultiplied(), null);  
    }  

    public OFImage(int width, int height) {  
        super(width, height, TYPE_INT_RGB);  
    }  

    public void setPixel(int x, int y, Color color) {  
        int rgbValue = color.getRGB();  
        setRGB(x, y, rgbValue);  
    }  

    public Color getPixel(int x, int y) {  
        int rgbValue = getRGB(x, y);  
        return new Color(rgbValue);  
    }  

    public void darker() {  
        int width = getWidth();  
        int height = getHeight();  

        for (int y = 0; y < height; y++) {  
            for (int x = 0; x < width; x++) {  
                setPixel(x, y, getPixel(x, y).darker());  
            }  
        }  
    }  

    public void lighter() {  
        int width = getWidth();  
        int height = getHeight();  

        for (int y = 0; y < height; y++) {  
            for (int x = 0; x < width; x++) {  
                setPixel(x, y, getPixel(x, y).brighter());  
            }  
        }  
    }  

    public void threshold() {  
        int width = getWidth();  
        int height = getHeight();  

        for (int y = 0; y < height; y++) {  
            for (int x = 0; x < width; x++) {  
                Color pixelColor = getPixel(x, y);  
                int brightness = pixelColor.getRed() + pixelColor.getGreen() + pixelColor.getBlue();  

                if (brightness <= 85) {  
                    setPixel(x, y, Color.BLACK);  
                } else if (brightness <= 170) {  
                    setPixel(x, y, Color.GRAY);  
                } else {  
                    setPixel(x, y, Color.WHITE);  
                }  
            }  
        }  
    }  
}
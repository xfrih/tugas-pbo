import java.awt.image.BufferedImage;  
import java.io.File;  
import java.io.IOException;  
import javax.imageio.ImageIO;  

public class ImageFileManager {  
    private static final String IMAGE_FORMAT = "jpg";

    public static OFImage loadImage(File imageFile) {  
        try {  
            BufferedImage bufferedImage = ImageIO.read(imageFile);  

            if (bufferedImage == null || bufferedImage.getWidth() <= 0) {  
                return null;  
            }  

            return new OFImage(bufferedImage);  
        } catch (Exception e) {  
            return null;  
        }  
    }  

    public static void saveImage(OFImage image, File file) {  
        try {  
            ImageIO.write(image, IMAGE_FORMAT, file);  
        } catch (IOException e) {  

        }  
    }  
}
import java.awt.*;  
import javax.swing.*;  

public class ImagePanel extends JComponent {  
    private OFImage panelImage;  

    public ImagePanel() {  
        panelImage = null;  
    }  

    public void setImage(OFImage image) {  
        if (image != null) {  
            panelImage = image;  
            repaint();  
        }  
    }  

    public void clearImage() {  
        if (panelImage != null) {
            Graphics imageGraphics = panelImage.getGraphics();  
            imageGraphics.setColor(Color.LIGHT_GRAY);  
            imageGraphics.fillRect(0, 0, getWidth(), getHeight());  
            repaint();  
        }
    }  

    @Override
    public Dimension getPreferredSize() {  
        return new Dimension(800, 600);  
    }  

    @Override
    protected void paintComponent(Graphics g) {  
        super.paintComponent(g);  

        if (panelImage != null) {  
            int panelWidth = getWidth();  
            int panelHeight = getHeight();  
            int imageWidth = panelImage.getWidth();  
            int imageHeight = panelImage.getHeight();  

            double imageAspectRatio = (double) imageWidth / imageHeight;  
            double panelAspectRatio = (double) panelWidth / panelHeight;  

            int drawWidth, drawHeight;  
            int xOffset = 0, yOffset = 0;  

            if (panelAspectRatio > imageAspectRatio) {  
                drawHeight = panelHeight;  
                drawWidth = (int) (drawHeight * imageAspectRatio);  
                xOffset = (panelWidth - drawWidth) / 2;
            } else {  
                drawWidth = panelWidth;  
                drawHeight = (int) (drawWidth / imageAspectRatio);  
                yOffset = (panelHeight - drawHeight) / 2;
            }  

            g.drawImage(panelImage, xOffset, yOffset, drawWidth, drawHeight, null);  
        } else {  
            g.setColor(Color.LIGHT_GRAY);  
            g.fillRect(0, 0, getWidth(), getHeight());  
        }  
    }  
}
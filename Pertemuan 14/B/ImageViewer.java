import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
import java.io.File;  

public class ImageViewer {  
    private static final String VERSION = "Version 1.0";  
    private static JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));  

    private JFrame frame;  
    private ImagePanel imagePanel;  
    private JLabel filenameLabel;  
    private JLabel statusLabel;  
    private OFImage currentImage;  

    public ImageViewer() {  
        currentImage = null;  
        initializeFrame();  
    }  

    private void openFile() {  
        int result = fileChooser.showOpenDialog(frame);  

        if (result != JFileChooser.APPROVE_OPTION) {  
            return;  
        }  

        File selectedFile = fileChooser.getSelectedFile();  
        currentImage = ImageFileManager.loadImage(selectedFile);  

        if (currentImage == null) {  
            JOptionPane.showMessageDialog(frame, 
                "The file format is not supported.", 
                "Image Load Error", 
                JOptionPane.ERROR_MESSAGE
            );  
            return;  
        }  

        imagePanel.setImage(currentImage);  
        updateFilename(selectedFile.getPath());  
        updateStatus("File loaded successfully.");  
        frame.pack();  
    }  

    private void closeImage() {  
        currentImage = null;  
        imagePanel.clearImage();  
        updateFilename(null);  
    }  

    private void quitApplication() {  
        System.exit(0);  
    }  

    private void applyDarkerFilter() {  
        if (currentImage != null) {  
            currentImage.darker();  
            frame.repaint();  
            updateStatus("Image darkened.");  
        } else {  
            updateStatus("No image loaded.");  
        }  
    }  

    private void applyLighterFilter() {  
        if (currentImage != null) {  
            currentImage.lighter();  
            frame.repaint();  
            updateStatus("Image lightened.");  
        } else {  
            updateStatus("No image loaded.");  
        }  
    }  

    private void applyThresholdFilter() {  
        if (currentImage != null) {  
            currentImage.threshold();  
            frame.repaint();  
            updateStatus("Image thresholded.");  
        } else {  
            updateStatus("No image loaded.");  
        }  
    }  

    private void showAboutDialog() {  
        JOptionPane.showMessageDialog(frame, 
            "Image Viewer\n" + VERSION, 
            "About Image Viewer", 
            JOptionPane.INFORMATION_MESSAGE
        );  
    }  

    private void updateFilename(String filename) {  
        if (filename == null) {  
            filenameLabel.setText("No file displayed.");  
        } else {  
            filenameLabel.setText("File: " + filename);  
        }  
    }  

    private void updateStatus(String message) {  
        statusLabel.setText(message);  
    }  

    private void initializeFrame() {  
        frame = new JFrame("Image Viewer");  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

        setupMenuBar(frame);  

        Container contentPane = frame.getContentPane();  
        contentPane.setLayout(new BorderLayout(6, 6));  

        filenameLabel = new JLabel();  
        contentPane.add(filenameLabel, BorderLayout.NORTH);  

        imagePanel = new ImagePanel();  
        contentPane.add(imagePanel, BorderLayout.CENTER);  

        statusLabel = new JLabel(VERSION);  
        contentPane.add(statusLabel, BorderLayout.SOUTH);  

        updateFilename(null);  
        frame.pack();  

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  
        frame.setLocation(screenSize.width / 2 - frame.getWidth() / 2, 
                          screenSize.height / 2 - frame.getHeight() / 2);  

        frame.setVisible(true);  
    }  

    private void setupMenuBar(JFrame frame) {  
        final int SHORTCUT_MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx();  

        JMenuBar menuBar = new JMenuBar();  
        frame.setJMenuBar(menuBar);  

        JMenu fileMenu = new JMenu("File");  
        menuBar.add(fileMenu);  

        addMenuItem(fileMenu, "Open", KeyEvent.VK_O, SHORTCUT_MASK, e -> openFile());  
        addMenuItem(fileMenu, "Close", KeyEvent.VK_W, SHORTCUT_MASK, e -> closeImage());  
        addMenuItem(fileMenu, "Quit", KeyEvent.VK_Q, SHORTCUT_MASK, e -> quitApplication());  

        JMenu filterMenu = new JMenu("Filter");  
        menuBar.add(filterMenu);  

        addMenuItem(filterMenu, "Darker", 0, 0, e -> applyDarkerFilter());  
        addMenuItem(filterMenu, "Lighter", 0, 0, e -> applyLighterFilter());  
        addMenuItem(filterMenu, "Threshold", 0, 0, e -> applyThresholdFilter());  

        JMenu helpMenu = new JMenu("Help");  
        menuBar.add(helpMenu);  

        addMenuItem(helpMenu, "About", 0, 0, e -> showAboutDialog());  
    }  

    private void addMenuItem(JMenu menu, String title, int keyEvent, int mask, ActionListener action) {  
        JMenuItem item = new JMenuItem(title);  
        if (keyEvent > 0) {  
            item.setAccelerator(KeyStroke.getKeyStroke(keyEvent, mask));  
        }  
        item.addActionListener(action);  
        menu.add(item);  
    }  

    public static void main(String[] args) {  
        new ImageViewer();  
    }  
}
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageGalary extends JFrame {
    private File[] imageFiles;
    private int currentIndex;

    private JLabel imageLabel;

    public ImageGalary() {
        // Set up the JFrame
        setTitle("Image Gallery");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Load image files from the "images" folder
        File folder = new File("images");
        imageFiles = folder.listFiles(new ImageFileFilter());

        if (imageFiles == null || imageFiles.length == 0) {
            JOptionPane.showMessageDialog(this, "No images found in the 'images' folder.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        // Set up the image label
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        // Set up navigation buttons
        JButton prevButton = new JButton("Previous");
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPreviousImage();
            }
        });

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextImage();
            }
        });

        // Set up layout
        setLayout(new BorderLayout());
        add(imageLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Display the first image
        currentIndex = 0;
        displayImage();

        // Make the JFrame visible
        setVisible(true);
    }

    private void displayImage() {
        if (currentIndex >= 0 && currentIndex < imageFiles.length) {
            ImageIcon imageIcon = new ImageIcon(imageFiles[currentIndex].getPath());
            Image image = imageIcon.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
            imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);
        }
    }

    private void showPreviousImage() {
        currentIndex = (currentIndex - 1 + imageFiles.length) % imageFiles.length;
        displayImage();
    }

    private void showNextImage() {
        currentIndex = (currentIndex + 1) % imageFiles.length;
        displayImage();
    }

    // File filter class to filter only JPG files
    private static class ImageFileFilter implements java.io.FileFilter {
        @Override
        public boolean accept(File pathname) {
            return pathname.isFile() && pathname.getName().toLowerCase().endsWith(".jpg");
        }
    }

    // Method to add an image dynamically
    public void addImage(String imagePath) {
        File newImageFile = new File(imagePath);
        if (newImageFile.isFile() && newImageFile.getName().toLowerCase().endsWith("bike1.jpg")) {
            File[] newArray = new File[imageFiles.length + 1];
            System.arraycopy(imageFiles, 0, newArray, 0, imageFiles.length);
            newArray[imageFiles.length] = newImageFile;
            imageFiles = newArray;
            currentIndex = imageFiles.length - 1;
            displayImage();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid image file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ImageGalary gallery = new ImageGalary();

                // Example: Add an image dynamically
                gallery.addImage("images/new_image.jpg");
            }
        });
    }
}

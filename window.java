import java.awt.*;
import javax.swing.*;
import java.lang.*;

public class window {

    // create a simple GUI window
    public static void createWindow() {
        JFrame frame = new JFrame("SignSupport");

        frame.add(new JPanel() {

            @Override // placeholder for actual content
            public Dimension getPreferredSize() {
                return new Dimension(600, 500);
            }
        });

        frame.pack(); // automatically sets size of window for content

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - frame.getWidth();
        int y = 0;
        frame.setLocation(x, y);
        frame.setVisible(true); // show window

        JLabel textLabel = new JLabel("Welcome to SignSupport", SwingConstants.CENTER);     // create text label
        textLabel.setPreferredSize(new Dimension(300, 100));                                // set text size
        frame.getContentPane().add(textLabel, BorderLayout.NORTH);                         // add JLabel to JFrame

    }

    public static void main(String[] args) {
        createWindow();

    }

}

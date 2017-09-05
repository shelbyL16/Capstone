import java.awt.*;
import javax.swing.*;
import java.lang.*;

/**
 * Created by Lucia on 2017/09/04.
 */

public class CreateWindow {

    // create a simple GUI CreateWindow
    public static void createWindow() {
        JFrame frame = new JFrame("SignSupport");

        frame.add(new JPanel() {

            @Override // placeholder for actual content
            public Dimension getPreferredSize() {
                return new Dimension(600, 500);
            }
        });

        frame.pack(); // automatically sets size of CreateWindow for content

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - frame.getWidth();
        int y = 0;
        frame.setLocation(x, y);
        frame.setVisible(true); // show CreateWindow

        JLabel textLabel = new JLabel("Welcome to SignSupport", SwingConstants.CENTER);     // create text label
        textLabel.setPreferredSize(new Dimension(300, 100));                                // set text size
        frame.getContentPane().add(textLabel, BorderLayout.NORTH);                         // add JLabel to JFrame

    }

    public static void main(String[] args) {
        createWindow();

    }

}

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DisplayImage {

    public static void main(String avg[]) throws IOException
    {
        DisplayImage given = new DisplayImage();
    }//end main

    //display image method
    public DisplayImage() throws IOException
    {
        double w,h = 0; 
        JFrame frame = new JFrame();
        JLabel label =new JLabel();
        JLabel label2 =new JLabel();
        
        
        //take in path
        BufferedImage image=ImageIO.read(new File("C:\\Users\\slabu\\Documents\\University\\2017\\Courses\\Second Semester\\CSC3003S\\Capstone\\Program\\Capstone-master\\europelargesm.jpg"));
        
        //take in read image object
        ImageIcon icon = new ImageIcon(image);

        //get width and height to set it on the Jframe to make it the image size (i.e. no image resizing needed)
        w = image.getWidth();
        h = image.getHeight();
        
        
        //set size
        frame.setLayout(new FlowLayout());
        frame.setSize((int)w+500,(int)h+500);//make biger otherwise it doesn't fit
        
        //need to display the image in a JFrame
        w=(w*0.5);
        h=h*0.5;
        
        //resizing of image
        image.getScaledInstance(((int)w), ((int)h), Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(image.getScaledInstance(((int)w), ((int)h), Image.SCALE_DEFAULT));

        //adding images so that they will be displayed
        label.setIcon(icon);
        label2.setIcon(icon2);
        frame.add(label);//cant add an icon so need to add it in a label and then to frame
        frame.add(label2);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
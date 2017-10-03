package signsupport;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.Screen;
import java.io.*;

public class WelcomeScreen extends Application {

    private static final String MEDIA_URL = "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";

    private static final File file = new File("/Users/Lucia/Downloads/Welcome screen.mp4");
    private static final String VIDEO_URL = file.toURI().toString();

    private Button lessonButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("SignSupport");
        Group root = new Group();
        //Scene scene = new Scene(root, 540, 241);
        Scene scene = new Scene(root, 600, 500);


        // create video player
        //Media video = new Media(MEDIA_URL);
        Media media = new Media(VIDEO_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);

        VideoPlayer mediaControl = new VideoPlayer(mediaPlayer);
        scene.setRoot(mediaControl);

        // Add a lesson button - cannot put multiple panes on one stage
        lessonButton = new Button("Lessons");
        lessonButton.setLayoutX(100);
        lessonButton.setLayoutY(300);
        Pane layout = new Pane();
        layout.getChildren().add(lessonButton);

        primaryStage.setScene(scene);

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        // Set primary stage boundaries to visible bounds of the main screen
        primaryStage.setX(primaryScreenBounds.getMaxX() - 600);
        primaryStage.setY(primaryScreenBounds.getMinY());

        primaryStage.sizeToScene();
        primaryStage.show();
    }
}
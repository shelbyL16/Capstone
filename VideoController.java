package signsupport;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Lucia on 2017/10/03.
 */
public class VideoController {   // implements Initializable {

    @FXML
    private MediaView mv;
    private MediaPlayer mediaPlayer;
    private Media media;

    //@Override
    //public void initialize(URL url, ResourceBundle rb) {

    public void videoObject() {

        try {
            Parent layout = FXMLLoader.load(getClass().getResource("Video.fxml"));
            Scene scene = new Scene(layout);
            Stage stage = new Stage();

            //Pane mvPane = new Pane() {                };


            String path = new File("src/video/Welcome screen.mp4").getAbsolutePath();
            System.out.println("Working Directory = " +
                    System.getProperty("user.dir"));
            media = new Media(new File(path).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            mv = new MediaView(mediaPlayer);
            //mv.setMediaPlayer(mediaPlayer);
            System.out.println(mv);
            mediaPlayer.setAutoPlay(true);

            //mvPane.getChildren().add(this.mv);
            //mvPane.setStyle("-fx-background-color: black;");
            //setCenter(mvPane);
            //scene.setRoot(layout);

            //VideoPlayer mediaControl = new VideoPlayer(mediaPlayer);
            //scene.setRoot(mediaControl);

            /*primaryStage.setScene(scene);
            primaryStage.show();
            System.out.println("ps: " + primaryStage);*/
        }
        catch (Exception ex) {}

    }

}

package signsupport;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.application.HostServices;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Lucia on 2017/10/02.
 */

// controller class for TaskList

public class ListViewController implements Initializable {

    private ArrayList<Screen> screenArr = new ArrayList<>();

    @FXML
    public ListView<String> listView;

    String urlString;

    @FXML private MediaView mediaView;
    @FXML private MediaPlayer mediaPlayer;
    @FXML private Media media;

    //private Stage primaryStage;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        /*File file = new File("/Users/Lucia/Downloads/Welcome screen.mp4");
        final String VIDEO_URL = file.toURI().toString();*/



        Parse p = new Parse();
        screenArr = p.parse();

        ObservableList<String> taskNames = FXCollections.observableArrayList();


        for (int i=0; i<screenArr.size(); i++) {
            taskNames.add(screenArr.get(i).getVidCaption());
        }

        listView.setItems(taskNames);

        listView.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {

            if (oldValue == null) {
                oldValue = "";
            }


            System.out.println("ListView Selection Changed. \nOld Value: " + oldValue.toString() + "\nNew Value: " + newValue.toString() + "\n");

            for (int i=0; i<screenArr.size(); i++) {

                if (newValue.equals(screenArr.get(i).getVidCaption())) {
                    System.out.println(screenArr.get(i));
                    System.out.println(screenArr.get(i).getVideoURL());

                    urlString = "src/video/What is an organization.mp4";
                    //System.out.println(urlString);

                    /*String path = new File("src/video/What is an organization.mp4").getAbsolutePath();
                    media = new Media(new File(path).toURI().toString());
                    mediaPlayer = new MediaPlayer(media);
                    mediaView.setMediaPlayer(mediaPlayer);
                    mediaPlayer.setAutoPlay(true);*/

                    loadVideo(urlString);

                    break;
                }

                else {
                    System.out.println("not found");
                }
            }
        }));

    }

    public void loadVideo(String url) {

        /*String path = new File(url).getAbsolutePath();
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        //File f = new File(path);
        //System.out.println("This is the answer "+Files.isExecutable(url));
        media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);

        mediaView = new MediaView(mediaPlayer);

        System.out.println(mediaView);
        //mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setAutoPlay(true);
        */

        VideoController vControl = new VideoController();
        vControl.videoObject();
    }



    // for when 'Back' button is clicked on TaskList - transition back to LessonList
    @FXML
    public void backToLessonClicked(ActionEvent event) throws IOException {

        Parent layout = FXMLLoader.load(getClass().getResource("LessonList.fxml"));
        Scene lessonList = new Scene(layout);
        Stage lessonStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        //primaryStage = lessonStage;
        lessonStage.setScene(lessonList);
        lessonStage.show();
    }

    @FXML
    public void convertToVideoScreen(ActionEvent event) throws IOException {
        Parent layout = FXMLLoader.load(getClass().getResource("Video.fxml"));
        Scene lessonList = new Scene(layout);
        Stage lessonStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        lessonStage.setScene(lessonList);
        lessonStage.show();
    }





}

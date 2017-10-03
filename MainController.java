package signsupport;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Lucia on 2017/10/02.
 */

// controller class for TaskList

public class MainController implements Initializable {

    private ArrayList<Screen> screenArr = new ArrayList<>();

    @FXML
    public ListView<String> listView;

    String urlString;

    @FXML
    private MediaView mediaView;
    private MediaPlayer mediaPlayer;
    private Media media;

    public static Screen clickedScreen;

    //private Stage primaryStage;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        /*File file = new File("/Users/Lucia/Downloads/Welcome screen.mp4");
        final String VIDEO_URL = file.toURI().toString();*/



        XMLReader p = new XMLReader();
        screenArr = p.parse();

        ObservableList<String> taskNames = FXCollections.observableArrayList();


        for (int i=0; i<screenArr.size(); i++) {
            taskNames.add(screenArr.get(i).getVidCaption());
        }

        listView.setItems(taskNames);


        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event)  {
                System.out.println("setonmouseclicked: "+ screenArr.get(listView.getSelectionModel().getSelectedIndex()));

                clickedScreen = screenArr.get(listView.getSelectionModel().getSelectedIndex());

                try {
                handleMouseClick(event); }

                catch (IOException e) {};

            }
        });

    }

    @FXML
    public void handleMouseClick(MouseEvent arg0) throws IOException {
        System.out.println("clicked on " + listView.getSelectionModel().getSelectedItem());

        Parent layout = FXMLLoader.load(getClass().getResource("Video.fxml"));
        Scene lessonList = new Scene(layout);
        Stage lessonStage = (Stage) ((Node)arg0.getSource()).getScene().getWindow();
        lessonStage.setScene(lessonList);
        lessonStage.show();
    }

    // for when 'Back' button is clicked on TaskList - transition back to LessonList
    @FXML
    public void backToLessonClicked(ActionEvent event) throws IOException {

        Parent layout = FXMLLoader.load(getClass().getResource("LessonList.fxml"));
        Scene lessonList = new Scene(layout);
        Stage lessonStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        lessonStage.setScene(lessonList);
        lessonStage.show();
    }

    // for when 'Back' button is clicked on Video - transition back to TaskList
    @FXML
    public void backToTaskClicked(ActionEvent event) throws IOException {

        Parent layout = FXMLLoader.load(getClass().getResource("TaskList.fxml"));
        Scene taskList = new Scene(layout);
        Stage taskStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        taskStage.setScene(taskList);
        taskStage.show();
    }


}

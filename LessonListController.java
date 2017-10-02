package signsupport;

import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * Created by Lucia on 2017/09/08.
 */
public class LessonListController { //implements Initializable {

    @FXML private JFXListView<Label> lessonList;


    /*@Override
    public void initialize(URL url, ResourceBundle rb) {

            for (int i = 0; i < 4; i++) {
                Label lessonLabel = new Label("Lesson " + i);
                lessonList.getItems().add(lessonLabel);

        }
    }*/


    @FXML
    public void backButtonClicked(ActionEvent event) throws IOException {

        //System.out.println("Button clicked");

        Parent layout = FXMLLoader.load(getClass().getResource("Window.fxml"));
        Scene home = new Scene(layout);
        Stage homeStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        homeStage.setScene(home);
        homeStage.show();
    }
}

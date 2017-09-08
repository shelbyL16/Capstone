package signsupport;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controller {

    private AnchorPane root;

    public void lessonButtonClicked(ActionEvent event) throws IOException {

        //System.out.println("Button clicked");

        Parent layout = FXMLLoader.load(getClass().getResource("LessonList.fxml"));
        Scene lessonList = new Scene(layout, 600, 500);
        Stage lessonStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        lessonStage.setScene(lessonList);
        lessonStage.show();
    }
}

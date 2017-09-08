package signsupport;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Lucia on 2017/09/08.
 */
public class LessonListController {

    public void backButtonClicked(ActionEvent event) throws IOException {

        //System.out.println("Button clicked");

        Parent layout = FXMLLoader.load(getClass().getResource("Window.fxml"));
        Scene home = new Scene(layout, 600, 500);
        Stage homeStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        homeStage.setScene(home);
        homeStage.show();
    }
}

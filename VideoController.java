package signsupport;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class VideoController implements Initializable {

    private Media m;
    private MediaPlayer mp;
    @FXML private MediaView mv;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

            String videoURL = "src"+ MainController.clickedScreen.getVideoURL();
            String path = new File(videoURL).getAbsolutePath();
            System.out.println(path);

            m = new Media(new File(path).toURI().toString());
            mp = new MediaPlayer(m);
            mv.setMediaPlayer(mp);
            mp.setAutoPlay(true);

            //scalability for videos
            DoubleProperty width = mv.fitWidthProperty();
            DoubleProperty height = mv.fitHeightProperty();
            width.bind(Bindings.selectDouble(mv.sceneProperty(),"width"));
            height.bind(Bindings.selectDouble(mv.sceneProperty(),"height"));

            //mp.play();

            System.out.println("Working controller got screen: " + MainController.clickedScreen.getVidCaption());

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

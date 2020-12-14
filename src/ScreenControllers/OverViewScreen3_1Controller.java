/*
 * This is OverViewScreen3_1Controller class
 */
package ScreenControllers;

import JavaLogicMethod.ControlledScreen;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import tourismapp.TourismApp;

/**
 * @author ZuoyunJin(16825)
 */
public class OverViewScreen3_1Controller extends OverViewScreen3Controller implements Initializable, ControlledScreen {

    private final String filePath = ".\\src\\Media\\Video\\IMG_3613.mp4";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initialize video player
        initializeVideo(filePath);

    }

    @FXML
    private void goTo1stVideoPage(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(15));
        stopM(mediaType);
    }

}

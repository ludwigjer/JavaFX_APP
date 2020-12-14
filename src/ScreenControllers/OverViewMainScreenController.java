/*
 * This is OverViewMainScreenController class
 */
package ScreenControllers;

import JavaLogicMethod.ControlledScreen;
import JavaLogicMethod.JavaMultimediaController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import tourismapp.ScreensController;
import tourismapp.TourismApp;

/**
 * @author ZuoyunJin(16825)
 */
public class OverViewMainScreenController extends JavaMultimediaController implements Initializable, ControlledScreen {



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    //Set the parent so each seceen know who their parent is.
    public void setScreenParent(ScreensController screenParent) {
        controller = screenParent;
    }

    @FXML
    //go to IntroductionScreen
    private void logOut(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(0));

    }

    @FXML
    private void goToMenu(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(2));

    }

    @FXML
    private void goToDiscover(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(13));

    }

    @FXML
    private void goToGallary(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(14));

    }

    @FXML
    private void goToVideo(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(15));

    }

}

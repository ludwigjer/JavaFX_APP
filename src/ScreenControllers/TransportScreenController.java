/*
 * This is TransportScreenController class
 */
package ScreenControllers;

import JavaLogicMethod.ControlledScreen;
import JavaLogicMethod.ProgramLogicController;
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
public class TransportScreenController extends ProgramLogicController implements Initializable, ControlledScreen {

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
    private void goByBus(ActionEvent event) {

        openWeb("dublinBus");

    }

    @FXML
    private void goBoTrain(ActionEvent event) {

        openWeb("irishRail");

    }

    @FXML
    private void goByCar(ActionEvent event) {

        openWeb("googleMap");
    }

}

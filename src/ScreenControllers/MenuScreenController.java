/*
 * This is MenuScreenController class
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
public class MenuScreenController extends ProgramLogicController implements Initializable, ControlledScreen {

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
    private void goToAbout(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(3));

    }

    @FXML
    private void goToQRCode(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(4));

    }

    @FXML
    private void goToQuiz(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(5));

    }

    @FXML
    private void goToTransport(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(7));

    }

    @FXML
    private void goToFoodAndStayMain(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(8));

    }

    @FXML
    private void goToBookingTour(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(11));

    }

    @FXML
    private void goToDiscover(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(12));

    }

}

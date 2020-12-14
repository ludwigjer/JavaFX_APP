/*
 * This is QRCodeScreenController class
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
public class QRCodeScreenController extends ProgramLogicController implements Initializable, ControlledScreen {



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    //open facebook website
    private void goToFb(ActionEvent event) {
        openWeb("FB");
    }

    @FXML
    //open twitter website
    private void goToTwitter(ActionEvent event) {
        openWeb("TW");
    }

    @FXML
    //open instagram website
    private void goToIns(ActionEvent event) {
        openWeb("INS");
    }

}

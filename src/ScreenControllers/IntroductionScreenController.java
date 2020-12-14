/*
 * This is IntroductionScreenController class
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
 * 
 *@author ZuoyunJin(16825)
 */
public class IntroductionScreenController extends ProgramLogicController implements Initializable, ControlledScreen {

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
    private void toLoginScreen(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(1));
    }

}

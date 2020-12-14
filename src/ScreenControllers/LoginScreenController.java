/*
 * This is LoginScreenController class
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
 *  @author ZuoyunJin(16825)
 */
public class LoginScreenController extends ProgramLogicController implements Initializable, ControlledScreen {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Set accessDenied opacity 0
        accessDenied(0);
    }
    //Set the parent so each seceen know who their parent is.
    public void setScreenParent(ScreensController screenParent) {
        controller = screenParent;
    }

    @FXML
    //Call loginCheck method
    private void login(ActionEvent event) {
        loginCheck();
    }

    @FXML
    //Set accessDenied opacity 0 and go to IntroductionScreen
    private void cancel(ActionEvent event) {
        accessDenied(0);
        controller.setScreen(TourismApp.screenIDList.get(0));
    }

}

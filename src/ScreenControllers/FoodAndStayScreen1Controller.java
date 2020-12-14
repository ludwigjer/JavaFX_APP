/*
 * This is FoodAndStayScreen1Controller class
 */
package ScreenControllers;

import JavaLogicMethod.ControlledScreen;
import JavaLogicMethod.ProgramLogicController;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import tourismapp.ScreensController;
import tourismapp.TourismApp;

/**
 *
 * @author ZuoyunJin(16825)
 */
public class FoodAndStayScreen1Controller extends ProgramLogicController implements Initializable, ControlledScreen {

    @FXML
    private JFXTextField numberOfPeople, time;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorMessageOpacity(0, 0);
    }

    //Set the parent so each seceen know who their parent is.
    public void setScreenParent(ScreensController screenParent) {
        controller = screenParent;
    }

    @FXML
    //go to IntroductionScreen
    private void logOut(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(0));
        errorMessageOpacity(0, 0);
        changeTextMessage("");
        //clear 2 text field numberOfPeople&time
        clearTextfield(9);

    }

    @FXML
    private void goToMenu(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(2));
        errorMessageOpacity(0, 0);
        changeTextMessage("");
        //clear 2 text field numberOfPeople&time
        clearTextfield(9);

    }

    @FXML
    private void goToStay(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(10));
        errorMessageOpacity(0, 0);
        changeTextMessage("");
        //clear 2 text field numberOfPeople&time
        clearTextfield(9);

    }

    @FXML
    //Call method checkInput_2args
    private void bookRestaurant(ActionEvent event) {
        checkInput("ifNumberOfPeopleMatch", "ifTimeMatch");

    }

}

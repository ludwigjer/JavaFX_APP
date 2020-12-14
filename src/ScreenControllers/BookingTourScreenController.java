/*
 * This is BookingTourScreenController class
 */
package ScreenControllers;

import JavaLogicMethod.ControlledScreen;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import JavaLogicMethod.ProgramLogicController;
import tourismapp.ScreensController;
import tourismapp.TourismApp;

/**
 *
 * @author ZuoyunJin(16825)
 */
public class BookingTourScreenController extends ProgramLogicController implements Initializable, ControlledScreen {



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
        //clear 3 text field numberOfPeople&date&time
        clearTextfield(11);
        changeTextMessage("");
        //rest input mactch checker
        resetMatch();
    }

    @FXML
    private void goToMenu(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(2));
        errorMessageOpacity(0, 0);
        //clear 3 text field numberOfPeople&date&time
        clearTextfield(11);
        changeTextMessage("");
        //rest input mactch checker
        resetMatch();
    }

    @FXML
    //Call method checkInput_3args
    private void bookTour(ActionEvent event) {
        checkInput("ifNumberOfPeopleMatch","ifDateMatch","ifTimeMatch"); 
    }

}

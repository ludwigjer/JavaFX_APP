/*
 *This is FoodAndStayScreen2Controller
 */
package ScreenControllers;

import JavaLogicMethod.ControlledScreen;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import tourismapp.TourismApp;

/**
 * 
 * @author ZuoyunJin(16825)
 */
public class FoodAndStayScreen2Controller extends FoodAndStayScreen1Controller implements Initializable, ControlledScreen {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //all value to choicBox
        choiceBox.getItems().addAll("Double room", "Signel room", "Triple room", "King room");
        //set defaults
        choiceBox.setValue("Double room");
        errorMessageOpacity(0, 0);
        //set defaut check in date
        inDate.setValue(LocalDate.now());
        //set defaut check out date
        outDate.setValue(LocalDate.of(2019, 12, 31));

    }

    @FXML
    //go to IntroductionScreen
    private void logOut(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(0));
        errorMessageOpacity(0, 0);
        changeTextMessage("");

    }

    @FXML
    private void goToMenu(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(2));
        errorMessageOpacity(0, 0);
        changeTextMessage("");

    }

    @FXML
    private void goToFood(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(9));
        errorMessageOpacity(0, 0);
        changeTextMessage("");
    }

    @FXML
    //Call method checkInput
    private void bookHotel(ActionEvent event) {
        checkInput("ifDateMatch");
    }

}

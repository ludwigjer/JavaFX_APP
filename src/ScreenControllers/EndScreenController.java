/*
 *This is EndScreenController class
 */
package ScreenControllers;

import JavaLogicMethod.ControlledScreen;
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
public class EndScreenController extends QuizScreenController implements Initializable, ControlledScreen {



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
    private void goToMenu(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(2));
       
        
    }

    @FXML
    //open "https://powerscourt.com/"
    private void goToWeb(ActionEvent event) {
        openWeb("powerscourt");
    }

}

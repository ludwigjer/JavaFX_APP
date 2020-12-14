/*
 *This is OverViewScreen3Controller class
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
 *@author ZuoyunJin(16825)
 */
public class OverViewScreen3Controller  extends  OverViewMainScreenController implements Initializable, ControlledScreen {


    //Stroe vido file path to a string
    protected String mediaType="video", filePath = ".\\src\\Media\\Video\\IMG_3612.mp4";
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initialize video player
        initializeVideo(filePath);

    }

    @FXML
    //go to IntroductionScreen
    private void logOut(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(0));
        stopM(mediaType);

    }

    @FXML
    private void back(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(12));
        stopM(mediaType);
    }
    
    @FXML
    private void goTo2ndVideoPage(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(17));
        stopM(mediaType);
    }
  
   

}

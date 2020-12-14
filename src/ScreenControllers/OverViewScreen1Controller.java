/*
 * This is OverViewScreen1Controller class
 */
package ScreenControllers;

import JavaLogicMethod.ControlledScreen;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import tourismapp.TourismApp;

/**
 * @author ZuoyunJin(16825)
 */
public class OverViewScreen1Controller extends OverViewMainScreenController implements Initializable, ControlledScreen {
    
    
    protected String mediaType="audio";
    //Stroe music file path to a string
    private String musicFilePath = ".\\src\\Media\\Music\\m2.mp3";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initialize audio player
        initializeAudio(musicFilePath);
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
    private void goDiscoverHotel(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(16));
        stopM(mediaType);

    }


}

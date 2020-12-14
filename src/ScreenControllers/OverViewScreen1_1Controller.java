/*
 * This is OverViewScreen1_1Controller class
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
public class OverViewScreen1_1Controller extends OverViewScreen1Controller implements Initializable, ControlledScreen {

    //Stroe music file path to a string
    private String musicFilePath = ".\\src\\Media\\Music\\m1.mp3";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initialize audio player
        initializeAudio(musicFilePath);

    }

    @FXML
    private void goDiscoverGarden(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(13));
        stopM(mediaType);

    }

}

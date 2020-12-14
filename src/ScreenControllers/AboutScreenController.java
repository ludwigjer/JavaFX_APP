/*
 * This is AboutScreenController class
 */
package ScreenControllers;

import JavaLogicMethod.ControlledScreen;
import JavaLogicMethod.ProgramLogicController;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import tourismapp.ScreensController;
import tourismapp.TourismApp;

/**
 * @author ZuoyunJin(16825)
 */
public class AboutScreenController extends ProgramLogicController implements Initializable, ControlledScreen {

    @FXML
    Pane profileImage = new Pane();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set image from file and add to A pane in FXML
        File profieImage = new File(".\\src\\Media\\images\\dorset.png");
        Image image = new Image(profieImage.toURI().toString());
        javafx.scene.image.ImageView imageView = new javafx.scene.image.ImageView(image);
        imageView.setFitWidth(120);
        imageView.setFitHeight(120);
        profileImage.getChildren().add(imageView);
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

}

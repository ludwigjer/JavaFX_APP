/*
 * This is OverViewScreen2Controller class
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
public class OverViewScreen2Controller extends OverViewMainScreenController implements Initializable,ControlledScreen 
{   
    //Stroe image file path to a string
    private String filePath = ".\\src\\Media\\GalleryImage";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {   //initialize gallery
        initializeGallery(filePath);
    }

    @FXML
    private void back(ActionEvent event)
    { 
       controller.setScreen(TourismApp.screenIDList.get(12));
       
    }        

}
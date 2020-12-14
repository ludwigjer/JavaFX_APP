/*
 *This is ScreensController class
 */
package tourismapp;

import JavaLogicMethod.ControlledScreen;
import java.util.HashMap;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author ZuoyunJin(16825)
 */
//set type ScreensController to StackPane
public class ScreensController extends StackPane {

    //String is the ID of the screen,Node is the (FXML)route of the scene graph for that particular screen
    private HashMap<String, Node> screensHashMap = new HashMap<>();
    
    private final DoubleProperty opacity = opacityProperty();
    
    public ScreensController() {
        super();
    }

    //Add screens to collection
    public void addScreen(String name, Node screen) {
        screensHashMap.put(name, screen);
    }

    //Returns the Node with name
    public Node getScreen(String name) {
        return screensHashMap.get(name);
    }
    
    //This method will loads fxml, add screen to collection also injects screenPane to controller.
    //String name is the ID of the screen,String resource is FXML route
    public boolean loadScreen(String name, String resource) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = (Parent) fxmlLoader.load();
            //Once the screen is loaded get the controller from the Parent and cast to a contorlledscreen
            ControlledScreen screenControler = ((ControlledScreen) fxmlLoader.getController());
            //(this) injects the main screen controller to each screen(screenControler),so each secreen knows how to get here for transition between screens.
            screenControler.setScreenParent(this);
            //Add screen to hashmap(not added to the scene graph yet)
            addScreen(name, loadScreen);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    
    
    //This method will displayed the screen.
    //1st it check if screen is loaded already,if not print:"Can't find screen, check you screensHashMap"
    //if there are more than one screen then remove the current screen and add now one.(screen transitioning)
    //If there isn't any screen being displayed, the new screen is just added to the root.(1st time load)
    public boolean setScreen(final String name) {      
        //Makes sure the screen has been already loaded.
        if (screensHashMap.get(name) != null) {   
           
            //if there is more than one screen,like transitioning form on screen to another
            if (!getChildren().isEmpty()) { 
                //Fadeout animation which change screen opacity during 1sc from 1 to 0
                Timeline fadeOut = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        //when the animation finish the EventHandler will trigger the handle method
                        new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        //remove the displayed screen
                        getChildren().remove(0);
                        //add the new screen
                        getChildren().add(0, screensHashMap.get(name));     
                        //Fadein animation which change screen opacity during 1sc from 0 to 1
                        fedeIn(0.0,1.0,1000);
                    }
                }, new KeyValue(opacity, 0.0)));
                fadeOut.play();
             //None of screen displayed, then show screen,like the 1st time we lauch the program
            } else {
                       
                //getChildren for scene graph and add screen form screensHashMap
                getChildren().add(screensHashMap.get(name));  
                //Fadein animation which change screen opacity during 2sc from 0 to 1
                setOpacity(0.0);   
                fedeIn(0.0,1.0,2000);
            }
            return true;
        } else {
            //if screen is not in screensHashMap
            System.out.println("Can't find screen, check you screensHashMap");
            return false;
        }
   
   
    }
     //Fadein animation
    private void fedeIn(double opacityB,double opacityA,int duration){    
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, opacityB)),
                        new KeyFrame(new Duration(duration), new KeyValue(opacity,opacityA)));
                fadeIn.play();       
    }
    
    

    //This method will remove the screen with (String name) from the screensHashMap
    public boolean unloadScreen(String name) {
        if (screensHashMap.remove(name) == null) {
            System.out.println("Can't find screen in screensHashMap");
            return false;
        } else {
            return true;
        }
    }
}
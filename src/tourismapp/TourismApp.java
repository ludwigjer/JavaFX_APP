/*
 *This is an application for Powerscourt
 */
package tourismapp;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ZuoyunJin(16825)
 */
public class TourismApp extends Application {

    //Initializ stage
    Stage window;

    //Create lists to store screen variables
    public static ArrayList<String> screenIDList = new ArrayList<>();
    public static ArrayList<String> screenFileList = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        /*
        Screen index
        #0 IntroductionScreen
        #1 LoginScreen
        #2 MenuScreen
        #3 AboutScreen
        #4 QRCodeScreen
        #5 QuizScreen
        #6 EndScreen
        #7 TransportScreen
        #8 FoodAndStayMainScreen
        #9 FoodAndStayScreen1 food
        #10 FoodAndStayScreen2 stay
        #11 BookingTourScreen
        #12 OverViewMainScreen
        #13 OverViewScreen1 discover garden
        #14 OverViewScreen2 gallary
        #15 OverViewScreen3 video garden
        #16 OverViewScreen1_1 discover hotel
        #17 OverViewScreen3_1 discover waterfall
         */

        //Store string in to list
        screenIDList.add("IntroductionScreen");
        screenIDList.add("LoginScreen");
        screenIDList.add("Menu");
        screenIDList.add("About");
        screenIDList.add("QRCodeScreen");
        screenIDList.add("QuizScreen");
        screenIDList.add("EndScreen");
        screenIDList.add("TransportScreen");
        screenIDList.add("FoodAndStayMainScreen");
        screenIDList.add("FoodAndStayScreen1");
        screenIDList.add("FoodAndStayScreen2");
        screenIDList.add("BookingTourScreen");
        screenIDList.add("OverViewMainScreen");
        screenIDList.add("OverViewScreen1");
        screenIDList.add("OverViewScreen2");
        screenIDList.add("OverViewScreen3");
        screenIDList.add("OverViewScreen1_1");
        screenIDList.add("OverViewScreen3_1");

        //Store string in to list
        screenFileList.add("IntroductionScreen.fxml");
        screenFileList.add("LoginScreen.fxml");
        screenFileList.add("MenuScreen.fxml");
        screenFileList.add("AboutScreen.fxml");
        screenFileList.add("QRCodeScreen.fxml");
        screenFileList.add("QuizScreen.fxml");
        screenFileList.add("EndScreen.fxml");
        screenFileList.add("TransportScreen.fxml");
        screenFileList.add("FoodAndStayMainScreen.fxml");
        screenFileList.add("FoodAndStayScreen1.fxml");
        screenFileList.add("FoodAndStayScreen2.fxml");
        screenFileList.add("BookingTourScreen.fxml");
        screenFileList.add("OverViewMainScreen.fxml");
        screenFileList.add("OverViewScreen1.fxml");
        screenFileList.add("OverViewScreen2.fxml");
        screenFileList.add("OverViewScreen3.fxml");
        screenFileList.add("OverViewScreen1_1.fxml");
        screenFileList.add("OverViewScreen3_1.fxml");

        window = primaryStage;

        //Create a ScreensController
        ScreensController mainContainer = new ScreensController();

        //Load FXML and store in screensHashMap whitout adding to the scene graph
        for (int i = 0; i < screenIDList.size(); i++) {
            mainContainer.loadScreen(TourismApp.screenIDList.get(i), TourismApp.screenFileList.get(i));
        }

        //Show 1st screen :  IntroductionScreen
        mainContainer.setScreen(TourismApp.screenIDList.get(0));

        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

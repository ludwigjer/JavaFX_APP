/*
 * This is QuizScreenController class
 */
package ScreenControllers;

import JavaLogicMethod.ControlledScreen;
import JavaLogicMethod.ProgramLogicController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import tourismapp.ScreensController;
import tourismapp.TourismApp;

/**
 * @author ZuoyunJin(16825)
 */
public class QuizScreenController extends ProgramLogicController implements Initializable, ControlledScreen {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        quizAnswerOpacity(0);
        clearAllQuizChecker();
    }

    //Set the parent so each seceen know who their parent is.
    public void setScreenParent(ScreensController screenParent) {
        controller = screenParent;
    }

    @FXML
    //go to IntroductionScreen
    private void logOut(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(0));
        quizAnswerOpacity(0);
        clearAllQuizChecker();
        clearTextfield(5);
        
    }

    @FXML
    private void goToMenu(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(2));
        clearAllQuizChecker();
        quizAnswerOpacity(0);
        clearTextfield(5);
    }

    @FXML
    //check the answer of the quiz
    private void checkAnswers(ActionEvent event) {
        clearAllQuizChecker();
        quizAnswerCheck("quizAswer1");
        quizAnswerCheck("quizAswer2");
        quizAnswerCheck("quizAswer3");
        quizAnswerCheck("quizAswer4");
        
        
        
    }

    @FXML
    //show the answer of the quiz
    private void showAnswers(ActionEvent event) {
        quizAnswerOpacity(1);
        clearAllQuizChecker();
        
    
    }
    
    
    @FXML
    private void goToEnd(ActionEvent event) {
        controller.setScreen(TourismApp.screenIDList.get(6));
        clearAllQuizChecker();
        quizAnswerOpacity(0);
        clearTextfield(5);
    }

}

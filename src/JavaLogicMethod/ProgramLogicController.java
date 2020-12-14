/*
 * This is ProgramLogicController class,which most of program logic is stroed here
 */
package JavaLogicMethod;

import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import tourismapp.ScreensController;
import tourismapp.TourismApp;

/**
 *
 * @author ZuoyunJin(16825)
 */
public class ProgramLogicController{

    @FXML
    private Text errorMessage, textMessage, errorMessageInputCheck;

    @FXML
    private JFXTextField numberOfPeople, date, time, quizAswer1, quizAswer2, quizAswer3, quizAswer4;

    @FXML
    private Label labelAswer1, labelAswer2, labelAswer3, labelAswer4;

    @FXML
    private FontAwesomeIconView quizAnswerWrong1, quizAnswerWrong2, quizAnswerWrong3, quizAnswerWrong4, quizAnswerRight1, quizAnswerRight2, quizAnswerRight3, quizAnswerRight4;

    @FXML
    private ImageView accessDenied;

    @FXML
    private TextField nameTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    protected ChoiceBox choiceBox;

    @FXML
    protected DatePicker inDate, outDate;

    //initilize controller
    public ScreensController controller;

    //set boolean varriables for regex matchs to false(use for booking tour,dinner and hotel checking)   
    private boolean numberOfPeopleMatch = false;
    private boolean dateMatch = false;
    private boolean timeMatch = false;

    //set a counter to count checkin and out date by using one patten
    //if dateMatch twice true dateMatchCounter = 2;if not it will reset
    private int dateMatchCounter;

    //This 3 args method works for booking your tour screen
    //the 3 args will pass to regexChecker method then pass to its swich case to change boolean varriable above,
    //each the method is called it will rest the boolean varriable above to false and dateMatchCounter to 0
    //it 1st check if textfiled is empty,if so error message will appare by changing opacty from 0 to 1
    //if all textfiled are filled then it will check if filled text matchs the regex patten,
    //if so text message with user booking info will appare on screen,else the another error message will appare
    protected void checkInput(String ifNumberOfPeopleMatch, String ifDateMatch, String ifTimeMatch) {
        errorMessageOpacity(0, 0);
        changeTextMessage("");
        
        if (numberOfPeople.getText().isEmpty() || date.getText().isEmpty() || time.getText().isEmpty()) {
            errorMessageOpacity(1, 0);

        } else {
            resetMatch();
            Datahouse numberOfPeoplePattern = new Datahouse(11,"numberOfPeoplePattern");
            Datahouse datePattern = new Datahouse(11,"datePattern");
            Datahouse timePatternTour = new Datahouse(11,"timePattern");
            
            regexChecker(numberOfPeoplePattern.getRegex(), numberOfPeople.getText(), ifNumberOfPeopleMatch);
            regexChecker(datePattern.getRegex(), date.getText(), ifDateMatch);
            regexChecker(timePatternTour.getRegex(), time.getText(), ifTimeMatch);

            if (numberOfPeopleMatch && dateMatch && timeMatch) {

                errorMessageOpacity(0, 0);
                textMessage.setText("You are " + numberOfPeople.getText() + " people, and you have arranged us on " + date.getText() + " at " + time.getText());
                clearTextfield(11);

            } else {
                changeTextMessage("");
                errorMessageOpacity(0, 1);
            }
        }
        dateMatchCounter = 0;
    }

    //This 2 args method works for booking your dinner
    //the 2 args will pass to regexChecker method then pass to its swich case to change boolean varriable above,
    //each the method is called it will rest the boolean varriable above to false and dateMatchCounter to 0
    //it 1st check if textfiled is empty,if so error message will appare by changing opacty from 0 to 1
    //if all textfiled are filled then it will check if filled text matchs the regex patten,
    //if so text message with user booking info will appare on screen,else the another error message will appare
    protected void checkInput(String ifNumberOfPeopleMatch, String ifTimeMatch) {
        errorMessageOpacity(0, 0);
        changeTextMessage("");

        if (numberOfPeople.getText().isEmpty() || time.getText().isEmpty()) {
            errorMessageOpacity(1, 0);

        } else {
            resetMatch();
            Datahouse numberOfPeoplePattern = new Datahouse(9,"numberOfPeoplePattern");
            Datahouse timePatternTour = new Datahouse(9,"timePattern");
            
            regexChecker(numberOfPeoplePattern.getRegex(), numberOfPeople.getText(), ifNumberOfPeopleMatch);
            regexChecker(timePatternTour.getRegex(), time.getText(), ifTimeMatch);

            if (numberOfPeopleMatch && timeMatch) {

                errorMessageOpacity(0, 0);
                textMessage.setText("You are " + numberOfPeople.getText() + " people, and you have booked dinner at " + time.getText());
                clearTextfield(9);

            } else {
                changeTextMessage("");
                errorMessageOpacity(0, 1);
            }

        }
        dateMatchCounter = 0;
    }

    //This single arg method works for booking your hotel
    //the arg will pass to regexChecker method then pass to its swich case to change boolean varriable above,
    //each the method is called it will rest the boolean varriable above to false and dateMatchCounter to 0
    //it 1st check if checkin date is after checkout date,if so error message will appare by changing opacty from 0 to 1
    //if checkin date is before checkout date then it will check if checkin and out date matchs the regex patten(datePickerPattern),
    //if they match and dateMatchCounter = 2(means both date match at once,because dateMatchCounter reset to 0 every time method is called)
    //then a text message with user booking info will appare on screen,else the another error message will appare
    protected void checkInput(String ifDateMatch) {
        if (inDate.getValue().isAfter(outDate.getValue())) {
            errorMessageOpacity(1, 0);
            changeTextMessage("");
        } else {
            resetMatch();
             Datahouse datePattern = new Datahouse(10,"datePattern");
            regexChecker(datePattern.getRegex(), inDate.getValue().toString(), ifDateMatch);
            regexChecker(datePattern.getRegex(), outDate.getValue().toString(), ifDateMatch);

            if (dateMatch && dateMatchCounter == 2) {

                errorMessageOpacity(0, 0);
                changeTextMessage("You have booked " + choiceBox.getValue().toString() + ", you will check in at " + inDate.getValue().toString() + " and check out at " + outDate.getValue().toString());

            } else {
                changeTextMessage("");
                errorMessageOpacity(0, 1);
            }
        }
        dateMatchCounter = 0;
    }

    //This method works for login screen and checks user name and pw by using compareTo 
    //which stores ompare strings result into int,if the strings are the same,int=0
    //so if user name and ps are the same as they store in system,program will lauch the menu screen
    //if not a accessDenied image will be load by accessDenied()method and appare on the screen
    protected void loginCheck() {
        Datahouse userLoginInfo = new Datahouse();
        int compareID = userLoginInfo.getId().compareTo(nameTextField.getText());
        int comparePassword = userLoginInfo.getPw().compareTo(passwordField.getText());

        if (compareID == 0 && comparePassword == 0) {
            accessDenied(0);
            nameTextField.clear();
            passwordField.clear();
            controller.setScreen(TourismApp.screenIDList.get(2));
        } else {

            accessDenied(0.5);
            System.out.println("\nWrong code check and do it again!!!!!!!!\n");
        }

    }

    
    //This method use compareTo and compareToIgnoreCase method to check quiz answers
    //using switch to find which textfield to look at
    //if the text field is empty,or the value of compareTo is not 0 (which means the 2 string are  not the same)
    //the right checker markers opacity will change to 0 and the  wrong markers will be 1
    //else right checker markers opacity will change to 1 and the  wrong markers will be 0
    protected void quizAnswerCheck(String quizAswer) {
         Datahouse quizInfo = new Datahouse();
        switch (quizAswer) {
            case "quizAswer1":
            int quiz1 = quizInfo.getQuizAnswer1().compareTo(quizAswer1.getText());
                if (quizAswer1.getText().isEmpty() || quiz1 != 0 ) {
                    quizAnswerCheckerOpacity(0, 1, 1); 
                } else {
                    quizAnswerCheckerOpacity(1, 0, 1); 
                }
                break;
            case "quizAswer2":
             int quiz2 = quizInfo.getQuizAnswer2().compareToIgnoreCase(quizAswer2.getText());
                if (quizAswer1.getText().isEmpty() || quiz2 != 0 ) {
                    quizAnswerCheckerOpacity(0, 1, 2); 
                } else {
                    quizAnswerCheckerOpacity(1, 0, 2); 
                }

                break;
            case "quizAswer3":
                 int quiz3 = quizInfo.getQuizAnswer3().compareTo(quizAswer3.getText());
                if (quizAswer1.getText().isEmpty() || quiz3 != 0 ) {
                    quizAnswerCheckerOpacity(0, 1, 3); 
                } else {
                    quizAnswerCheckerOpacity(1, 0, 3); 
                }
                break;
            case "quizAswer4":
                 int quiz4 = quizInfo.getQuizAnswer4().compareToIgnoreCase(quizAswer4.getText());
                if (quizAswer1.getText().isEmpty() || quiz4 != 0 ) {
                    quizAnswerCheckerOpacity(0, 1, 4); 
                } else {
                    quizAnswerCheckerOpacity(1, 0, 4); 
                }
                break;
            default:
        }

    }

    //This method take 3 args will check if the str2Check matchs the theRegex
    //theRegex :regex patten
    //str2Check :input string
    //the 3rd arg nameOfMatch which defined which switch to pass and change is value of boolean vairrables
    //and for ifDateMatch case it will increase dateMatchCounter by 1 each time
    protected void regexChecker(String theRegex, String str2Check, String nameOfMatch) {
        // Define regular expression (REGEX) using Pattern
        Pattern checkRegex = Pattern.compile(theRegex);
        // Creates a Matcher object that searches the String for
        // anything that matches the REGEX
        Matcher regexMatcher = checkRegex.matcher(str2Check);

        while (regexMatcher.find()) {
            if (regexMatcher.group().length() != 0) {

                switch (nameOfMatch) {
                    case "ifNumberOfPeopleMatch":
                        numberOfPeopleMatch = true;
                        break;
                    case "ifDateMatch":
                        dateMatch = true;
                        dateMatchCounter++;

                        break;
                    case "ifTimeMatch":
                        timeMatch = true;
                        break;
                    default:
                }
            }
        }
    }

    //This method rest boolean value numberOfPeopleMatch ,dateMatch ,timeMatch to false
    protected void resetMatch() {
        numberOfPeopleMatch = false;
        dateMatch = false;
        timeMatch = false;
    }

    //This method take 2 args which changes the opacity of 2 different errorMessage
    //for screen booking your tour,booking your dinner ,booking your holtel 
    protected void errorMessageOpacity(int opacity, int errorMessageOpacity) {
        errorMessage.setOpacity(opacity);
        errorMessageInputCheck.setOpacity(errorMessageOpacity);
    }

    protected void errorMessageOpacity(int opacity) {
        errorMessage.setOpacity(opacity);
    }

    protected void changeTextMessage(String content) {
        textMessage.setText(content);
    }

    //This method takes 2 args to clear textfield for screen #5,#9 and #11 by swtich different case
    protected void clearTextfield(int screen) {

        switch (screen) {
            case 5:
                quizAswer1.clear();
                quizAswer2.clear();
                quizAswer3.clear();
                quizAswer4.clear();
                break;
            case 9:
                numberOfPeople.clear();
                time.clear();
                break;
            case 11:
                date.clear();
                numberOfPeople.clear();
                time.clear();
                break;
            
            default:
        }

    }

    //This method opens websie in browse
    protected void openWeb(String website) {
         Datahouse webSite = new Datahouse(website);
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(webSite.getWebSite()));
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (URISyntaxException e1) {
                e1.printStackTrace();
            }
        }

    }

    
    
    
    
    //this method set opactiry to quiz |ico ,int index here tells which line of ico
    protected void quizAnswerCheckerOpacity(int right, int wrong, int index) {

        switch (index) {
            case 1:
                quizAnswerRight1.setOpacity(right);
                quizAnswerWrong1.setOpacity(wrong);
                break;
            case 2:
                quizAnswerRight2.setOpacity(right);
                quizAnswerWrong2.setOpacity(wrong);
                break;
            case 3:
                quizAnswerRight3.setOpacity(right);
                quizAnswerWrong3.setOpacity(wrong);
                break;
            case 4:
                quizAnswerRight4.setOpacity(right);
                quizAnswerWrong4.setOpacity(wrong);
                break;
            default:
        }
    }
    
    
      protected void clearAllQuizChecker(){
        quizAnswerCheckerOpacity(0, 0, 1);
        quizAnswerCheckerOpacity(0, 0, 2);
        quizAnswerCheckerOpacity(0, 0, 3);
        quizAnswerCheckerOpacity(0, 0, 4);
      
    }
      protected void quizAnswerOpacity(int opacity) {
        labelAswer1.setOpacity(opacity);
        labelAswer2.setOpacity(opacity);
        labelAswer3.setOpacity(opacity);
        labelAswer4.setOpacity(opacity);

    }

    protected void accessDenied(double opacity) {
        accessDenied.setOpacity(opacity);

    }

}

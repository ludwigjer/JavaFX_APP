/*
 * This is JavaMultimediaController class where most of multimedia code is stored here
 */
package JavaLogicMethod;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 * @author ZuoyunJin(16825)
 */
public class JavaMultimediaController extends ProgramLogicController {

    //create mediaplyer for audio and video
    private MediaPlayer musicplayer, videoplayer;

    @FXML
    private StackPane imageStackPane;

    @FXML
    private ScrollPane imageSlider;

    @FXML
    private Pane video1;
    
    
    //The methold works for the OverViewScreen1 and OverViewScreen1_1 
    //which load audio file to MediaPlayer(musicplayer) 
    protected void initializeAudio(String filePath) {
        File file = new File(filePath);
        Media media = new Media(file.toURI().toString());
        musicplayer = new MediaPlayer(media);
        musicplayer.setAutoPlay(false);
        musicplayer.setVolume(0.1);
    }
   //The methold works for the OverViewScreen3 and OverViewScreen3_1 
   //which load video file to MediaPlayer(videoplayer) and set videoplayer
   //to mediaView and add the mediaView to a pane in FXML
    protected void initializeVideo(String filePath) {
        File file = new File(filePath);
        Media media = new Media(file.toURI().toString());
        videoplayer = new MediaPlayer(media);
        videoplayer.setAutoPlay(false);
        videoplayer.setVolume(0.1);
        MediaView mediaView = new MediaView(videoplayer);
        mediaView.setMediaPlayer(videoplayer);
        mediaView.setFitWidth(400);
        video1.getChildren().add(mediaView);
    }

    
    //The methold works for the OverViewScreen2 which load all images form folder
    //and list them in a tilePane and added into imageSlider on the top screen in FXML
    protected void initializeGallery(String filePath) {
        File folder = new File(filePath);
        File[] listOfFiles = folder.listFiles();
        TilePane tilePane = new TilePane();
        //set the horizontal and vertical gap to images
        tilePane.setHgap(1);
        tilePane.setVgap(1);
        //set the MaxWidth and MaxHeight to the celection area
        tilePane.setMaxWidth(1200);
        tilePane.setMaxHeight(200);
        //add all image to imageView
        for (int i = 0; i < listOfFiles.length; i++) {
            Image img = new Image(listOfFiles[i].toURI().toString());
            NewImageView topImageView = new NewImageView(img);
            topImageView.setImagePath(listOfFiles[i].toURI().toString());
            topImageView.setFitHeight(100);
            topImageView.setFitWidth(100);
            topImageView.setPreserveRatio(true);
            tilePane.getChildren().add(topImageView);
            addEventToImageView(topImageView);
        }

        // hide horizontal and vertical scroll bar
        imageSlider.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        imageSlider.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        imageSlider.setContent(tilePane);
    }
    //The methold works for the OverViewScreen2 which add a MOUSE_CLICKED event to images
    //when top image are clicked it will trigger an event which add bottonImageView on the 
    //botton in imageStackPane in FXML
    protected void addEventToImageView(ImageView img) {
        img.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                NewImageView imageView = (NewImageView) event.getSource();
                //get path of top image clicked one
                Image img = new Image(imageView.getImagePath());
                ImageView bottonImageView = new ImageView(img);
                bottonImageView.setFitHeight(imageStackPane.getHeight());
                bottonImageView.setFitWidth(imageStackPane.getWidth());
                bottonImageView.setPreserveRatio(true);
                imageStackPane.getChildren().clear();
                imageStackPane.getChildren().add(bottonImageView);
                event.consume();

            }
        }
        );

    }

    @FXML
    //audio button acction play
    private void playM(ActionEvent event) {
        musicplayer.play();
    }

    @FXML
    //audio button acction pause
    private void pauseM(ActionEvent event) {
        musicplayer.pause();
    }

    @FXML
    //audio button acction stop
    private void stopM(ActionEvent event) {
        musicplayer.stop();
    }

    //This method stop play media by defineding media type(take arg and pass to switch case)
    protected void stopM(String videoOrAudio) {
        switch (videoOrAudio) {
            case "video":
                videoplayer.stop();
                break;
            case "audio":
                musicplayer.stop();
                break;

            default:

        }

    }

    @FXML
    //video button acction play
    private void playV(ActionEvent event) {
        videoplayer.play();
        videoplayer.setRate(1);
    }

    @FXML
    //video button acction pause
    private void pauseV(ActionEvent event) {
        videoplayer.pause();
    }

    @FXML
    //video button acction fast
    private void fastV(ActionEvent event) {
        videoplayer.setRate(2);
    }

    @FXML
    //video button acction slow
    private void slowV(ActionEvent event) {
        videoplayer.setRate(.5);
    }

    @FXML
    //video button acction reload
    private void reloadV(ActionEvent event) {
        videoplayer.seek(videoplayer.getStartTime());
        videoplayer.play();
    }

    @FXML
    //video button acction stop
    private void stopV(ActionEvent event) {
        videoplayer.stop();
    }

    @FXML
    //video button acction start
    private void startV(ActionEvent event) {
        videoplayer.seek(videoplayer.getStartTime());
        videoplayer.pause();
    }

    @FXML
    //video button acction slast
    private void lastV(ActionEvent event) {
        videoplayer.seek(videoplayer.getTotalDuration());
        videoplayer.pause();
    }
}

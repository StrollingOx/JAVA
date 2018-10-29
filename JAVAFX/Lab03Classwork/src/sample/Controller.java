package sample;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.transform.Rotate;


import java.net.URL;
import java.util.ResourceBundle;

import java.io.File;

import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.media.Media;
import javafx.scene.control.Slider;

public class Controller implements Initializable {
    @FXML private Ellipse ela;
    @FXML private MediaView media;
    private MediaPlayer mp;
    private Media me;

    @FXML private Slider vs;

    @FXML private Circle cir1;
    @FXML private Circle cir2;
    @FXML private Image img = new Image("media/knobimg.jpg");




    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        //video
        String videopath = new File("src/media/video.mp4").getAbsolutePath(); //.getAbsolutePath ??? Sprawia, że działa
        me = new Media(new File(videopath).toURI().toString()); //toURI().toString() ??? ^
        mp = new MediaPlayer(me);
        media.setMediaPlayer(mp);
        mp.setAutoPlay(true);
        DoubleProperty width = media.fitWidthProperty();
        DoubleProperty height = media.fitHeightProperty();
        width.bind(Bindings.selectDouble(media.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(media.sceneProperty(), "height"));




        //volume slider
        vs.setValue(mp.getVolume()*100);
        vs.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                mp.setVolume(vs.getValue()/100);
            }
        });

        //filling knobsliders with texture
        cir1.setFill(new ImagePattern(img));
        cir2.setFill(new ImagePattern(img));
        cir2.getTransforms().add(new Rotate(-60));
        /*
        //rotation of the knobs
        cir2.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                if (event.getX()>0)
                    cir2.getTransforms().add(new Rotate(120));

                if (event.getX()<0)
                    cir2.getTransforms().add(new Rotate(-120));

            }
        });

        cir1.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                if (event.getX()>0)
                    cir1.getTransforms().add(new Rotate(5));
                if (event.getX()<0)
                    cir1.getTransforms().add(new Rotate(-5));
                if (cir1.getTransforms().equals(new Rotate(45)))
                {
                    //jezeli miesci sie w przedziale (?) odtworz film.
                }
            }
        });
        */

    }
}
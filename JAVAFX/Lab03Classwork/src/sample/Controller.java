package sample;


import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Transform;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller  {
    @FXML private Circle cir1;
    @FXML private Circle cir2;
    @FXML private Rectangle vidScreen;
    @FXML private Image img = new Image("knobimg.jpg");
    @FXML private Slider vs;
    @FXML private MediaView mv;
    private MediaPlayer mp;
    File f = new File("video.mp4");



    public void initialize() throws Exception
    {
        Media media = new Media(f.toURI().toURL().toString());
        mp = new  MediaPlayer(media);
        mv = new MediaView(mp);
        mp.play();

        vs.setValue(mp.getVolume()*100);
        vs.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                mp.setVolume(vs.getValue()/100);
            }
        });



        cir1.setFill(new ImagePattern(img));
        cir2.setFill(new ImagePattern(img));
        cir2.getTransforms().add(new Rotate(-60));

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


    }
}

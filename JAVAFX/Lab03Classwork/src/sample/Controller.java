package sample;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Transform;
import sun.plugin2.util.ColorUtil;


public class Controller  {
@FXML private Circle cir1;
@FXML private Circle cir2;
@FXML private Image img = new Image("knobimg.jpg");



    public void initialize()
    {
        cir1.setFill(new ImagePattern(img));
        cir2.setFill(new ImagePattern(img));
        cir2.getTransforms().add(new Rotate(-60));

        cir2.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                if (event.getX()>0)
                    cir2.getTransforms().add(new Rotate(1));
                if (event.getX()<0)
                    cir2.getTransforms().add(new Rotate(-1));
            }
        });

        cir1.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                if (event.getX()>0)
                    cir1.getTransforms().add(new Rotate(1));
                if (event.getX()<0)
                    cir1.getTransforms().add(new Rotate(-1));
                if (cir1.getTransforms().equals(new Rotate(45)))
                {
                    //jezeli miesci sie w przedziale (?) odtworz film.
                }
            }
        });


    }
}

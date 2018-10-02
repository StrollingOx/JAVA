package sample;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class lab01_1 extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        BorderPane root = new BorderPane();

        Button l = new Button("Left");
        l.setPrefSize(100,Double.MAX_VALUE);
        root.setLeft(l);

        Button t = new Button("Top");
        t.setPrefSize(Double.MAX_VALUE, 50);
        root.setTop(t);
        
/*
        root.setLeft(new Button("L"));
        root.setRight(new Button("R"));
        root.setTop(new Button("T"));
        root.setBottom(new Button("B"));
        root.setCenter(new Button("C"));
*/

        Scene scene = new Scene(root, 300,250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(300);
        primaryStage.show();

    }


    public static void main(String[] args) { launch(args); }
}

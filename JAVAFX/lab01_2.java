package sample;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class lab01_2 extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        BorderPane root = new BorderPane();
        GridPane Buttons = new GridPane();
        for(int i=0;i<5;i++)
        {
            Button b = new Button("Button " + i);
            b.setPrefSize(100,100);
            Buttons.addRow(i,b);
        }

        root.setCenter(Buttons);
        Scene scene = new Scene(root, 300,250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(300);
        primaryStage.show();

    }


    public static void main(String[] args) { launch(args); }
}

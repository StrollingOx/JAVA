package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        BorderPane root = new BorderPane();
        GridPane buttons = new GridPane();
        GridPane textFields = new GridPane();
        //LEFT BUTTONS
        Label l0 = new Label("Narzędzia");
        buttons.addRow(1,l0);

        Button b1 = new Button("Przetwarzaj!" );
        b1.setPrefSize(10000,500);
        buttons.addRow(2,b1);

        Button b2 = new Button("Wyszyść źródło" );
        b2.setPrefSize(10000,500);
        buttons.addRow(3,b2);

        Button b3 = new Button("Pomoc");
        b3.setPrefSize(10000,500);
        b3.setDisable(true);
        buttons.addRow(4,b3);

        Button b4 = new Button("O programie" );
        b4.setPrefSize(10000,500);
        buttons.addRow(5,b4);

        Button b5 = new Button("Zapisz i zakończ" );
        b5.setPrefSize(10000,500);
        buttons.addRow(6,b5);

        //RIGHT TEXTFIELDS
        Label l1 = new Label("Źródło");
        textFields.addRow(1,l1);

        TextArea tf1 = new TextArea();
        tf1.setPrefSize(300,500);
        textFields.addRow(2,tf1);

        Label l2 = new Label("Wynik");
        textFields.addRow(3,l2);

        TextArea tf2 = new TextArea();
        tf2.setPrefSize(300,500);
        textFields.addRow(4,tf2);

        buttons.setPadding(new Insets(0,5,0,0));
        root.setCenter(buttons);
        root.setRight(textFields);
        Scene scene = new Scene(root, 300,250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(800);
        primaryStage.show();
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    }


    public static void main(String[] args) { launch(args); }
}

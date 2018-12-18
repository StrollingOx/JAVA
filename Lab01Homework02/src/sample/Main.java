package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10,10,10,10));

        VBox buttonsBox = new VBox();
        buttonsBox.setPadding(new Insets(-10,20,20,20));

        VBox textFieldBox = new VBox();
        buttonsBox.setPadding(new Insets(-10,20,20,20));

        Label l1 = new Label("Narzędzia");

        Button b1 = new Button("Wstaw plik" );
        b1.setPrefSize(150,50);

        Button b2 = new Button("Usuń tekst" );
        b2.setPrefSize(150,50);

        Button b3 = new Button("Uruchom");
        b3.setDisable(true);
        b3.setPrefSize(150,50);

        Button b4 = new Button("Zapisz plik" );
        b4.setPrefSize(150,50);

        Button b5 = new Button("Pomoc" );
        b5.setPrefSize(150,50);

        Button b6 = new Button("O programie" );
        b6.setPrefSize(150,50);

        Button b7 = new Button("Koniec" );
        b7.setPrefSize(150,50);

        buttonsBox.getChildren().addAll(l1, b1, b2, b3, b4,b5,b6,b7);

        textFieldBox.setPadding(new Insets(-10,20,20,20));

        Label l2 = new Label("Pole tekstowe");

        TextArea ta1 = new TextArea();
        ta1.setPrefHeight(1000);
        ta1.setMaxWidth(350);

        textFieldBox.getChildren().addAll(l2,ta1);


        buttonsBox.setStyle("-fx-border-style: solid;\n" +
                "-fx-border-color: black;\n"+
                "-fx-content-display: top;");

        textFieldBox.setStyle("-fx-border-style: solid;\n" +
                "-fx-border-color: black;" );

        Region wall = new Region();
        wall.setMinWidth(20);
        root.setCenter(wall);
        root.setLeft(buttonsBox);
        root.setRight(textFieldBox);
        //root.setPadding(new Insets(20,5,5,5));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Przetwarzanie plików i tekstów");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(640);
        primaryStage.setMinHeight(440);
        primaryStage.setHeight(440);
        primaryStage.show();

        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

    }


    public static void main(String[] args) { launch(args); }
}

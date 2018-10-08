package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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

        Label l1 = new Label("Opcje uruchamiania");

        Button b1 = new Button("Uruchom przetwarzanie" );
        b1.setDisable(true);
        b1.setPrefSize(200,9999);

        Button b2 = new Button("Pomoc" );
        b2.setPrefSize(200,9999);

        Button b3 = new Button("O programie");
        b3.setPrefSize(200,9999);

        Button b4 = new Button("Zapisz i zakończ" );
        b4.setPrefSize(200,9999);

        buttonsBox.getChildren().addAll(l1, b1, b2, b3, b4);

        GridPane filePad = new GridPane();
        filePad.setPadding(new Insets(-10,20,20,20));

        Label l2 = new Label("Panel plików");
        Label l3 = new Label("Źródło");
        Label l4 = new Label("Wynik");

        Region space1 = new Region();
        space1.setPrefWidth(100);

        Region space2 = new Region();
        space2.setPrefHeight(10);

        Button b5 = new Button("Przeglądaj...");
        b5.setMaxWidth(150);

        Button b6 = new Button("Przeglądaj...");
        b6.setMaxWidth(150);

        TextField tf1 = new TextField();
        tf1.setMaxWidth(150);

        TextField tf2 = new TextField();
        tf2.setMaxWidth(150);

        filePad.add(l2,0,0);
        filePad.add(l3,0,1);
        filePad.add(l4,0,3);
        filePad.add(space1,1,0);
        filePad.add(space2,2,2);
        filePad.add(tf1,2,1);
        filePad.add(tf2,2,3);
        filePad.add(b5,3,1);
        filePad.add(b6,3,3);

        buttonsBox.setStyle("-fx-border-style: solid;\n" +
                "-fx-border-color: black;\n"+
                "-fx-content-display: top;");

        filePad.setStyle("-fx-border-style: solid;\n" +
                "-fx-border-color: black;" );

        Region wall = new Region();
        wall.setMinWidth(20);
        root.setCenter(wall);
        root.setLeft(buttonsBox);
        root.setRight(filePad);
        //root.setPadding(new Insets(20,5,5,5));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Narzędzie przetwarzania plików");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(740);
        primaryStage.setMinHeight(300);
        primaryStage.setHeight(300);
        primaryStage.show();

        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

    }


    public static void main(String[] args) { launch(args); }
}

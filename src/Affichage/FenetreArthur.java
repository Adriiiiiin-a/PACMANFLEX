package Affichage;

import Jeu.Fantome;
import Jeu.Partie;
import Outils.Entites;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.*;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Objects;

public class FenetreArthur extends Application {

    Scene sceneJeu, sceneMenu, sceneRecord, sceneOption;
    final int WIDTH = 782;
    final int HEIGHT =  465;
    Fantome[] tabFantome;

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Pacman");
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);

        // Menu principale


        GridPane root = new GridPane();
        root.setId("pane");


        for(int i=0;i<3;i++){
            ColumnConstraints column = new ColumnConstraints(260);//460
            root.getColumnConstraints().add(column);
        }

        for(int i=0;i<6;i++){
            RowConstraints row = new RowConstraints(73);//110
            root.getRowConstraints().add(row);
        }



        Button buttonPlay= new Button("Jouer");
        buttonPlay.setId("button");

        buttonPlay.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
        GridPane.setHalignment(buttonPlay, HPos.CENTER);
        buttonPlay.setOnAction(e -> primaryStage.setScene(sceneJeu));
        root.add(buttonPlay,1,2);


        Button buttonRecord = new Button("Records");
        buttonRecord.setId("button");
        buttonRecord.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
        GridPane.setHalignment(buttonRecord,HPos.CENTER);
        buttonRecord.setOnAction(e -> primaryStage.setScene(sceneRecord));
        root.add(buttonRecord,1,3);


        Button buttonOption = new Button("Comment jouer");
        buttonOption.setId("button");
        buttonOption.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
        GridPane.setHalignment(buttonOption,HPos.CENTER);
        root.add(buttonOption,1,4);




        sceneMenu = new Scene(root, 300, 250);





        // Page de jeu

        GridPane game = new GridPane();

        Partie p1 = new Partie();
        int x;

        for (int i = 0; i < 22; i++) {
            for (x = 0; x<22;x++) {
                Entites actualEntite = p1.getGrille()[i][x];
//                System.out.println(actualEntite);
                ImageView iv = new ImageView();
                if (actualEntite.equals(Entites.MUR)){
                    FileInputStream input = new FileInputStream("externes/images/MUR.png");
                    Image image = new Image(input,20,20 ,true,true);
                    iv.setImage(image);
                } else if (actualEntite.equals(Entites.PORTE)){
                    FileInputStream input = new FileInputStream("externes/images/FOND_BLANC.png");
                    Image image = new Image(input,20,20 ,true,true);
                    iv.setImage(image);
                }
                else{
                    FileInputStream inputN = new FileInputStream("externes/images/FOND_NOIR.png");
                    Image img = new Image(inputN,20,20 ,true,true);
                    iv.setImage(img);
                }
                game.add(iv, i, x);
            }
        }
        //Scene scene = new Scene(game, 440, 440);
        //stage.setScene(scene);


        tabFantome = p1.getFantome();

        game.add(tabFantome[0].getFantome(), tabFantome[0].getSpawnX(), tabFantome[0].getSpawnY());
        game.add(tabFantome[1].getFantome(), tabFantome[1].getSpawnX(), tabFantome[1].getSpawnY());
        game.add(tabFantome[2].getFantome(), tabFantome[2].getSpawnX(), tabFantome[2].getSpawnY());
        game.add(tabFantome[3].getFantome(), tabFantome[3].getSpawnX(), tabFantome[3].getSpawnY());




        Button buttonJeu= new Button("Maison");
        buttonJeu.setOnAction(e -> primaryStage.setScene(sceneMenu));


        GridPane grid = new GridPane();
        grid.add(game,0,0);

        GridPane gridPause = new GridPane();
        gridPause.setId("gridPause");
        GridPane.setHalignment(buttonJeu,HPos.RIGHT);
        GridPane.setValignment(buttonJeu, VPos.TOP);
        gridPause.add(buttonJeu,0,0);


        Button buttonPause = new Button("Pause");

        GridPane.setHalignment(buttonPause,HPos.LEFT);
        GridPane.setValignment(buttonPause, VPos.TOP);
        gridPause.add(buttonPause,0,0);


        Rectangle rectangleNom = new Rectangle(220,60);
        rectangleNom.setId("rectangle");
        rectangleNom.setStrokeWidth(3);
        rectangleNom.setFill(Color.YELLOW);
        GridPane.setHalignment(rectangleNom, HPos.CENTER);
        gridPause.add(rectangleNom,0,1);

        /*        Label labelNom = new Label("Liam");
        labelNom.setTextFill(Color.YELLOW);
        GridPane.setHalignment(labelNom, HPos.CENTER);
        gridPause.add(labelNom,0,1);*/






        ColumnConstraints columnPause = new ColumnConstraints(342);
        gridPause.getColumnConstraints().add(columnPause);

        for(int i=0; i<5;i++){
            RowConstraints row = new RowConstraints(88);
            gridPause.getRowConstraints().add(row);
        }



        grid.add(gridPause,1,0);



        game.setGridLinesVisible(true);
        grid.setGridLinesVisible(true);
        gridPause.setGridLinesVisible(true);


        sceneJeu = new Scene(grid,500,550);

        // Fin de page jeu





        //  Page Record



        GridPane gridRecord = new GridPane();
        gridRecord.setId("pane");


        for(int i=0;i<3;i++){
            ColumnConstraints column = new ColumnConstraints(260);//460
            gridRecord.getColumnConstraints().add(column);
        }

        for(int i=0;i<6;i++){
            RowConstraints row = new RowConstraints(73);//110
            gridRecord.getRowConstraints().add(row);
        }



        Button button2= new Button("Menu principale");
        button2.setId("button");
        button2.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
        GridPane.setHalignment(button2,HPos.CENTER);
        button2.setOnAction(e -> primaryStage.setScene(sceneMenu));

        gridRecord.add(button2,1,4);

        sceneRecord= new Scene(gridRecord,300,350);






        sceneMenu.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        sceneRecord.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setScene(sceneMenu);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}